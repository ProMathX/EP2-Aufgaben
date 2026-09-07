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

        System.out.println("Test 'put' and 'get' method:");
        ConstConstTreeMap map = new ConstConstTreeMap();
        IntConst ONE = new IntConst(1);
        testIdentical(map.put(new IntConst(7), ONE), null);
        testIdentical(map.put(new IntConst(2), new IntConst(5)), null);
        map.put(new IntConst(12), new IntConst(-3));
        testIdentical(map.put(new IntConst(7), new IntConst(3)), ONE);
        testEquals(map.get(new IntConst(2)),new IntConst(5));
        testIdentical(map.get(new IntConst(-10)), null);

        System.out.println("Test 'copy constructor':");
        ConstConstTreeMap anotherMap = new ConstConstTreeMap(map);
        map.put(new IntConst(-2), new IntConst(-20));
        anotherMap.put(new IntConst(11), new IntConst(110));
        testIdentical(map.get(new IntConst(11)), null);
        testIdentical(anotherMap.get(new IntConst(-2)), null);
        testEquals(map.get(new IntConst(-2)), new IntConst(-20));
        testEquals(anotherMap.get(new IntConst(11)), new IntConst(110));

        System.out.println("Test 'toString' method:");
        testEquals(map.toString(), "[-2=-20,2=5,7=3,12=-3]");
        testEquals(anotherMap.toString(), "[2=5,7=3,11=110,12=-3]");

        System.out.println("Test 'countCommonKeys':");
        testIdentical(map.countCommonKeys(anotherMap), 3);

        System.out.println("Test 'toString(int,int)' method:");
        testEquals(map.toString(new IntConst(7),new IntConst(12)), "[7=3,12=-3]");
        testEquals(map.toString(new IntConst(7),new IntConst(11)), "[7=3]");
        testEquals(map.toString(new IntConst(-5),new IntConst(2)), "[-2=-20,2=5]");

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

    /**
     * Compares two 'IntConst' objects for equality using the 'equals' method.
     * Prints "successful test" if and only if
     * (given == null ? expected == null : given.isEqual(expected) == 0)
     * @param given the given number.
     * @param expected the number to compare 'given' to.
     */
    public static void testEquals(IntConst given, IntConst expected) {
        if (given == null ? expected == null : expected != null && given.isEqual(expected)) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given " +
                    "value: " + given);
        }
    }
}
