import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class can be modified and is for testing your solution.
 * Modifications will NOT be reviewed or assessed.
 */
public class PraxisTest1 {

    /**
     * The main method.
     * @param args not used.
     */
    public static void main(String[] args) {

        Block block1 = new Block(2, 2);
        Block block2 = new Block(2, 3);
        Block block3 = new Block(7, 3);
        Block block4 = new Block(12, 3);
        Block block5 = new Block(2, 1);

        System.out.println("Test 'BlockQueue':");
        System.out.println("Test 'add' and 'size' method:");
        BlockQueue queue = new BlockQueue();
        queue.add(block1);
        testValue(queue.size(), 1);
        queue.add(block2);
        queue.add(block2);
        testValue(queue.size(), 3);

        System.out.println("Test 'toString' method:");
        testEquals(queue.toString(), "[[2x2],[2x3],[2x3]]");

        System.out.println("Test 'poll' and 'size' method:");
        testEquals(queue.poll(), block1);
        testValue(queue.size(), 2);
        testEquals(queue.poll(), block2);
        testEquals(queue.poll(), block2);
        testValue(queue.size(), 0);

        System.out.println("Test 'Building':");
        Building building = new Building(block1);
        building = building.connectWith(new Building(block2));
        testEquals(building.toString(), "[[2x5]]");
        building = building.connectWith(new Building(block3));
        testEquals(building.toString(), "[[2x5],[7x3]]");
        building = building.connectWith(new Building(block4).connectWith(new Building(block5)));
        testContains(building.toString(), new String[] {"[2x6]","[7x3]","[12x3]"});
        HashSet<Object> set = new HashSet<>(Arrays.asList(block5, block4));
        queue = new Building(block4).connectWith(new Building(block5)).getQueue();
        testEqualsOne(queue.poll(), set);
        testEqualsOne(queue.poll(), set);
        testValue(queue.size(), 0);

    }

    /**
     * Checks two objects for identity and prints "Successful test" only if given == expected.
     * @param given the given object.
     * @param expected the expected object.
     */
    public static void testIdentical(Object given, Object expected) {
        if (given == expected) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given value: " + given);
        }
    }

    /**
     * Checks two objects for identity and prints "Successful test" only if given != expected.
     * @param given the given object.
     * @param notExpected the object that should be different from 'given'.
     */
    public static void testNotIdentical(Object given, Object notExpected) {
        if (given != notExpected) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + notExpected + " / Given value: " + given);
        }
    }

    /**
     * Compares two objects for equality using the 'equals' method.
     * Prints "successful test" if and only if
     * (given == null ? expected == null : given.equals(expected) == 0)
     * @param given the given rational number.
     * @param expected the rational number to compare 'given' to.
     */
    public static void testEquals(Object given, Object expected) {
        if (given == null ? expected == null : given.equals(expected)) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given " +
                    "value: " + given);
        }
    }

    public static void testContains(String given, String[] elements) {
        given = given.replaceAll("\\s","");
        for(String s: elements) {
            if (!given.contains(s)) {
                System.out.println("Test NOT successful! String " + s + " should be contained in " +
                        "given string " + given);
                return;
            }
            given = given.replace(s, "");
        }
        int count = 0;
        while(given.contains(",")) {
            given = given.replaceFirst(",", "");
            count++;
        }
        if (count != elements.length - 1 || !given.equals("[]")) {
            System.out.println("Test NOT successful! Wrong number of characters.");
        } else {
            System.out.println("Successful test");
        }
    }

    /**
     * Reports a successful test only if and only if the specified boolean value is 'true'.
     * @param expectedTrue the specified boolean value.
     */
    public static void testTrue(boolean expectedTrue) {
        if (expectedTrue) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expression should be 'true' but is 'false'.");
        }
    }

    /**
     * Compares two values and prints "Successful test" only if there are equal.
     * @param given the given value to be checked.
     * @param expected the expected value with which 'given' is compared.
     */
    public static void testValue(int given, int expected) {
        if (given == expected) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given value: " + given);
        }
    }

    /**
     * Checks if the specified object is equal to at least one of the objects in the specified
     * array.
     * @param given the object to be checked.
     * @param expected the array containing valid objects.
     */
    public static void testEqualsOne(Object given, Set<Object> expected) {
        for (Object s: expected) {
            if (given.equals(s)) {
                System.out.println("Successful test");
                expected.remove(s);
                return;
            }
        }
        for (Object s : expected) {

        }
        System.out.println("Test NOT successful! Given " + given + " does not match one " +
                "of " + expected + ".");
    }

}
