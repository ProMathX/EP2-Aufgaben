import java.util.Arrays;

/**
 * The class {@code ApplicationVector2D} serves as an entry point for testing {@link Vector2D}.
 * <p>
 * It demonstrates basic vector operations using an array-based
 * representation of two-dimensional vectors.
 * <p>
 * TODO: change this class according to 'angabe.md'.
 */

public class ApplicationVector2D {
    /**
     * Runs a small demonstration of basic vector operations.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Vector2D v1 = new Vector2D();
        Vector2D v2 = new Vector2D();
        v1.newCoordinates(3.0, 4.0);
        v2.newCoordinates(1.0, -2.0);

        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);
        System.out.println();

        Vector2D sum = v1.add(v2);
        System.out.println("v1 + v2 = " + sum);

        Vector2D diff = v1.subtract(v2);
        System.out.println("v1 - v2 = " + diff);

        System.out.println("length(v1) = " + v1.length());

        double d = v1.distance(v2);
        System.out.println("distance(v1, v2) = " + d);

        v1.scale(2.0);
        System.out.println("scaled v1 (factor 2) = " + v1);

        double[] copy = v1.toArray();
        v1.normalize();
        System.out.println("v1 normalized = " + v1);
        System.out.println("v1 before normalize = " + Arrays.toString(copy));
        System.out.println("length(v1) after normalize = " + v1.length());

        Vector2D zero = new Vector2D();
        zero.newCoordinates(0, 0);
        System.out.println("isZero(zero) = " + zero.isZero());
    }

}