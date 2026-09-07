/**
 * The class {@code Bird} models a simple moving object in a two-dimensional space.
 *
 * A bird has a position and a velocity vector. The position determines the
 * current location of the bird, while the velocity describes direction and
 * speed of movement.
 *
 * Birds can update their position over time and may adjust their velocity vector
 * in order to avoid other objects and maintain a minimum distance.
 */
public class Bird {

    //TODO: define this class according to `angabe.md`.

    private Vector2D position;
    private Vector2D velocity;

    /**
     * Moves the bird according to his velocity vector.
     */
    public void move() {
        throw new UnsupportedOperationException("not implemented yet.");
    }

    /**
     * Changes the angle of the bird. Use {@link #moveUp()}, {@link #moveDown()} {@link #moveLeft()} {@link #moveRight()}
     * for default angles.
     * @param x the direction on the x-axis (used for left and right)
     * @param y the direction on the y-axis (used for up and down)
     */
    public void changeFlightDirection(double x, double y) {
        throw new UnsupportedOperationException("not implemented yet.");
    }

    /**
     * Changes the bird's direction to move up from now on.
     */
    public void moveUp() {
        changeFlightDirection(0, 1);
    }

    /**
     * Changes the bird's direction to move down from now on.
     */
    public void moveDown() {
        changeFlightDirection(0, -1);
    }

    /**
     * Changes the bird's direction to move left from now on.
     */
    public void moveLeft() {
        changeFlightDirection(-1, 0);
    }

    /**
     * Changes the bird's direction to move right from now on.
     */
    public void moveRight() {
        changeFlightDirection(1, 0);
    }

    /**
     * Checks if this bird is near the other bird within the threshold.
     * @param bird the bird to check if nearby
     * @param threshold the threshold to determine if the bird is nearby.
     * @return true if the bird is within the threshold, false otherwise.
     */
    public boolean nearby(Bird bird, double threshold) {
        throw new UnsupportedOperationException("not implemented yet.");
    }

}
