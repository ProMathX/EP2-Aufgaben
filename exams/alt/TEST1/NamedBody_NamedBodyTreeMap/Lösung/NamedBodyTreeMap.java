package Gruppe1600;

// This class represents a mapping from a 'Vector2'-position in space to the 'NamedBody'-object
// at that position. 'NamedBodyTreeMap' uses a binary search tree to store its bodies. This class
// uses the 'compareTo' method of 'Vector2' to implement the sorting. ('Vector2'-objects are sorted
// primarily according to their x-coordinates. In case of equal x-coordinates 'Vector2'-objects are
// sorted according to their y-coordinates.)
//
// TODO: define further classes for the implementation of the binary search tree, if needed.
//
public class NamedBodyTreeMap {
    private NamedBody head;
    private Vector2 position;
    private NamedBodyTreeMap left;
    private NamedBodyTreeMap right;

    //TODO: Define variables and constructors, if needed.

    // Inserts the specified key-value pair to the binary search tree of bodies. If the tree
    // already contains a body at the specified position, the result of merging the existing body
    // with the specified body replaces the old value.
    // Precondition: position != null, b != null (needs not be checked).
    public void put(Vector2 position, NamedBody b) {
        if (this.position == null) {
            this.head = b;
            this.position = position;
        } else if (this.position.compareTo(position) == 0) {
            this.head = this.head.merge(b);
        } else if (this.position.compareTo(position) == -1) {
            if (this.right == null) {
                this.right = new NamedBodyTreeMap();
            }
            this.right.put(position, b);
        } else {
            if (this.left == null) {
                this.left = new NamedBodyTreeMap();
            }
            this.left.put(position, b);
        }
        //TODO: implement method.
    }

    // Returns a new object of 'NamedBodyTreeMap' with all bodies of this tree located at the
    // specified x-coordinate, i.e., all bodies with a position in the range from
    // (x, Integer.MIN_VALUE) to (x, Integer.MAX_VALUE).
    // If there are no such bodies in this tree, an empty tree is returned.
    // The method exploits the binary search tree structure, i.e., traverses only relevant parts
    // of the tree.
    public NamedBodyTreeMap getBodiesAtX(int x) {
        //TODO: implement method.
        NamedBodyTreeMap result = new NamedBodyTreeMap();
        if (this.position == null) {
            return result;
        }
        getBodiesAtX(this, x, result);
        return result;
    }

    public void getBodiesAtX(NamedBodyTreeMap current, int x, NamedBodyTreeMap result) {
        //TODO: implement method.
        if (current == null) {
            return;
        }
        int currentXPos = Integer.parseInt(current.position.toString().split(",")[0].substring(1));
        if (currentXPos == x) {
            result.put(current.position, current.head);
        }
        getBodiesAtX(current.left, x, result);
        getBodiesAtX(current.right, x, result);
    }

    // Returns the body with the specified position.
    // The method returns 'null' if no such body exits in the tree.
    // The method exploits the binary search tree structure, i.e., traverses only relevant parts
    // of the tree.
    // Precodition: position != null (needs not be checked).
    public NamedBody get(Vector2 position) {
        //TODO: implement method.
        NamedBody result = null;
        if (this.head == null) {
            return result;
        } else if (this.position.compareTo(position) == 0) {
            return this.head;
        } else if (this.position.compareTo(position) == -1) {
            if (this.right != null) {
                result = this.right.get(position);
            }
        } else {
            if (this.left != null) {
                result = this.left.get(position);
            }

        }
        return result;
    }

    // Returns a readable representation with each of the bodies of this tree
    // in a separate line ordered according to their position.
    // Returns "EMPTY" if the tree has no bodies.
    // See examples in 'PraxisTest1.java'.
    public String toString() {
        //TODO: implement method.
        if (this.head == null) {
            return "EMPTY";
        }
        return this.toStringPlus();
    }

    public String toStringPlus() {
        //TODO: implement method.
        StringBuilder result = new StringBuilder();
        if (this.left != null) {
            result.append(this.left.toStringPlus());
        }
        result.append(this.head.toString() + ", " + this.position + '\n');
        if (this.right != null) {
            result.append(this.right.toStringPlus());
        }
        return result.toString();
    }
}

//TODO: Define additional class(es) implementing the binary search tree
// (either here or in a separate file).