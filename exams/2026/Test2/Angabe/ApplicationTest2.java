public class ApplicationTest2 {

    public static void main(String[] args) {

        /*TODO: delete line to uncomment.

        System.out.println("\n===============================================");
        System.out.println("RadiusComparator TESTS");
        System.out.println("===============================================");

        CelestialBody earth = new CelestialBody("Earth", 6371);
        CelestialBody saturn = new CelestialBody("Saturn", 58232);
        CelestialBody moon = new CelestialBody("Moon", 1737);
        CelestialBody jupiter = new CelestialBody("Jupiter", 69911);
        CelestialBody mars = new CelestialBody("Mars", 3390);

        RadiusComparator comparator = new RadiusComparator();
        check("Comparator comparing smaller with larger", true, comparator.compare(earth, saturn) < 0);
        check("Comparator comparing larger with smaller", true, comparator.compare(saturn, earth) > 0);
        check("Comparator comparing equal radii", 0, comparator.compare(new CelestialBody("Earth2", 6371), earth));

        System.out.println("\n===============================================");
        System.out.println("OrderedPhysicalSinglyLinkedList TESTS");
        System.out.println("===============================================");
        OrderedPhysicalSinglyLinkedList list = new OrderedPhysicalSinglyLinkedList(comparator);
        check("OrderedPhysicalSinglyLinkedList empty size", 0, list.size());

        list = new OrderedPhysicalSinglyLinkedList(comparator);
        list.insert(earth);
        check("OrderedPhysicalSinglyLinkedList insert single", 1, list.size());

        list.insert(saturn);
        check("OrderedPhysicalSinglyLinkedList insert higher rank", 2, list.size());

        Physical[] array = list.asArray();
        check("OrderedPhysicalSinglyLinkedList asArray length", 2, array.length);
        check("OrderedPhysicalSinglyLinkedList highest rank first", saturn, array[0]);
        check("OrderedPhysicalSinglyLinkedList lowest rank last", earth, array[1]);

        list.insert(moon);
        check("OrderedPhysicalSinglyLinkedList insert lower rank", 3, list.size());

        array = list.asArray();
        check("OrderedPhysicalSinglyLinkedList order maintained", saturn, array[0]);
        check("OrderedPhysicalSinglyLinkedList order maintained", earth, array[1]);
        check("OrderedPhysicalSinglyLinkedList order maintained", moon, array[2]);


        boolean b = list.contains(earth);
        check("OrderedPhysicalSinglyLinkedList contains identical objects", true, b);
        b = list.contains(new CelestialBody("Earth", 6371));
        check("OrderedPhysicalSinglyLinkedList contains object of same name and radius", false, b);


        OrderedPhysicalSinglyLinkedList removeList = new OrderedPhysicalSinglyLinkedList(comparator);
        removeList.insert(earth);
        removeList.insert(moon);
        removeList.insert(saturn);
        removeList.insert(jupiter);
        removeList.insert(mars);

        removeList.removeBelow(new CelestialBody("Earth2", 6371));

        array = removeList.asArray();
        check("OrderedPhysicalSinglyLinkedList removeBelow size", 2, array.length);
        check("OrderedPhysicalSinglyLinkedList removeBelow remaining element at index 0", jupiter, array[0]);
        check("OrderedPhysicalSinglyLinkedList removeBelow remaining element at index 1", saturn, array[1]);

        System.out.println("\n===============================================");
        System.out.println("Universe TESTS");
        System.out.println("===============================================");
        Universe emptyUniverse = new Universe();
        check("Universe empty toString", "Empty universe", emptyUniverse.toString());

        Universe universe = new Universe();
        universe.addBody(saturn);
        check("Universe toString after adding one body", "Bodies: 1 | 1. Saturn (58232 km)", universe.toString());

        universe.addBody(earth);
        check("Universe two bodies", "Bodies: 2 | 1. Saturn (58232 km), 2. Earth (6371 km)", universe.toString());

        universe.addBody(moon);
        universe.addBody(jupiter);
        universe.addBody(mars);
        check("Universe of five bodies shows only top 3", "Bodies: 5 | 1. Jupiter (69911 km), 2. Saturn (58232 km), 3. Earth (6371 km)", universe.toString());

        // Test duplicate prevention
        CelestialBody saturn2 = new CelestialBody("Saturn", 58232);
        universe.addBody(saturn2);
        check("Universe add body of same name and radius", "Bodies: 6 | 1. Jupiter (69911 km), 2. Saturn (58232 km), 3. Saturn (58232 km)", universe.toString());
        universe.addBody(saturn2);
        check("Universe addBody no adding of identical object", "Bodies: 6 | 1. Jupiter (69911 km), 2. Saturn (58232 km), 3. Saturn (58232 km)", universe.toString());

        universe.removeBelow(new CelestialBody("Fantasy Planet", 60000));
        check("Leaderboard removeBelow", "Bodies: 1 | 1. Jupiter (69911 km)", universe.toString());

        System.out.println("\n===============================================");
        System.out.println("ALL TESTS COMPLETED");
        System.out.println("===============================================");
        //TODO: end of block to uncomment. */
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