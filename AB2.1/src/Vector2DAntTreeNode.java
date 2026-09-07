public class Vector2DAntTreeNode {

    private final Vector2D key;
    private Ant value;
    private Vector2DAntTreeNode left;
    private Vector2DAntTreeNode right;

    public Vector2DAntTreeNode(Vector2D key, Ant value) {
        this.key = key;
        this.value = value;
    }

    public Ant put(Vector2D key, Ant value) {
        int cmp = compare(key);

        if (cmp == 0) {
            Ant old = this.value;
            this.value = value;
            return old;
        } else if (cmp < 0) {
            if (left == null) {
                left = new Vector2DAntTreeNode(key, value);
            } else {
                return left.put(key, value);
            }
        } else {
            if (right == null) {
                right = new Vector2DAntTreeNode(key, value);
            } else {
                return right.put(key, value);
            }
        }
        return null;
    }

    private int compare(Vector2D vector2D) {
        int compare = Double.compare(vector2D.getX(), this.key.getX());

        if (compare == 0) {
            compare = Double.compare(vector2D.getY(), this.key.getY());
        }

        return compare;
    }

    public Vector2DAntTreeNode find(Vector2D key) {
        int cmp = compare(key);
        if (cmp == 0) return this;
        Vector2DAntTreeNode node = cmp < 0 ? left : right;
        if (node == null) return null;
        return node.find(key);
    }

    public boolean hasValue(Ant ant) {
        if (ant.equals(value)) {
            return true;
        }

        boolean found = false;
        if (left != null) {
            found = left.hasValue(ant);
        }

        if (!found && right != null) {
            found = right.hasValue(ant);
        }

        return found;
    }

    public Vector2D getKey() {
        return key;
    }

    public Ant getValue() {
        return value;
    }

    public Vector2DAntTreeNode getLeft() {
        return left;
    }

    public Vector2DAntTreeNode getRight() {
        return right;
    }

}
