/**
 * An associative data structure (map) mapping {@link Physical} keys
 * to {@link Physical} values.
 *
 * <p>This class represents a minimal key-value association structure.
 * Each {@link Physical} key object is associated with exactly one {@link Physical} value.
 *
 * <p>The associations are stored in a binary search tree ordered according
 * to a {@link PhysicalComparator}.</p>
 */
public class PhysicalPhysicalTreeMap implements PhysicalPhysicalMap {

    private PhysicalPhysicalTreeMapNode root;
    private int size;
    private PhysicalComparator comparator;

    /**
     * Creates an empty map ordered according to {@link XComparator}.</p> .
     */
    public PhysicalPhysicalTreeMap() {

        this.root = PhysicalPhysicalTreeMapNodeEmpty.EMPTY;;
        this.size = 0;
        this.comparator = new XComparator();
    }

    /**
     * Creates an empty map with the specified comparator.
     *
     * @param comparator the comparator defining the key order; {@code comparator != null}
     */
    public PhysicalPhysicalTreeMap(PhysicalComparator comparator) {

        this.root = PhysicalPhysicalTreeMapNodeEmpty.EMPTY;
        this.size = 0;
        this.comparator = comparator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Physical put(Physical key, Physical value) {


        Physical[] oldValueBox = new Physical[1];

        root = root.put(key, value, comparator, oldValueBox);

        if (oldValueBox[0] == null) {
            size++;
        }

        return oldValueBox[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Physical get(Physical key) {

        return root.get(key, comparator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsKey(Physical key) {

        return root.containsKey(key, comparator);
    }

    /**
     * {@inheritDoc}
     */
    public boolean containsValue(Physical value) {

        return root.containsValue(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {

        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {

        root = PhysicalPhysicalTreeMapNodeEmpty.EMPTY;
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PhysicalSet keySet() {
        PhysicalSet set = new PhysicalTreeSet();

        root.fillKeys(set);

        return set;
    }

    /**
     * Returns all values stored in this map.
     *
     * <p>The returned set contains all values currently stored in the map (no duplicates).</p>
     *
     * The returned set is independent of this map. Structural changes to this map after the method call do
     * not affect the returned set, and vice versa. The contained Physical objects themselves are not copied.
     *
     * @return a set containing all stored values.
     */
    public PhysicalSet valueSet() {
        PhysicalSet set = new PhysicalTreeSet();

        root.fillValues(set);
        return set;
    }

    /**
     * Returns a string representation of this map.
     *
     * <p>Each node of the underlying binary search tree is shown in its own line.
     * Child nodes are indented relative to their parent so that the tree structure
     * becomes visible.</p>
     *
     * <p>The left subtree is shown before the right subtree.</p>
     *
     * <p>
     * Example:
     *
     * FoodSource@(350.0, 300.0), r=80.0 -> FoodSource@(352.0, 300.0), r=90.0
     *   FoodSource@(300.0, 200.0), r=50.0 -> FoodSource@(350.0, 300.0), r=80.0
     *   Nest@(400.0, 300.0), r=100.0 -> FoodSource@(350.0, 300.0), r=80.0
     *     Nest@(420.0, 320.0), r=20.0 -> FoodSource@(350.0, 300.0), r=80.0
     * </p>
     *
     * @return a string representation of this map
     */
    @Override
    public String toString() {

        if (size == 0) {
            return "(empty)";
        }

        return root.toIndentedString("");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PhysicalPhysicalMap other)) {
            return false;
        }

        if (other.size() != this.size()) {
            return false;
        }

        for (Physical p : this.keySet()) {
            if (!other.containsKey(p)) {
                return false;
            }

            if (!this.get(p).equals(other.get(p))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hc = 0;
        for (Physical p : keySet()) {
            hc += p.hashCode() ^ get(p).hashCode();
        }

        return hc;
    }
}