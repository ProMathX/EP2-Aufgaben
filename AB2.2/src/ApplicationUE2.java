public class ApplicationUE2 {

    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println("PhysicalKDTreeSet countAllWithYGreater TESTS");
        System.out.println("===============================================");

        // =========================================================
        // Randfall 1: leerer Baum
        // =========================================================
        PhysicalKDTreeSet emptyTree = new PhysicalKDTreeSet();
        check("empty tree countAllWithYGreater(0.0)", 0,
                emptyTree.countAllWithYGreater(0.0));

        // =========================================================
        // Randfall 2: Baum mit genau einem Element
        // =========================================================
        Physical single = new Nest(new Vector2D(2.0, 2.0), 1.0);
        PhysicalKDTreeSet singleTree = new PhysicalKDTreeSet();
        singleTree.add(single);

        check("single tree countAllWithYGreater(1.0)", 1,
                singleTree.countAllWithYGreater(1.0));
        check("single tree countAllWithYGreater(2.0)", 0,
                singleTree.countAllWithYGreater(2.0));
        check("single tree countAllWithYGreater(3.0)", 0,
                singleTree.countAllWithYGreater(3.0));

        // =========================================================
        // Normalfall
        // =========================================================
        Physical t1 = new Nest(new Vector2D(2.0, 2.0), 1.0);
        Physical t2 = new FoodSource(new Vector2D(1.0, 5.0), 1.0);
        Physical t3 = new Nest(new Vector2D(3.0, 1.0), 1.0);
        Physical t4 = new FoodSource(new Vector2D(2.0, 1.0), 1.0);
        Physical t5 = new Nest(new Vector2D(2.0, 3.0), 2.5);

        PhysicalKDTreeSet tree = new PhysicalKDTreeSet();
        tree.add(new Physical[]{t1, t2, t3, t4, t5});

        check("countAllWithYGreater(0.0)", 5,
                tree.countAllWithYGreater(0.0));
        check("countAllWithYGreater(1.5)", 3,
                tree.countAllWithYGreater(1.5)); // t1, t2, t5
        check("countAllWithYGreater(2.0)", 2,
                tree.countAllWithYGreater(2.0)); // t2, t5
        check("countAllWithYGreater(3.0)", 1,
                tree.countAllWithYGreater(3.0)); // t2
        check("countAllWithYGreater(5.0)", 0,
                tree.countAllWithYGreater(5.0));
        check("countAllWithYGreater(10.0)", 0,
                tree.countAllWithYGreater(10.0));

        // =========================================================
        // Randfall 3: mehrere Elemente mit gleicher y-Koordinate
        // =========================================================
        Physical g1 = new Nest(new Vector2D(1.0, 5.0), 1.0);
        Physical g2 = new FoodSource(new Vector2D(2.0, 5.0), 1.0);
        Physical g3 = new Nest(new Vector2D(3.0, 5.0), 1.0);
        Physical g4 = new FoodSource(new Vector2D(1.0, 6.0), 1.0);
        Physical g5 = new Nest(new Vector2D(1.0, 4.0), 1.0);

        PhysicalKDTreeSet equalYTree = new PhysicalKDTreeSet();
        equalYTree.add(new Physical[]{g1, g2, g3, g4, g5});

        check("equalYTree countAllWithYGreater(5.0)", 1,
                equalYTree.countAllWithYGreater(5.0)); // nur g4
        check("equalYTree countAllWithYGreater(4.0)", 4,
                equalYTree.countAllWithYGreater(4.0)); // g1, g2, g3, g4
        check("equalYTree countAllWithYGreater(6.0)", 0,
                equalYTree.countAllWithYGreater(6.0));

        System.out.println("\n===============================================");
        System.out.println("PhysicalDoublyLinkedRingList removeUntil TESTS");
        System.out.println("===============================================");

        // =========================================================
        // Basisdaten
        // =========================================================
        Physical r1 = new Nest(new Vector2D(1.0, 1.0), 1.0);
        Physical r2 = new FoodSource(new Vector2D(2.0, 2.0), 1.0);
        Physical r3 = new Nest(new Vector2D(3.0, 3.0), 1.0);
        Physical r4 = new FoodSource(new Vector2D(4.0, 4.0), 1.0);
        Physical r5 = new Nest(new Vector2D(5.0, 5.0), 1.0);

        // =========================================================
        // Normalfall
        // =========================================================
        PhysicalDoublyLinkedRingList list1 = new PhysicalDoublyLinkedRingList();
        list1.addLast(r1);
        list1.addLast(r2);
        list1.addLast(r3);
        list1.addLast(r4);
        list1.addLast(r5);

        PhysicalDoublyLinkedRingList removed1 = list1.removeUntil(2); // r1, r2, r3

        check("removeUntil(2) removed size", 3, removed1.size());
        checkPhysical("removeUntil(2) removed[0]", r1, removed1.get(0));
        checkPhysical("removeUntil(2) removed[1]", r2, removed1.get(1));
        checkPhysical("removeUntil(2) removed[2]", r3, removed1.get(2));

        check("removeUntil(2) remaining size", 2, list1.size());
        checkPhysical("removeUntil(2) remaining[0]", r4, list1.get(0));
        checkPhysical("removeUntil(2) remaining[1]", r5, list1.get(1));
        checkPhysical("removeUntil(2) remaining first", r4, list1.peekFirst());
        checkPhysical("removeUntil(2) remaining last", r5, list1.peekLast());

        // =========================================================
        // Randfall 1: i == 0 (nur erstes Element entfernen)
        // =========================================================
        PhysicalDoublyLinkedRingList list2 = new PhysicalDoublyLinkedRingList();
        list2.addLast(r1);
        list2.addLast(r2);
        list2.addLast(r3);

        PhysicalDoublyLinkedRingList removed2 = list2.removeUntil(0);

        check("removeUntil(0) removed size", 1, removed2.size());
        checkPhysical("removeUntil(0) removed[0]", r1, removed2.get(0));
        check("removeUntil(0) remaining size", 2, list2.size());
        checkPhysical("removeUntil(0) remaining[0]", r2, list2.get(0));
        checkPhysical("removeUntil(0) remaining[1]", r3, list2.get(1));

        // =========================================================
        // Randfall 2: gesamte Liste entfernen
        // =========================================================
        PhysicalDoublyLinkedRingList list3 = new PhysicalDoublyLinkedRingList();
        list3.addLast(r1);
        list3.addLast(r2);
        list3.addLast(r3);

        PhysicalDoublyLinkedRingList removed3 = list3.removeUntil(2);

        check("removeUntil(last index) removed size", 3, removed3.size());
        checkPhysical("removeUntil(last index) removed[0]", r1, removed3.get(0));
        checkPhysical("removeUntil(last index) removed[1]", r2, removed3.get(1));
        checkPhysical("removeUntil(last index) removed[2]", r3, removed3.get(2));

        check("removeUntil(last index) remaining size", 0, list3.size());
        check("removeUntil(last index) remaining isEmpty", true, list3.isEmpty());
        check("removeUntil(last index) remaining peekFirst", null, list3.peekFirst());
        check("removeUntil(last index) remaining peekLast", null, list3.peekLast());

        // =========================================================
        // Randfall 3: mittlerer Präfix
        // =========================================================
        PhysicalDoublyLinkedRingList list4 = new PhysicalDoublyLinkedRingList();
        list4.addLast(r1);
        list4.addLast(r2);
        list4.addLast(r3);
        list4.addLast(r4);

        PhysicalDoublyLinkedRingList removed4 = list4.removeUntil(1);

        check("removeUntil(1) removed size", 2, removed4.size());
        checkPhysical("removeUntil(1) removed[0]", r1, removed4.get(0));
        checkPhysical("removeUntil(1) removed[1]", r2, removed4.get(1));

        check("removeUntil(1) remaining size", 2, list4.size());
        checkPhysical("removeUntil(1) remaining[0]", r3, list4.get(0));
        checkPhysical("removeUntil(1) remaining[1]", r4, list4.get(1));
        checkPhysical("removeUntil(1) remaining first", r3, list4.peekFirst());
        checkPhysical("removeUntil(1) remaining last", r4, list4.peekLast());

        System.out.println("\n===============================================");
        System.out.println("ALL TESTS COMPLETED");
        System.out.println("===============================================");
    }

    private static void checkPhysical(String testName, Physical expected, Physical actual) {
        boolean ok = expected == actual;

        if (ok) {
            ok();
        } else {
            fail(testName, physicalToString(expected), physicalToString(actual));
        }
    }

    private static String physicalToString(Physical p) {
        if (p == null) {
            return "null";
        }
        return p.getClass().getSimpleName()
                + "@(" + p.getPosition().getX() + ", " + p.getPosition().getY() + "), r=" + p.getRadius();
    }

    private static void check(String testName, Object expected, Object actual) {
        if (java.util.Objects.equals(expected, actual)) {
            ok();
        } else {
            fail(testName, expected, actual);
        }
    }

    private static void fail(String testName, Object expected, Object actual) {
        System.out.println(testName + " FAILED -> Expected: " + expected + ", Actual: " + actual);
    }

    private static void ok() {
        System.out.println("OK");
    }
}