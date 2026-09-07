/**
 * A comparator that orders {@link Physical} objects
 * by their distance to the coordinate origin (0.0, 0.0).
 *
 * <p>The comparison is based on the Euclidean distance between
 * each object's position and the coordinate origin (0.0, 0.0).</p>
 *
 * <p>The ordering is defined as follows:</p>
 * <ul>
 *   <li>{@code compare(a, b) < 0} if {@code a} is closer to (0.0, 0.0) than {@code b}</li>
 *   <li>{@code compare(a, b) == 0} if both objects have the same distance to (0.0, 0.0)</li>
 *   <li>{@code compare(a, b) > 0} if {@code a} is farther from (0.0, 0.0) than {@code b}</li>
 * </ul>
 *
 * <p>This defines a total order with respect to the distance from the
 * coordinate origin (0.0, 0.0).</p>
 *
 *  This class implements the {@link PhysicalComparator} interface.
 */
public class DistanceComparator implements PhysicalComparator {
    @Override
    public int compare(Physical a, Physical b) {
        Vector2D zero = new Vector2D(0, 0);

        double distanceA = a.getPosition().distanceTo(zero);
        double distanceB = b.getPosition().distanceTo(zero);

        return Double.compare(distanceA, distanceB);
    }

}
