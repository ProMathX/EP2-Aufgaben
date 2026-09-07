public class ApplicationTest2 {

    public static void main(String[] args) {


        System.out.println("\n===============================================");
        System.out.println("DistanceComparator TESTS");
        System.out.println("===============================================");

        //Remark: positions of bodies are given in Astronomical Units (AU), but do not necessarily correspond
        // to real positions in our solar system.
        //Radius is set to 0, as this property is not used in the given scenario.

        CelestialBody sun = new CelestialBody(new Vector2D(0, 0), 0); //distance 0.0
        CelestialBody mercury = new CelestialBody(new  Vector2D(0, 0.39), 0); //distance 0.39
        CelestialBody earth = new CelestialBody(new Vector2D(1.0, 0), 0); //distance 1.0
        CelestialBody mars = new CelestialBody(new  Vector2D(1.52, 0), 0); //distance 1.52
        CelestialBody jupiter = new CelestialBody(new  Vector2D(0, 5.2), 0); //distance 5.2
        CelestialBody saturn = new CelestialBody(new Vector2D(0, 9.58), 0); //distance 9.58
        CelestialBody neptune = new CelestialBody(new Vector2D(30.1, 0), 0); //distance 30.1

        DistanceComparator comparator = new DistanceComparator();
        check("Comparator comparing smaller with larger", true, comparator.compare(earth, jupiter) < 0);
        check("Comparator comparing larger with smaller", true, comparator.compare(jupiter, earth) > 0);
        check("Comparator comparing equal distances", 0, comparator.compare(new CelestialBody(new Vector2D(0, 1.0), 0), earth));

        System.out.println("\n===============================================");
        System.out.println("UniverseTreeMap TESTS");
        System.out.println("===============================================");

        UniverseTreeMap emptyMap = new UniverseTreeMap(comparator);

        // Add multiple bodies
        UniverseTreeMap multiMap = new UniverseTreeMap(comparator);
        multiMap.put(mars, "Mars");
        multiMap.put(mercury, "Mercury");
        multiMap.put(sun, "Sun");
        multiMap.put(saturn, "Saturn");
        multiMap.put(earth, "Earth");
        multiMap.put(neptune, "Neptune");

        //structure is:
        //              Mars
        //             /   \
        //       Mercury    Saturn
        //      /      \         \
        //    Sun      Earth    Neptune
        check("UniverseTreeMap multiple add size", 6, multiMap.size());
        check("UniverseTreeMap multiple get Earth", "Earth", multiMap.get(earth));
        check("UniverseTreeMap multiple get Sun", "Sun", multiMap.get(sun));

        // Test 1: toString()
        check("UniverseTreeMap toString", "Sun()Mercury(LR)Earth()Mars(LR)Saturn(R)Neptune()", multiMap.toString());
        check("UniverseTreeMap toString empty map", "(empty)", emptyMap.toString());

        // Test 2: addIfMinimum
        boolean added = multiMap.addIfMinimum(new CelestialBody(new Vector2D(0, 0), 0), "New Sun");
        check("UniverseTreeMap addIfMinimum do not add physical with same distance", false, added);
        UniverseTreeMap newMap = new UniverseTreeMap(comparator);
        newMap.put(mercury, "Mercury");
        newMap.put(mars, "Mars");
        newMap.put(earth, "Earth");
        added = newMap.addIfMinimum(sun, "Minimum Distance Sun");
        check("UniverseTreeMap addIfMinimum added", true, added);
        check("UniverseTreeMap addIfMinimum new minimum in map", "Minimum Distance Sun", newMap.get(sun));

        // Test 3: isDegenerate
        check("UniverseTreeMap isDegenerate on balanced tree", false, multiMap.isDegenerate());
        check("UniverseTreeMap isDegenerate on empty tree", false, multiMap.isDegenerate());
        UniverseTreeMap degenerateMap = new UniverseTreeMap(comparator);
        degenerateMap.put(mercury, "Mercury");
        check("UniverseTreeMap isDegenerate on tree with root node only", true, degenerateMap.isDegenerate());
        degenerateMap.put(earth, "Earth");
        degenerateMap.put(mars, "Mars");
        degenerateMap.put(jupiter, "Jupiter");
        check("UniverseTreeMap isDegenerate on degenerate tree", true, degenerateMap.isDegenerate());

        //Test 4
        multiMap.addPrefix("Beautiful ");
        check("UniverseTreeMap addPrefix", "Beautiful Earth", multiMap.get(earth));
        check("UniverseTreeMap addPrefix", "Beautiful Saturn", multiMap.get(saturn));


        System.out.println("\n===============================================");
        System.out.println("Universe TESTS");
        System.out.println("===============================================");

        // Test 1: Empty Universe
        Universe emptyUniverse = new Universe();
        check("Universe empty getName", null, emptyUniverse.getName(earth));
        check("Universe empty getNames", 0, emptyUniverse.getNames().length);

        // Test 2: Add bodies to Universe
        Universe universe = new Universe();
        universe.addBody(mercury, "Mercury");
        universe.addBody(earth, "Earth");
        universe.addBody(jupiter, "Jupiter");
        universe.addBody(saturn, "Saturn");
        universe.addBody(sun, "Sun");

        check("Universe addBody getName Mercury", "Mercury", universe.getName(mercury));
        check("Universe addBody getName Earth", "Earth", universe.getName(earth));
        check("Universe addBody getName Sun", "Sun", universe.getName(sun));

        // Test 3: getNames - returns names in distance order
        String[] names = universe.getNames();
        check("Universe getNames length", 5, names.length);
        check("Universe getNames first (closest)", "Sun", names[0]);      // distance 0.0
        check("Universe getNames second", "Mercury", names[1]);            // distance 0.39
        check("Universe getNames third", "Earth", names[2]);               // distance 1.0
        check("Universe getNames fourth", "Jupiter", names[3]);            // distance 5.2
        check("Universe getNames fifth (farthest)", "Saturn", names[4]);   // distance 9.58

        // Test 4: addPrefixToNames - specific body
        universe.addPrefixToNames(earth, "Blue ");
        check("Universe addPrefixToNames specific", "Blue Earth", universe.getName(earth));
        check("Universe addPrefixToNames other unchanged", "Mercury", universe.getName(mercury));

        // Test 5: addPrefixToNames - all bodies (when body not found)
        CelestialBody unknown = new CelestialBody(new Vector2D(100, 100), 0);
        universe.addPrefixToNames(unknown, "Great ");
        check("Universe addPrefixToNames all", "Great Blue Earth", universe.getName(earth));
        check("Universe addPrefixToNames all Mercury", "Great Mercury", universe.getName(mercury));

        // Test 6: addBodyIfMinimum
        universe = new Universe();
        universe.addBody(jupiter, "Jupiter");
        universe.addBody(saturn, "Saturn");
        universe.addBodyIfMinimum(mercury, "Mercury"); //added
        universe.addBodyIfMinimum(neptune, "Neptune"); //not added
        names = universe.getNames();
        check("Universe addBodyIfMinimum size + 1", 3, names.length);
        check("Universe addBodyIfMinimum new minimum", "Mercury", names[0]);


        System.out.println("\n===============================================");
        System.out.println("ALL TESTS COMPLETED");
        System.out.println("===============================================");
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