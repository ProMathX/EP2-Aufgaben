/**
 * The class {@code Vector2D} represents a two-dimensional mathematical vector.
 * This class replaces the former array-based representation of vectors.
 *
 * A vector consists of an x- and a y-coordinate and is used to model
 * positions and directions in a two-dimensional space.
 *
 * This class is intended to encapsulate both, data (coordinates)
 * and the operations that can be performed on vectors, such as
 * addition, distance computation and normalization.
 *
 * A {@code Vector2D} object provides all operations for vector manipulation
 * via instance methods (no direct manipulation of the coordinates from outside
 * the class).
 *
 * Objects of this class are mutable, i.e., they can change their
 * state (coordinates) upon a method call.
 */
public class Vector2D {

    private double x;
    private double y;

    public void newCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D add(Vector2D other) {
        Vector2D sum = new Vector2D();
        sum.newCoordinates(this.getX() + other.getX(), this.getY() + other.getY());
        return sum;
    }

    public Vector2D subtract(Vector2D other) {
        Vector2D diff = new Vector2D();
        diff.newCoordinates(this.getX() - other.getX(), this.getY() - other.getY());
        return diff;
    }

    public double distance(Vector2D other) {
        return this.subtract(other).length();
    }

    public double length() {
        return Math.sqrt(getX() * getX() + getY() * getY());
    }

    public void scale(double factor) {
        this.newCoordinates(this.getX() * factor, this.getY() * factor);
    }

    public void normalize() {
        this.newCoordinates(this.getX() / this.length(), this.getY() / this.length());
    }

    public boolean isZero() {
        return length() < 1e-12;
    }

    public double[] toArray() {
        return new double[]{getX(), getY()};
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[%s, %s]".formatted(getX(), getY());
    }
}