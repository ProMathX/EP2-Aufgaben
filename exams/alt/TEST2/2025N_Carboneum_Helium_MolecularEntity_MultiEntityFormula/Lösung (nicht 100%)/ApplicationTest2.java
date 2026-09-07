import java.util.*;

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

        //TODO: uncomment this block:
        SingleEntityFormula H2CO3 = new MolecularEntity(
            new HashMap<Element, Integer>(Map.of(
                    new Hydrogenium(), 2,
                    new Carboneum(), 1,
                    new Oxygenium(), 3)));
        SingleEntityFormula CO2 = new MolecularEntity(
            new HashMap<Element, Integer>(Map.of(new Carboneum(), 1, new Oxygenium(), 2)));
        SingleEntityFormula H2O = new MolecularEntity(
            new HashMap<Element, Integer>(Map.of(new Hydrogenium(), 2, new Oxygenium(), 1)));
        SingleEntityFormula CO = new MolecularEntity(
            new HashMap<Element, Integer>(Map.of(new Carboneum(), 1, new Oxygenium(), 1)));
        SingleEntityFormula CH4 = new MolecularEntity(
            new HashMap<Element, Integer>(Map.of(new Carboneum(), 1, new Hydrogenium(), 4)));
        SingleEntityFormula C2H4 = new MolecularEntity(
            new HashMap<Element, Integer>(Map.of(new Carboneum(), 2, new Hydrogenium(), 4)));
        SingleEntityFormula O2 = new MolecularEntity(
            new HashMap<Element, Integer>(Map.of(new Oxygenium(), 2)));
        SingleEntityFormula H2 = new MolecularEntity(
            new HashMap<Element, Integer>(Map.of(new Hydrogenium(), 2)));
        SingleEntityFormula carbon = new Carboneum();
        SingleEntityFormula helium = new Helium();

        System.out.println("Test1: 'toString':");
        testEquals(carbon.toString(), "C");
        testEquals(H2O.toString(), "H2O");
        testEquals(H2CO3.toString(), "H2CO3");

        System.out.println("\nTest2: 'toString' and 'add':");

        MultiEntityFormula mix1 = new MultiEntityFormula(H2O, CO2);
        MultiEntityFormula mix2 = new MultiEntityFormula(carbon, carbon);
        mix2.add(O2);
        MultiEntityFormula mix3 = new MultiEntityFormula(carbon, O2);
        MultiEntityFormula mix4 = new MultiEntityFormula(H2, O2);
        mix4.add(H2);
        MultiEntityFormula mix5 = new MultiEntityFormula(H2, H2);
        mix5.add(O2);
        testEquals(mix1.toString(), "H2O+CO2");
        testEquals(mix2.toString(), "2C+O2");
        testEquals(mix3.toString(), "C+O2");
        testEquals(mix4.toString(), "2H2+O2");
        testEquals(mix5.toString(), "2H2+O2");

        System.out.println("\nTest3: 'equals' and 'hashCode':");
        testEquals(new Helium(), helium);
        testEquals(new Helium().hashCode(), helium.hashCode());
        testEquals(new MolecularEntity(
                new HashMap<Element, Integer>(Map.of(new Hydrogenium(), 2, new Oxygenium(), 1))), H2O);
        testEquals(new MultiEntityFormula(CO2, H2O), mix1);
        testEquals(new MultiEntityFormula(CO2, H2O).hashCode(), mix1.hashCode());
        testEquals(mix4, mix5);
        testEquals(mix4.hashCode(), mix5.hashCode());

//        System.out.println("\nTest4: 'tryReact', 'toString' and 'equals':");
//        testEquals(mix1.tryReact().toString(), "H2CO3");
//        testEquals(new MultiEntityFormula(CO2, H2O).tryReact().toString(), "H2CO3");
//        testEquals(new MultiEntityFormula(CO2, H2O).tryReact() instanceof SingleEntityFormula,
//                true);
//        testEquals(new MultiEntityFormula(CO2, H2O).tryReact(), H2CO3);
//        testEquals(mix3.tryReact().toString(), "CO2");
//        testEquals(mix1.tryReact(), mix1, false);
//        testEquals(mix4.tryReact().toString(), "2H2O");
//        testEquals(mix4.tryReact(), mix5.tryReact());

        System.out.println("\nTest5: 'getElementSetView' and its 'iterator':");

        MultiEntityFormula test = new MultiEntityFormula(H2, H2);
        ElementSet view = test.getElementSetView();
        testEquals(view.contains(new Hydrogenium()), true);
        testEquals(view.contains(new Oxygenium()), false);
        ElementIterator iterator = view.iterator();

        testEquals(iterator.hasNext(), true);
        try {
            testEquals(iterator.next(), new Hydrogenium());
        } catch (Exception e) {
            System.out.println("FAIL! This statement should not be reached.");
            System.out.println("    ->" + e.toString());
        }
        testEquals(iterator.hasNext(), false);
        try {
            System.out.println(iterator.next());
            System.out.println("FAIL! This statement should not be reached " +
                    "('next' has not thrown Exception).");
        } catch (NoSuchElementException e) {
            System.out.println("OK");
        }
        test.add(O2);
        TreeSet<Element> elements = new TreeSet<>();
        iterator = view.iterator();
        testEquals(iterator.hasNext(), true);
        try {
            elements.add(iterator.next());
            testEquals(elements.size(), 1);
            elements.add(iterator.next());
            testEquals(elements.size(), 2);
            testEquals(elements.contains(new Oxygenium()), true);
            testEquals(elements.contains(new Hydrogenium()), true);
        } catch (NoSuchElementException e) {
            System.out.println("FAIL! This statement should not be reached.");
            System.out.println("    ->" + e.toString());
        }
        try {
            System.out.println(iterator.next());
            System.out.println("FAIL! This statement should not be reached " +
                    "('next' has not thrown Exception).");
        } catch (NoSuchElementException e) {
            System.out.println("OK");
        }

        //TODO: end of block to uncomment.
    }

    public static void testEquals(Object given, Object expected) {
        if (Objects.equals(given, expected)) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL! Expected value: " + expected + " / Given " +
                    "value: " + given);
        }
    }

    public static void testEquals(Object given, Object expected, boolean expValue) {
        if (Objects.equals(given, expected) == expValue) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL! Expected value: " + expected + " / Given " +
                    "value: " + given);
        }
    }

    /**
     * Outputs OK if the two multi-entity formulas simplify to the same coefficients for each
     * entity.
     *
     * @param given the given formula string.
     * @param expected the expected formula string.
     */
    public static void testEquals(String given, String expected) {
        given = given.replaceAll("\\s", "");
        expected = expected.replaceAll("\\s", "");
        Set<String> terms1 = new HashSet<>(Arrays.asList(given.split("\\+")));
        Set<String> terms2 = new HashSet<>(Arrays.asList(expected.split("\\+")));
        if (terms1.equals(terms2)) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL! Expected string: " + terms2.toString()
                    .replaceAll("[\\s\\[\\]]","").replaceAll(",","+") +
                    " / Given string: " + terms1.toString()
                    .replaceAll("[\\s\\[\\]]","").replaceAll(",","+"));
            System.out.println(" ... for comparison terms have been rearranged.");
        }
    }

}

