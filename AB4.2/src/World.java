import java.util.*;

/**
 * Simulation world containing nest, food location and ants.
 *
 * <p>The world is represented as a two-dimensional coordinate system.
 * It provides access to all physical objects currently present in the world,
 * applies the boundary rule to states, and performs complete simulation
 * steps.</p>
 *
 * <p>This version of the world validates whether physical objects lie inside
 * the world. If unresolved collisions occur during a simulation step, they are
 * collected and reported by a {@link SimulationStepException}.</p>
 */
public class World implements Steppable {

    private int width;
    private int height;
    private Nest nest;
    private FoodSource food;
    private int currentStep;
    private List<Ant> ants;
    private Map<Ant, Double> distances;

    /**
     * Creates a new {@code World} object with {@code numberOfAnts} ants that will be generated at the nest position.
     *
     * @param width the width of the world; {@code width > 0}
     * @param height the height of the world; {@code height > 0}
     * @param numberOfAnts the number of ants in this world; {@code numberOfAnts > 0}
     * @param nest the nest; {@code nest != null}
     * @param food the food source; {@code food != null}
     * @throws IllegalArgumentException if at least one physical object does
     *         not lie completely inside the world boundaries
     */
    public World(
            int width,
            int height,
            int numberOfAnts,
            Nest nest,
            FoodSource food) {

        this.width = width;
        this.height = height;

        if (!this.isInsideWorld(nest)) {
            throw new IllegalArgumentException("Nest is outside of world boundaries");
        }

        if (!this.isInsideWorld(food)) {
            throw new IllegalArgumentException("Food is outside of world boundaries");
        }

        this.nest = nest;
        this.food = food;
        this.currentStep = 0;
        this.ants = new ArrayList<>(numberOfAnts);

        for (int i = 0; i < numberOfAnts; i++) {
            ants.add(new Ant(this));
        }

        this.distances = new HashMap<>();

        for (Ant ant : ants) {
            distances.put(ant, 0.0);
        }

    }

    /**
     * Performs one complete simulation step of this world.
     *
     * <p>The method increments the simulation step counter and invokes
     * {@link Ant#step()} for all ants stored in this world.</p>
     *
     * <p>If one or more ants throw an {@link UnresolvedCollisionException},
     * these exceptions are collected. After all ants have been processed, a
     * {@link SimulationStepException} containing all collected exceptions is
     * thrown.</p>
     *
     * @throws SimulationStepException if at least one unresolved collision
     *         occurred during this simulation step
     */
    @Override
    public void step() throws SimulationStepException {
        currentStep++;
        List<UnresolvedCollisionException> exceptions = new ArrayList<>();

        for (Ant ant : ants) {
            Vector2D position = ant.getPosition();
            try {
                ant.step();
            } catch (UnresolvedCollisionException e) {
                exceptions.add(e);
            }
            Vector2D newPosition = ant.getPosition();

            double v = position.distanceTo(newPosition);

            distances.compute(ant, (a, d) -> (d == null) ? v : d + v);
        }

        if (!exceptions.isEmpty()) {
            throw new SimulationStepException(currentStep, exceptions);
        }

    }

    /**
     * Returns the nest object.
     *
     * @return the nest
     */
    public Nest getNest() {
        return nest;
    }

    /**
     * Returns the food source object.
     *
     * @return the food source
     */
    public FoodSource getFood() {
        return food;
    }

    /**
     * Returns an independent (copy) collection of the ants of this world.
     *
     * @return the ants
     */
    public Collection<Ant> getAnts() {

        return new ArrayList<>(ants);
    }

    /**
     * Returns all physical objects currently present in this world.
     *
     * <p>The returned collection contains the nest, the food source, and all
     * ants. Each object occurs at most once.</p>
     *
     * <p>The order of the returned collection is unspecified.</p>
     *
     * @return a collection containing all physical objects in this world
     */
    public Collection<Physical> getPhysicals() {
        ArrayList<Physical> objects = new ArrayList<>();
        objects.add(nest);
        objects.add(food);
        objects.addAll(ants);
        return objects;
    }

    /**
     * Returns the total distances travelled by the ants of this world.
     *
     * <p>The returned map associates every ant currently known to this world
     * with the total distance travelled by that ant.</p>
     *
     * <p>The choice of the concrete map implementation is unspecified.</p>
     *
     * <p>The returned map is independent of the internal representation of
     * this world. Structural modifications of the returned map, such as adding,
     * removing or replacing entries, do not affect this world.</p>
     *
     * <p>The contained objects themselves are not copied.</p>
     *
     * @return a map associating each ant with its total travelled distance
     */
    public Map<Ant, Double> getTravelledDistances() {
        return new HashMap<>(distances);
    }

    /**
     * Applies the world's boundary rule to the given state.
     *
     * <p>If the position lies outside the world, it results in a new position
     * corresponding to the closest point on the boundary of the world and
     * a velocity vector whose affected component is inverted.</p>
     *
     * @param s the state to be adjusted; {@code s != null}
     * @return a new {@link State} whose position lies inside the world
     */
    public State enforceBoundary(State s) {

        Vector2D p = s.getPosition();
        Vector2D v = s.getVelocity();

        double x = p.getX();
        double y = p.getY();

        boolean bouncedX = false;
        boolean bouncedY = false;

        if (x < 0) {
            x = 0;
            bouncedX = true;
        } else if (x > width) {
            x = width;
            bouncedX = true;
        }

        if (y < 0) {
            y = 0;
            bouncedY = true;
        } else if (y > height) {
            y = height;
            bouncedY = true;
        }

        double vx = v.getX();
        double vy = v.getY();

        if (bouncedX) {
            vx = -vx;
        }

        if (bouncedY) {
            vy = -vy;
        }

        Vector2D newVelocity = new Vector2D(vx, vy);

        if (newVelocity.isZero()) {
            newVelocity = new Vector2D(1, 0);
        } else {
            newVelocity = newVelocity.normalize();
        }

        return new State(new Vector2D(x, y), newVelocity);
    }

    /**
     * Returns the current simulation step.
     *
     * @return the current simulation step
     */
    public int getCurrentStep() {

        return currentStep;
    }

    /**
     * Returns whether the specified physical object lies completely inside
     * the world boundaries.
     *
     * @param p the physical object; {@code p != null}
     * @return {@code true} iff {@code p} lies completely inside the world
     */
    private boolean isInsideWorld(Physical p) {

        Vector2D position = p.getPosition();
        double radius = p.getRadius();

        return position.getX() - radius >= 0
                && position.getX() + radius <= width
                && position.getY() - radius >= 0
                && position.getY() + radius <= height;
    }
}