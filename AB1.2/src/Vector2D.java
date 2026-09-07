/**
 * The class {@code Vector2D} represents a two-dimensional mathematical vector.
 * <p>
 */
public class Vector2D {

    private final double x;
    private final double y;

    /**
     * Creates a new vector with the provided input.
     * @param x the x-coordinate of the vector
     * @param y the y-coordinate of the vector
     */
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the sum of this vector and the provided vector.
     *
     * @param other the vector to add to this vector
     * @return the sum of this vector and <code>other</code>
     */
    public Vector2D add(Vector2D other) {
        return new Vector2D(this.getX() + other.getX(), this.getY() + other.getY());
    }

    /**
     * Calculates and returns a new vector based on this vector substracted by the <code>other</code>
     *
     * @param other the vector to add to this vector
     * @return a new vector with the difference of this vector and <code>other</code>
     */
    public Vector2D subtract(Vector2D other) {
        return new Vector2D(this.getX() - other.getX(), this.getY() - other.getY());
    }


    /**
     * Scales the vector by the given factor.
     * @param factor the factor to scale
     * @return a new vector scaled by the given factor
     */
    public Vector2D scale(double factor) {
        return new Vector2D(this.getX() * factor, this.getY() * factor);
    }

    /**
     * Calculates the length of the vector.
     * @return the length of the vector
     */
    public double length() {
        return Math.sqrt(getX() * getX() + getY() * getY());
    }

    /**
     * Normalizes the vector.
     * @return a new vector that is normalized based on this vector's coordinates. If the vector has a length of 0,
     * the 0-vector is returned.
     */
    public Vector2D normalize() {
        if (length() == 0) {
            return new Vector2D(0, 0);
        }
        return new Vector2D(this.getX() / this.length(), this.getY() / this.length());
    }


    /**
     * @return the x-coordinate of the vector
     */
    public double getX() {
        return x;
    }

    /**
     * @return the y-coordinate of the vector
     */
    public double getY() {
        return y;
    }

}