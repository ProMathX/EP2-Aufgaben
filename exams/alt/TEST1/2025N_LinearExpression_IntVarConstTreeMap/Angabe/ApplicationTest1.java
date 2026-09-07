/**
 * A class used for testing.
 */
public class ApplicationTest1 {

    /**
     * The main method.
     *
     * @param args not used.
     */
    public static void main(String[] args) {

        IntVar a = new IntVar("a");
        IntVar b = new IntVar("b");
        IntVar c = new IntVar("c");
        IntVar x = new IntVar("x");
        IntVar y = new IntVar("y");
        IntVar z = new IntVar("z");
        IntConst five = new IntConst(5);

        System.out.println("\nTest 'IntVarConstTreeMap' ...");
        System.out.println("Test1: constructor, 'put' and 'get':");
        IntVarConstTreeMap map = new IntVarConstTreeMap();
        map.put(y, five);
        map.put(b, five.times(new IntConst(10)));
        map.put(x, new IntConst(3));
        map.put(z, new IntConst(-2));
        map.put(a, new IntConst(30));

        // take a snapshot for Test 3:
        IntVarConstTreeMap anotherMap = new IntVarConstTreeMap(map);

        map.put(c, new IntConst(-20));
        map.put(null, new IntConst(7));
        testIdentity(map.get(y), five);
        testEquals(map.get(b), five.times(new IntConst(10)));
        testEquals(map.get(new IntVar("x")), null);

        System.out.println("\nTest2: 'size':");
        testIdentity(map.size(), 7);

        System.out.println("\nTest3: copy constructor (superficial test):");
        testIdentity(anotherMap.get(y), five);
        testEquals(anotherMap.get(b), five.times(new IntConst(10)));
        testEquals(anotherMap.get(x), new IntConst(3));
        testEquals(anotherMap.get(z), new IntConst(-2));
        testEquals(anotherMap.get(a), new IntConst(30));
        testEquals(anotherMap.get(c), null);
        testEquals(anotherMap.get(null), null);

        System.out.println("\nTest 'LinearExpression' ...");
        System.out.println("Test4: 'plus':");
        LinearExpression e = new LinearExpression(x);
        testEquals(e.toString(), "x");
        e = e.plus(e).plus(e);
        testEquals(e.toString().replaceAll("\\s", ""), "3x");
        e = e.plus(z);
        testEquals(e.toString().replaceAll("\\s", ""), "3x+z");
        e = e.plus(z).plus(new IntConst(7));
        testEquals(e.toString().replaceAll("\\s", ""), "7+3x+2z");
        e = e.plus(y).plus(y).plus(y).plus(y).plus(y);
        testEquals(e.toString().replaceAll("\\s", ""), "7+3x+5y+2z");
        e = e.plus(new IntConst(-7));
        testEquals(e.toString().replaceAll("\\s", ""), "3x+5y+2z");
    }

    /**
     * Checks two objects for identity and prints "Successful comparison" only if
     * (first == second) == expected.
     *
     * @param first    the first object.
     * @param second   the second object.
     * @param expected the expected value of first == second.
     */
    public static void testIdentity(Object first, Object second, boolean expected) {
        boolean real = first == second;

        if (real == expected) {
            System.out.println("OK");
        } else {
            if (real) {
                System.out.println("FAIL! " + first + " should not be " +
                        "identical with " + second);
            } else {
                System.out.println("FAIL! " + first + " should be " +
                        "identical with " + second);
            }
        }
    }

    /**
     * Checks two objects for identity and prints "Successful comparison" only if given == expected.
     *
     * @param given    the given object.
     * @param expected the expected object.
     */
    public static void testIdentity(Object given, Object expected) {
        testIdentity(given, expected, true);
    }

    /**
     * Checks two strings for equality.
     *
     * @param given    the string to be checked.
     * @param expected the expected string.
     */
    public static void testEquals(String given, String expected) {
        if (given.equals(expected)) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL! Expected value: " + expected + " / Given value: " + given);
        }
    }

    /**
     * Checks two {@code IntConst} objects for equality.
     *
     * @param given    the {@code IntConst} object to be checked.
     * @param expected the expected {@code IntConst} object.
     */
    public static void testEquals(IntConst given, IntConst expected) {
        if (given == null) {
            if (expected == null) {
                System.out.println("OK");
            } else {
                System.out.println("FAIL! Expected value: " + expected + " / Given value: " + given);
            }
            return;
        }

        if (expected == null) {
            System.out.println("FAIL! Expected value: " + expected + " / Given value: " + given);
        } else {
            if (given.isEqual(expected)) {
                System.out.println("OK");
            } else {
                System.out.println("FAIL! Expected value: " + expected + " / Given value: " + given);
            }
        }
    }
}