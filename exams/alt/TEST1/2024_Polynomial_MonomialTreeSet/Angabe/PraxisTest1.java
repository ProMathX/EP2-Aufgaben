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

        Monomial m1 = new Monomial(2, 2);
        Monomial m2 = new Monomial(2, 3);
        Monomial m3 = new Monomial(7, 3);
        Monomial m4 = new Monomial(12, -3);

        System.out.println("Test 'MonomialTreeSet':");
        System.out.println("Test 'add' and 'contains' method:");
        MonomialTreeSet set = new MonomialTreeSet();
        set.add(m1);
        testTrue(set.contains(m1));
        testTrue(!set.contains(m2));
        set.add(m2);
        testTrue(set.contains(m2));
        set.add(m3);
        testTrue(set.contains(m3));
        testTrue(!set.contains(m4));
        set.add(m4);
        testTrue(set.contains(m4));

        System.out.println("Test 'addAllToQueue' method:");
        MonomialQueue queue = new MonomialQueue();
        set.addAllToQueue(queue);
        testEquals(queue.toString(), "2x^2,3x^2,3x^7,-3x^12");

        System.out.println("Test 'Polynomial':");
        Polynomial p = new Polynomial(set);
        testEquals(p.toString(), "5x^2+3x^7-3x^12");
        set.add(new Monomial(2,0));
        p = new Polynomial(set);
        testEquals(p.toString(), "5x^2+3x^7-3x^12");
        set.add(new Monomial(2,-5));
        set.add(new Monomial(7,-3));
        p = new Polynomial(set);
        testEquals(p.toString(), "-3x^12");
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
}
