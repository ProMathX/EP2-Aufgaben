package Gruppe1000;

// This class represents a single body with no other objects in orbit.
// A named body has a name, a mass in kilograms and a position (type 'Gruppe1000.Vector3').
//
public class NamedBody {
    private String name;
    private double mass;
    private Vector3 position;

    //TODO: declare variables.

    // Initializes this body with name, mass and position.
    // Preconditions (need not be checked):
    // name != null, mass > 0, position != null
    public NamedBody(String name, double mass, Vector3 position) {
        // TODO: implement constructor.
        this.name=name;
        this.mass=mass;
        this.position=position;
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

    // Returns a readable representation of 'this' with the name of the body and its mass.
    public String toString() {
        // TODO: implement method.
        return this.name+": "+this.mass+" kg";
    }
}

