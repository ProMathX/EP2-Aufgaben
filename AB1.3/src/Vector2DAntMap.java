/**
 * A simple associative data structure (map) mapping {@link Vector2D} keys to {@link Ant} values.
 *
 * <p>This class represents a minimal key-value association structure.
 * Each {@code Vector2D} key is associated with exactly one {@code Ant} value.
 * Internally the associations are stored in arrays.</p>
 */
public class Vector2DAntMap {

    // TODO: all variables and additional methods are private.
    private Vector2D[] keys;
    private Ant[] values;
    private int currentIndex = -1;

    /**
     * Creates an empty map (with no associations).
     */
    public Vector2DAntMap() {
        keys = new Vector2D[32];
        values = new Ant[32];
    }

    /**
     * Insert a new association into the map.
     *
     * <p>If the specified key already exists, its associated value
     * is replaced with the given value.</p>
     *
     * @param k the key (a {@link Vector2D} position)
     * @param v the value (an {@link Ant})
     * @return the previously associated value, or {@code null} if none existed
     */
    public Ant put(Vector2D k, Ant v) {
        if (containsKey(k)) {
            int index = getIndexOfKey(k);
            Ant value = values[index];
            values[index] = v;
            return value;
        }

        if (size() == keys().size()) {
            increaseCapacity();
        }

        keys[++currentIndex] = k;
        values[currentIndex] = v;

        return null;
    }

    private int getIndexOfKey(Vector2D k) {
        for (int i = 0; i <= currentIndex; i++) {
            if (k == keys[i]) {
                return i;
            }
        }
        return -1;
    }

    private void increaseCapacity() {
        Vector2D[] temp = new Vector2D[keys.length << 1];
        System.arraycopy(keys, 0, temp, 0, keys.length);
        keys = temp;

        Ant[] vTemp = new Ant[values.length << 1];
        System.arraycopy(values, 0, vTemp, 0, values.length);
        values = vTemp;
    }


    /**
     * Remove the association with the given key.
     *
     * @param k the key to remove
     * @return the value previously associated with the key,
     *         or {@code null} if the key was not present
     */
    public Ant remove(Vector2D k) {
        int index = getIndexOfKey(k);
        if (index == -1) {
            return null;
        }

        Ant removed = values[index];

        for (int i = index; i < currentIndex; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }

        keys[currentIndex] = null;
        values[currentIndex] = null;
        currentIndex--;
        return removed;
    }

    /**
     * Return the value associated with the given key.
     *
     * @param k the key to search for
     * @return the associated {@link Ant}, or {@code null} if the key is not present
     */
    public Ant get(Vector2D k) {
        int index = getIndexOfKey(k);
        if (index == -1) {
            return null;
        }

        return values[index];
    }

    /**
     * Check whether the map contains the given key.
     *
     * @param k the key to check
     * @return {@code true} if the key exists in the map,
     *         {@code false} otherwise
     */
    public boolean containsKey(Vector2D k) {
        for (int i = 0; i <= currentIndex; i++) {
            if (keys[i] == k) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check whether the map contains the given value.
     *
     * @param v the value to check
     * @return {@code true} if the value exists in the map,
     *         {@code false} otherwise
     */
    public boolean containsValue(Ant v) {
        for (int i = 0; i <= currentIndex; i++) {
            if (values[i] == v) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the number of stored associations.
     *
     * @return the number of key-value pairs stored within the map.
     */
    public int size() {
        return currentIndex + 1;
    }

    /**
     * Returns all keys stored within in this map.
     *
     * <p>
     * The returned stack contains all {@link Vector2D} keys currently stored
     * in the map. Each key appears exactly once in the stack.
     * The order is not specified.
     * </p>
     *
     * @return a {@link Vector2DStack} containing all stored keys
     */
    public Vector2DStack keys() {
        Vector2DStack keys = new Vector2DStack();
        for (int i = 0; i <= currentIndex; i++) {
            keys.push(this.keys[i]);
        }
        return keys;
    }

    /**
     * Returns all values stored in this map.
     *
     * <p>
     * The returned queue contains all {@link Ant} objects currently stored
     * within the map. Duplicate entries may occur if there is more than
     * one association with the same value. The order is not specified.
     * </p>
     *
     * @return an {@link AntQueue} containing all stored values
     */
    public AntQueue values() {
        AntQueue values = new AntQueue(currentIndex+1);
        for (int i = 0; i < currentIndex+1;i++) {
            values.add(this.values[i]);
        }
        return values;
    }
}