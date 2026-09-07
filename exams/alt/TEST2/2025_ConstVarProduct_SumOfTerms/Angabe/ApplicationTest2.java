import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class can be modified and is for testing your solution.
 * Modifications will NOT be reviewed or assessed.
 */
public class ApplicationTest2 {

    /**
     * The main method.
     * @param args not used.
     */
    public static void main(String[] args) {

        // TODO: uncomment this block:
        /*
        NonNegIntConst c7 = new NonNegIntConst(7);
        IntVar x = new IntVar("x");
        IntVar y = new IntVar("y");
        IntVar z = new IntVar("z");
        ConstVarProduct p_8xy = new ConstVarProduct(new NonNegIntConst(8), new HashSet<IntVar>(Arrays.asList(x,y)));
        ConstVarProduct p_3z = new ConstVarProduct(new NonNegIntConst(3), new HashSet<IntVar>(Arrays.asList(z)));

        SquareFreeExpression e1 = new ConstVarProduct(c7, new HashSet<IntVar>(Arrays.asList(x,y)));
        SquareFreeExpression e2 = e1.plus(NonNegIntConst.ONE);
        SquareFreeExpression e_1_7xy = e2;

        System.out.println("Test1: 'toString':");
        testEquals(e1.toString(), "7xy");
        testEquals(e2.toString(), "1+7xy");

        System.out.println("\nTest2: 'toString' and 'plus':");
        e1 = e1.plus(new ConstVarProduct(NonNegIntConst.ONE, new HashSet<IntVar>(Arrays.asList(x,y))));
        e2 = e2.plus(new ConstVarProduct(NonNegIntConst.ONE, new HashSet<IntVar>(Arrays.asList(x,y))));
        e2 = e2.plus(p_3z);

        testEquals(e1.toString(), "8xy");
        testEquals(e2.toString(), "1+8xy+3z");
        testEquals(e2.plus(e_1_7xy).toString(), "2+15xy+3z");

        System.out.println("\nTest3: 'equals' and 'hashCode':");
        testEquals(e1, p_8xy);
        testEquals(e1.hashCode(), p_8xy.hashCode());
        testEquals(e2, new ConstVarProduct(new NonNegIntConst(8),
                new HashSet<IntVar>(Arrays.asList(x,y)))
                .plus(new ConstVarProduct(new NonNegIntConst(3), new HashSet<IntVar>(Arrays.asList(z))))
                .plus(NonNegIntConst.ONE));
        testEquals(e2.hashCode(), new ConstVarProduct(new NonNegIntConst(8),
                new HashSet<IntVar>(Arrays.asList(x,y)))
                .plus(new ConstVarProduct(new NonNegIntConst(3), new HashSet<IntVar>(Arrays.asList(z))))
                .plus(NonNegIntConst.ONE).hashCode());

        System.out.println("\nTest4: 'iterator' of 'ConstVarProduct':");
        TermIterator iterator = p_8xy.iterator();
        testEquals(iterator.hasNext(), true);
        testEquals(iterator.next(), p_8xy);
        testEquals(iterator.hasNext(), false);
        try {
            iterator.next();
            System.out.println("FAIL! This statement should not be reached.");
        } catch (NoSuchElementException e) {
            System.out.println("OK");
        }

        System.out.println("\nTest5: 'iterator' of 'SumOfTerms':");
        iterator = e2.iterator();
        HashSet<SquareFreeTerm> elements = new HashSet<>();
        try {
            elements.add(iterator.next());
            testEquals(elements.size(), 1);
            elements.add(iterator.next());
            elements.add(iterator.next());
            testEquals(elements.size(), 3);
        } catch (Exception e) {
            System.out.println("FAIL! This statement should not be reached.");
            System.out.println("    ->" + e.toString());
        }

        testEquals(elements, new HashSet<SquareFreeTerm>(Arrays.asList(p_8xy,p_3z,
                NonNegIntConst.ONE)));
        try {
            iterator.next();
            System.out.println("FAIL! This statement should not be reached.");
        } catch (NoSuchElementException e) {
            System.out.println("OK");
        }

        System.out.println("\nTest6: 'getSetView':");
        IntVar a = new IntVar("a");
        IntVarSet view = e1.getSetView();
        testEquals(view.contains(x), true);
        testEquals(view.contains(y), true);
        testEquals(view.contains(z), false);
        testEquals(view.contains(a), false);
        testEquals(view.copyToHashSet(), new HashSet<>(Arrays.asList(x,y)));
        view = e2.getSetView();
        testEquals(view.contains(x), true);
        testEquals(view.contains(y), true);
        testEquals(view.contains(z), true);
        testEquals(view.contains(a), false);
        testEquals(view.copyToHashSet(), new HashSet<>(Arrays.asList(x,y,z)));
        view.replace(x, a);
        testEquals(e2.toString(), "1+8ay+3z");
        */
        //TODO: end of block to uncomment

    }

    public static void testEquals(Object given, Object expected) {
        if (Objects.equals(given, expected)) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL! Expected value: " + expected + " / Given " +
                    "value: " + given);
        }
    }

    /**
     * Tests whether two linear expressions represented by strings are mathematically equal,
     * ignoring term order.
     * Terms must be of the form [sign]integer[variable], e.g. "-3z", "+7y", "1".
     * The constant term is allowed (variable name empty).
     *
     * @param given the given expression string
     * @param expected the expected expression string
     * @return true if the two expressions simplify to the same coefficients for each variable
     */
    public static void testEquals(String given, String expected) {
        Set<String> terms1 = parseLinear(given);
        Set<String> terms2 = parseLinear(expected);
        if (terms1.equals(terms2)) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL! Expected string: " + terms2.toString().replaceAll("[\\s" +
                    "\\[\\],]","") +
                    " / Given string: " + terms1.toString().replaceAll("[\\s" +
                    "\\[\\],]",""));
            System.out.println(" ... for comparison terms have been rearranged and first term " +
                    "has a '+'.");
        }
    }

    // Parses a linear expression into a map from variable name ("" for constant) to coefficient.
    private static Set<String> parseLinear(String expr) {
        // remove whitespace
        expr = expr.replaceAll("\\s+", "");
        // ensure leading sign
        if (!expr.startsWith("+") && !expr.startsWith("-")) {
            expr = "+" + expr;
        }
        // regex to extract terms: sign + term body
        Pattern termPattern = Pattern.compile("([+-])([^+-]+)");
        Matcher m = termPattern.matcher(expr);

        Set<String> terms = new HashSet<>();
        while (m.find()) {
            String sign = m.group(1);
            char[] bodyArray = m.group(2).toCharArray();
            Arrays.sort(bodyArray);
            String body = new String(bodyArray);
            // match coefficient and optional variable
            Matcher tb = Pattern.compile("(\\d+)([a-zA-Z]*)").matcher(body);
            if (!tb.matches()) {
                throw new IllegalArgumentException("Invalid term: " + sign + body);
            }
            terms.add(sign+body);
        }
        return terms;
    }
}

