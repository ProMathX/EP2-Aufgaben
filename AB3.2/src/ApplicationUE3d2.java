import java.util.Iterator;

public class ApplicationUE3d2 {

    public static void main(String[] args) {

        /*
         * Tree structure by x-coordinate:
         *
         *              k1(5)
         *             /     \
         *         k2(3)     k3(8)
         *         /   \        \
         *      k4(1) k5(4)    k6(9)
         *
         * Pre-order:
         * k1, k2, k4, k5, k3, k6
         */

        Physical k1 = new Nest(new Vector2D(5, 0), 1);
        Physical k2 = new Nest(new Vector2D(3, 0), 2);
        Physical k3 = new Nest(new Vector2D(8, 0), 3);
        Physical k4 = new Nest(new Vector2D(1, 0), 4);
        Physical k5 = new Nest(new Vector2D(4, 0), 5);
        Physical k6 = new Nest(new Vector2D(9, 0), 6);

        PhysicalPhysicalTreeMap map = new PhysicalPhysicalTreeMap();

        map.put(k1, new FoodSource(new Vector2D(10, 10), 10));
        map.put(k2, new FoodSource(new Vector2D(20, 20), 20));
        map.put(k3, new FoodSource(new Vector2D(30, 30), 30));
        map.put(k4, new FoodSource(new Vector2D(40, 40), 40));
        map.put(k5, new FoodSource(new Vector2D(50, 50), 50));
        map.put(k6, new FoodSource(new Vector2D(60, 60), 60));

        System.out.println("======================================");
        System.out.println("preOrderIterator() TESTS");
        System.out.println("======================================");

        PhysicalIterator iterator = map.preOrderIterator();

        checkPhysical("preOrderIterator 0", k1, iterator.next());
        checkPhysical("preOrderIterator 1", k2, iterator.next());
        checkPhysical("preOrderIterator 2", k4, iterator.next());
        checkPhysical("preOrderIterator 3", k5, iterator.next());
        checkPhysical("preOrderIterator 4", k3, iterator.next());
        checkPhysical("preOrderIterator 5", k6, iterator.next());

        check("preOrderIterator exhausted", false, iterator.hasNext());
        checkPhysical("preOrderIterator next after exhausted", null, iterator.next());

        System.out.println("======================================");
        System.out.println("ALL TESTS COMPLETED");
        System.out.println("======================================");

    }

    private static void check(String testName, Object expected, Object actual) {
        if (java.util.Objects.equals(expected, actual)) {
            ok();
        } else {
            fail(testName, expected, actual);
        }
    }

    private static void checkPhysical(String testName, Physical expected, Physical actual) {
        if (expected == actual) {
            ok();
        } else {
            fail(testName, physicalToString(expected), physicalToString(actual));
        }
    }

    private static void fail(String testName, Object expected, Object actual) {
        System.out.println(testName + " FAILED -> Expected: "
                + expected + ", Actual: " + actual);
    }

    private static void ok() {
        System.out.println("OK");
    }

    private static String physicalToString(Physical p) {
        if (p == null) {
            return "null";
        }

        return p.getClass().getSimpleName()
                + "@("
                + p.getPosition().getX()
                + ", "
                + p.getPosition().getY()
                + "), r="
                + p.getRadius();
    }
}