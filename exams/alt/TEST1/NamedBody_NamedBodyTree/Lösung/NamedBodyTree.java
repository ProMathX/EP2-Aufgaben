package Gruppe1430;

// This class represents a collection of 'NamedBody'-objects. It uses a binary search tree to
// store 'NamedBody' objects, sorted according to their distance to the origin (0.0, 0.0, 0.0)
// of the coordinate system.
//
// TODO: define further classes for the implementation of the binary search tree, if needed.
//
public class NamedBodyTree {
    private NamedBody node = null;
    private NamedBodyTree left = null;
    private NamedBodyTree right = null;

    //TODO: Define variables and constructors, if needed.

    // Inserts the specified body to the binary search tree of bodies and returns 'true' if it did
    // not already contain this body before. Otherwise, the body is not added and the method returns
    // 'false'.
    // Precondition: b != null (needs not be checked).
    public boolean add(NamedBody b) {
        if (this.node == null) {
            this.node = b;
            return true;
        } else if (this.node.equals(b)) {
            return false;
        } else if (this.node.distanceToOrigin() > b.distanceToOrigin()) {
            if (this.left != null) {
                return this.left.add(b);
            }
            this.left = new NamedBodyTree();
            this.left.node = b;
            return true;
        } else {
            if (this.right != null) {
                return this.right.add(b);
            }
            this.right = new NamedBodyTree();
            this.right.node = b;
            return true;
        }
        //TODO: implement method.
    }

    // Returns a new object of 'NamedBodyTree' with all bodies of this tree which have at least the
    // specified distance from the origin of the coordinate system (0.0, 0.0, 0.0), which is
    // assumed to be the center of the solar system.
    // If there are no such bodies in this tree, an empty tree is returned.
    // Does not modify any existing objects.
    // The method exploits the binary search tree structure, i.e., traverses only relevant parts
    // of the tree.
    public NamedBodyTree getDistantBodies(double lowestDistance) {
        //TODO: implement method.
        NamedBodyTree toReturn = new NamedBodyTree();
        if (this.node == null) {
            return toReturn;
        } else {
            return getDistantBodiesPlus(lowestDistance, toReturn);
        }
    }

    public NamedBodyTree getDistantBodiesPlus(double lowestDistance, NamedBodyTree toReturn) {
        //TODO: implement method.
        if (this.node == null) {
            return toReturn;
        } else if (this.node.distanceToOrigin() > lowestDistance) {
            if (this.left != null) {
                this.left.getDistantBodiesPlus(lowestDistance, toReturn);
            }
            toReturn.add(this.node);
            if (this.right != null) {
                this.right.getDistantBodiesPlus(lowestDistance, toReturn);
            }
        } else {
            if (this.right != null) {
                this.right.getDistantBodiesPlus(lowestDistance, toReturn);
            }
        }
        return toReturn;
    }

    // Returns 'true' if the object 'b' is contained in the tree (with identity), otherwise it
    // returns 'false'. The method exploits the binary search tree structure, i.e., traverses only
    // relevant parts of the tree.
    // Precodition: b != null (needs not be checked).
    public boolean contains(NamedBody b) {
        //TODO: implement method.
        if (this.node == null) {
            return false;
        }
        if (this.node.equals(b)) {
            return true;
        }
        if (this.node.distanceToOrigin() > b.distanceToOrigin()) {
            return this.left != null && this.left.contains(b);
        } else {
            if (this.right != null) {
                return this.right.contains(b);
            }
        }
        return false;
    }

    // Returns a readable representation with each of the bodies of this tree in a separate line
    // ordered according to their distance to the origin of the coordinate system (center of the
    // solar system). Returns "EMPTY" if 'this' has no bodies.
    // See examples in 'PraxisTest1.java'.
    public String toString() {
        //TODO: implement method.
        if (this.node == null) {
            return "EMPTY";
        } else {
            StringBuilder toReturn = new StringBuilder();
            if (this.left != null) {
                toReturn.append(this.left.toString());
            }
            toReturn.append(this.node.toString() + "\n");
            if (this.right != null) {
                toReturn.append(this.right.toString());
            }
            return toReturn.toString();
        }
    }
}

//TODO: Define additional class(es) implementing the binary search tree
// (either here or in a separate file).
