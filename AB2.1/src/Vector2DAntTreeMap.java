/**
 * A simple associative data structure (map) mapping {@link Vector2D} keys
 * to {@link Ant} values.
 *
 * <p>This class represents a minimal key-value association structure.
 * Each {@code Vector2D} key is associated with exactly one {@code Ant} value.
 * Internally, the associations are stored in a binary search tree.</p>
 *
 * <p>The tree is ordered lexicographically by the coordinates of the keys:
 * first by x-coordinate, and if these are equal, by y-coordinate.
 * Example: (1.0,2.0) < (1.0,3.0) < (1.1, 0.0)</p>
 */
public class Vector2DAntTreeMap {

    private Vector2DAntTreeNode root;
    private int size;

    /**
     * Creates an empty map (with no associations).
     */
    public Vector2DAntTreeMap() {
    }

    /**
     * Inserts a new association into the map.
     *
     * <p>If the specified key already exists, its associated value
     * is replaced by the given value.</p>
     *
     * @param k the key; {@code k != null}
     * @param a the value; {@code a != null}
     * @return the previously associated value, or {@code null} if none existed
     */
    public Ant put(Vector2D k, Ant a) {
        if (root == null) {
            root = new Vector2DAntTreeNode(k, a);
            size++;
            return null;
        }

        Ant put = root.put(k, a);
        if (put == null) {
            size++;
        }
        return put;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param k the key to search for; {@code k != null}
     * @return the associated {@link Ant}, or {@code null} if the key is not present
     */
    public Ant get(Vector2D k) {
        if (root == null) {
            return null;
        }
        Vector2DAntTreeNode node = root.find(k);
        if (node == null) {
            return null;
        }
        return node.getValue();
    }

    /**
     * Returns whether this map contains the given key, meaning it contains a key with
     * the same coordinates as the specified {@code k}.
     *
     * @param k the key to check; {@code k != null}
     * @return {@code true} if the key exists in the map,
     *         {@code false} otherwise
     */
    public boolean containsKey(Vector2D k) {
        if (root == null) {
            return false;
        }
        return root.find(k) != null;
    }

    /**
     * Returns whether this map contains the given value.
     *
     * <p>The tree is searched recursively.</p>
     *
     * @param v the value to check; {@code v != null}
     * @return {@code true} if the value exists in the map,
     *         {@code false} otherwise
     */
    public boolean containsValue(Ant v) {
        if (root == null) {
            return false;
        }
        return root.hasValue(v);
    }

    /**
     * Returns the number of stored associations.
     *
     * @return the number of key-value pairs stored in this map
     */
    public int size() {
        return size;
    }

    /**
     * Returns all keys stored in this map.
     *
     * <p>The returned list contains all {@link Vector2D} keys currently
     * stored in the map. Each key appears exactly once in the list.
     * The keys are returned in ascending order according to the key order
     * of this tree map. The smallest key appears at index {@code 0}
     * of the returned list.</p>
     *
     * @return a list containing all stored keys
     */
    public Vector2DSinglyLinkedList keys() {
        Vector2DSinglyLinkedList list = new Vector2DSinglyLinkedList();

        add(list, root);

        return list;
    }

    private void add(Vector2DSinglyLinkedList list, Vector2DAntTreeNode node) {
       if (node == null) {
           return;
       }

       add(list, node.getLeft());
       list.addLast(node.getKey());
       add(list, node.getRight());
    }

    /**
     * Returns all values stored in this map.
     *
     * <p>The returned array contains all values currently stored in the map.
     * Duplicate entries may occur if different keys are associated with equal
     * values. The order is not specified.</p>
     *
     * @return an array containing all stored values
     */
    public Ant[] values() {
        Ant[] vals = new Ant[size];
        add(vals, 0, root);
        return vals;
    }

    private int add(Ant[] array, int index, Vector2DAntTreeNode node) {
        if (node == null) {
            return index;
        }

        array[index++] = node.getValue();
        index = add(array, index, node.getLeft());
        index = add(array, index, node.getRight());
        return index;
    }
}

