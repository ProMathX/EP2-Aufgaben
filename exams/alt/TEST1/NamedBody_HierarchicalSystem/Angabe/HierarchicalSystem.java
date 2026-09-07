package Gruppe1000;
// A hierarchical system of cosmic bodies with a central body. Subsystems can be in orbit.
//
// TODO: Implementation the tree structure of the hierarchical system.
//  Do NOT use the Java-Collection framework in your implementation (arrays are allowed).
//
public class HierarchicalSystem {
    //TODO: Define variables and constructors, if needed.

    // Initializes this system with its central body and
    // optionally additional bodies in orbit.
    // If inOrbit.length == 0, 'this' represents a single body (= leaf node of a hierarchical
    // system).
    // Precondition: centralBody != null (needs not be checked).
    public HierarchicalSystem(NamedBody centralBody, HierarchicalSystem... inOrbit) {
        // TODO: implement constructor.
    }

    // Returns a readable representation similar as does 'toString()', however with an additional
    // indent in each line specified by the number of blanks.
    // Precondition: indent >= 0 (needs not be checked).
    public String toString(int indent) {
        //TODO: implement method.
        return null;
    }
    public String toStringLevel(int indent, int level) {
        //TODO: implement method.
        return null;
    }

    // Returns a readable representation of 'this' with the name of each body and its mass. Each
    // body is shown in a separate line. Subsystems are indented to reflect the tree like
    // structure of the entire system (see the example in 'Gruppe1000.PraxisTest1.java').
    public String toString() {
        //TODO: implement method.
        return null;
    }

    public String toStringLevel(int level) {
        //TODO: implement method.
        return null;
    }


    // Returns the name of the central body of 'this'.
    public String getName() {
        //TODO: implement method.
        return null;
    }

    // Returns the number of bodies of 'this', including its central body and all bodies in
    // its orbit, with a distance to 'b' lower than the specified range.
    // Precondition: b != null, range >= 0 (needs not be checked).
    public int countWithinRange(NamedBody b, double range) {
        //TODO: implement method.
        return 0;
    }

    // Returns 'true', if the distance of at least one of the bodies of 'this'
    // to one of the bodies of 'hs' is below the specified range.
    // (Bodies of a system include the central body and recursively all bodies in the orbit.)
    // Precondition: hs != null, range >= 0 (needs not be checked).
    public boolean withinRange(HierarchicalSystem hs, double range) {
        //TODO: implement method.
        return false;

    }


}


