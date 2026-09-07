/**
 * A {@code WindGust} represents a circular region in a two-dimensional world
 * that influences the movement of objects.
 *
 * A wind gust has a fixed position, a fixed wind velocity, and a fixed radius.
 * If a state lies within the radius of the gust, its velocity is influenced
 * by the gust.
 */
public class WindGust {

    private final Vector2D position;
    private final Vector2D velocity;
    private final double radius;

    /**
     * Creates a new wind gust with the given position, velocity, and radius.
     *
     * @param position the center position of the gust; {@code position != null}
     * @param velocity the velocity of the wind; {@code velocity != null}
     * @param radius the radius of the gust; {@code radius > 0}
     */
    public WindGust(Vector2D position, Vector2D velocity, double radius) {
        this.position = position;
        this.velocity = velocity;
        this.radius = radius;
    }

    /**
     * Returns whether the given state is influenced by this wind gust.
     *
     * A state is influenced if its position lies within the radius
     * of the gust.
     *
     * @param s the state to test; {@code s != null}
     * @return {@code true} if the position of {@code s} lies within
     *         the radius of this gust, {@code false} otherwise
     */
    public boolean affects(State s) {
        Vector2D diff = s.getPosition().subtract(position);
        if (Math.abs(diff.getX()) <= radius) {
            return Math.abs(diff.getY()) <= radius;
        }
        return false;
    }

    /**
     * Returns the result of the influence of this wind gust to the given state.
     *
     * <p>
     * If the state lies within the radius of the gust, the returned state has a
     * shifted position which is the result of summing the wind velocity and the
     * position of the state. The velocity of the state is not changed.
     * Otherwise, the state is returned unchanged.
     * </p>
     *
     * @param s the state to be influenced; {@code s != null}
     * @return a new {@link State} representing the influenced state
     */
    public State apply(State s) {
        if (!affects(s)) {
            return s;
        }
        return new State(velocity.add(s.getPosition()), s.getVelocity());
    }

}