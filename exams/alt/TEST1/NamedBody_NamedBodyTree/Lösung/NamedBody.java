package Gruppe1430;
// This class represents a single body with no other objects in orbit.
// A named body has a name and a position (type 'Vector3').
//
public class NamedBody {
    private String name;
    private Vector3 position;

    // TODO: define missing parts of the class

    // Initializes this body with name, mass and position.
    // Preconditions (need not be checked):
    // name != null, position != null
    public NamedBody(String name, Vector3 position) {
        this.name=name;
        this.position=position;
        // TODO: implement constructor.
    }

    // Returns the name of 'this'.
    public String getName() {
        // TODO: implement method.
        return this.name;
    }

    // Returns the position of 'this'.
    public Vector3 getPosition() {
        // TODO: implement method.
        return this.position;
    }

    // Returns the distance of this body to the
    // coordinate systems origin vector (0.0,0.0,0.0).
    public double distanceToOrigin() {
        // TODO: implement method.
        return position.distanceTo(new Vector3(0.0,0.0,0.0));
    }

    // Returns a readable representation of 'this' with the name of the body and
    // distance to the coordinate systems origin vector (0.0,0.0,0.0).
    public String toString() {
        // TODO: implement method.
        return this.name.toString()+": "+this.distanceToOrigin()+" m";
    }
}