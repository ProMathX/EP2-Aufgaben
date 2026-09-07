package Gruppe1000;
// A hierarchical system of cosmic bodies with a central body. Subsystems can be in orbit.
//
// TODO: Implementation the tree structure of the hierarchical system.
//  Do NOT use the Java-Collection framework in your implementation (arrays are allowed).
//
public class HierarchicalSystem {
    private NamedBody centralBody;
    private HierarchicalSystem[] nodes;

    //TODO: Define variables and constructors, if needed.

    // Initializes this system with its central body and
    // optionally additional bodies in orbit.
    // If inOrbit.length == 0, 'this' represents a single body (= leaf node of a hierarchical
    // system).
    // Precondition: centralBody != null (needs not be checked).
    public HierarchicalSystem(NamedBody centralBody, HierarchicalSystem... inOrbit) {
        this.centralBody=centralBody;
        this.nodes=inOrbit;
        // TODO: implement constructor.
    }

    // Returns a readable representation similar as does 'toString()', however with an additional
    // indent in each line specified by the number of blanks.
    // Precondition: indent >= 0 (needs not be checked).
    public String toString(int indent) {
        //TODO: implement method.
        StringBuilder toReturn=new StringBuilder();
        toReturn.append(indent+" "+this.centralBody.toString()+'\n');
        for (int i = 0; i < nodes.length; i++) {
            toReturn.append(nodes[i].toStringLevel(indent, 1));
        }
        return toReturn.toString();
    }
    public String toStringLevel(int indent, int level) {
        //TODO: implement method.
        StringBuilder toReturn=new StringBuilder();
        for (int i = 0; i < level; i++) {
            toReturn.append("\t");
        }
        toReturn.append(this.centralBody.toString()+'\n');
        for (int i = 0; i < nodes.length; i++) {
            toReturn.append(nodes[i].toStringLevel(indent, level+1));
        }
        return toReturn.toString();
    }

    // Returns a readable representation of 'this' with the name of each body and its mass. Each
    // body is shown in a separate line. Subsystems are indented to reflect the tree like
    // structure of the entire system (see the example in 'Gruppe1000.PraxisTest1.java').
    public String toString() {
        //TODO: implement method.
        StringBuilder toReturn=new StringBuilder();
        toReturn.append(this.centralBody.toString()+'\n');
        for (int i = 0; i < nodes.length; i++) {
            toReturn.append(nodes[i].toStringLevel(1));
        }
        return toReturn.toString();
    }

    public String toStringLevel(int level) {
        //TODO: implement method.
        StringBuilder toReturn=new StringBuilder();
        for (int i = 0; i < level; i++) {
            toReturn.append("\t");
        }
        toReturn.append(this.centralBody.toString()+'\n');
        for (int i = 0; i < nodes.length; i++) {
            toReturn.append(nodes[i].toStringLevel(level+1));
        }
        return toReturn.toString();
    }


    // Returns the name of the central body of 'this'.
    public String getName() {
        //TODO: implement method.
        return this.centralBody.getName();
    }

    // Returns the number of bodies of 'this', including its central body and all bodies in
    // its orbit, with a distance to 'b' lower than the specified range.
    // Precondition: b != null, range >= 0 (needs not be checked).
    public int countWithinRange(NamedBody b, double range) {
        //TODO: implement method.
        int count=0;
        if(centralBody.getPosition().distanceTo(b.getPosition())<range){
            count++;
        }
        for (int i = 0; i < nodes.length; i++) {
            count+=nodes[i].countWithinRange(b,range);
        }
        return count;
    }

    // Returns 'true', if the distance of at least one of the bodies of 'this'
    // to one of the bodies of 'hs' is below the specified range.
    // (Bodies of a system include the central body and recursively all bodies in the orbit.)
    // Precondition: hs != null, range >= 0 (needs not be checked).
    public boolean withinRange(HierarchicalSystem hs, double range) {
        //TODO: implement method.
        if(withinRangePlus(hs.centralBody,range)){
            return true;
        }
        for (int i = 0; i < hs.nodes.length; i++) {
            if(withinRangePlus(hs.nodes[i].centralBody, range)){
                return true;
            }
        }
        return false;

    }

    public boolean withinRangePlus(NamedBody hs, double range) {
        if(hs.getPosition().distanceTo(centralBody.getPosition())<range){
            return true;
        }
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i].withinRangePlus(hs, range)){
                return true;
            }
        }
        return false;

    }


}


