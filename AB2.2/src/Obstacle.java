/**
 * A static physical obstacle in the two-dimensional simulation world.
 *
 * <p>An {@code Obstacle} represents an immovable object with a fixed position
 * and a circular spatial extent. Obstacles can be used to model walls,
 * barriers, or regions that agents (such as ants) should avoid or cannot
 * pass through.</p>
 */
public class Obstacle implements Physical {

    private final Vector2D position;
    private final double radius;

    /**
     * Creates a new obstacle with the specified position and radius.
     *
     * @param position the center position of the obstacle;
     *                 {@code position != null}
     * @param radius the radius of the obstacle;
     *               {@code radius >= 0.0}
     */
    public Obstacle(Vector2D position, double radius) {
        this.position = position;
        this.radius = radius;
    }

    @Override
    public Vector2D getPosition() {
        return position;
    }

    @Override
    public double getRadius() {
        return radius;
    }
}