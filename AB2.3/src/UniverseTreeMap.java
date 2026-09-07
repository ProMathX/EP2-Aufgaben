/**
 * An associative data structure (map) mapping {@link Physical} keys
 * to {@link String} values.
 *
 * <p>This class represents a minimal key-value association structure.
 * Each {@code Physical} key object is associated with exactly one {@code String} value.
 * Internally, the associations are stored in a binary search tree.</p>
 *
 * <p>The class works in a similar fashion as {@link PhysicalStringTreeMap} but is intended to be
 * used for storing objects of type {@link CelestialBody}. </p>
 *
 * <p>The ordering of keys is defined by a {@link PhysicalComparator}
 * provided at construction time. All structural decisions in the tree
 * are based on this comparator. Note that the tree may contain multiple
 * distinct key objects which are considered equal by the comparator, as long
 * as they are not identical. </p>
 *
 */

public class UniverseTreeMap {

    private PhysicalStringTreeMapNode root;
    private int size;
    private PhysicalComparator comparator;


    /**
     * Creates an empty map with the specified comparator that defines the key order
     * of this tree.
     *
     * @param comparator the comparator defining the key order; {@code comparator != null}
     */
    public UniverseTreeMap(PhysicalComparator comparator) {

        this.root = null;
        this.size = 0;
        this.comparator = comparator;
    }

    /**
     * Inserts a new association into the map.
     *
     * <p>If the specified key object is already stored in this map
     * (identical key), its associated value is replaced by the given
     * value.</p>
     *
     * <p>Otherwise, a new association is inserted.</p>
     *
     * @param k the key; {@code k != null}
     * @param a the value; {@code a != null}
     * @return the previously associated value, or {@code null} if none existed
     */
    public String put(Physical k, String a) {

        if (root == null) {
            root = new PhysicalStringTreeMapNode(k, a, comparator);
            size++;
            return null;
        }

        String toReturn = root.put(k, a);

        if (toReturn == null) {
            size++;
        }
        return toReturn;
    }

    /**
     * Returns the value associated with the specified key object.
     *
     * <p>If the specified key object is contained in this map (same identity),
     * its associated value is returned. Otherwise, the method returns {@code null}.</p>
     *
     * @param k the key to search for; {@code k != null}
     * @return the associated {@link String}, or {@code null} if the key is not present
     */
    public String get(Physical k) {

        return root == null ? null : root.get(k);
    }

    /**
     * Returns all values stored in this map.
     *
     * <p>The returned array contains all values currently stored in the map.
     * Duplicate entries may occur if different keys are associated with equal
     * values.</p>
     *
     * <p>The values are written in ascending order of their associated keys.</p>
     *
     * @return an array containing all stored values
     */
    public String[] values() {

        String[] result = new String[size];
        if (root != null) {
            root.fillValues(result, 0);
        }
        return result;
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
     * Inserts a new association into this map only if the specified key
     * is strictly smaller than all keys currently stored in the tree
     * according to the {@link PhysicalComparator}, or if the map is currently empty.
     *
     * <p>If {@code k} is not strictly smaller than the current minimum key,
     * the map remains unchanged and the method returns {@code false}.</p>
     *
     * CONSTRAINT: The tree must be traversed exactly once, and traversal must be
     * limited to the nodes required to identify the current minimum key.
     *
     * @param k the key to be inserted; {@code k != null}
     * @param v the value to be associated with the key; {@code v != null}
     * @return {@code true} if the association was added, {@code false} otherwise
     */
    public boolean addIfMinimum(Physical k, String v) {
        boolean minimum = root.isMinimum(k);

        if (!minimum) {
            return false;
        }

        put(k, v);
        return true;
    }


    /**
     * Checks whether this tree is degenerate.
     *
     * <p>A tree is considered degenerate if every node has at most one child.</p>
     *
     * <p>An empty tree is not considered degenerate. If the tree consists only of the root node, it is considered
     * degenerate due ot above definition.</p>
     *
     * @return {@code true} if the tree is degenerate, otherwise {@code false}
     */
    public boolean isDegenerate() {
        if (root == null) {
            return false;
        }

        return root.isDegenerate();
    }

    /**
     * Adds the specified prefix to all values stored in this map.
     *
     * <p>The prefix is prepended to every {@link String} value currently stored
     * in the tree. The structure and key ordering of the tree remain unchanged.</p>
     *
     * CONSTRAINT: The tree must be traversed only once.
     *
     * @param prefix the prefix to add to each value; {@code prefix != null}
     */
    public void addPrefix(String prefix) {
        if (root == null) {
            return;
        }

        root.addPrefix(prefix);
    }

    /**
     * Returns a string representation of this tree.
     * <p>
     * If the tree is empty, {@code "(empty)"} is returned.
     * Otherwise, the result is the ascending order traversal string produced by the root node.
     * Each node is formatted as:
     * <pre>
     * value(LR)
     * </pre>
     * where {@code value} is the node's value, and {@code L} and/or {@code R}
     * are included inside the parentheses if the node has a left and/or right
     * child, respectively (letters are omitted if the corresponding child is absent).
     *
     * Example: for the tree
     *
     *    Earth
     *    /  \
     *  Moon  Saturn
     *          \
     *           Jupiter
     *
     * the method returns "Moon()Earth(LR)Saturn(R)Jupiter()"
     *
     * @return a string representation of the tree structure
     */
    @Override
    public String toString() {
        if (root == null) {
            return "(empty)";
        }

        return root.toString();

    }


}