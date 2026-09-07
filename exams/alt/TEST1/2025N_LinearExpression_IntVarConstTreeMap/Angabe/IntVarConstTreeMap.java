/**
 * This data structure maps keys of type {@code IntVar} to values of type {@code IntConst}.
 * It is implemented as a binary search tree where keys are sorted lexicographically according
 * their name (via {@code getName()} of {@code IntVar}) using the {@code compareTo} method of
 * String. The map allows multiple keys with the same name as long as they are not identical.
 * The map also allows a key of {@code null}, where it is assumed that in the key order
 * relation {@code null} is less than any non-{@code null} key.
 * However, {@code null} values are not allowed in this map.
 * There is no limit on the number of key-value mappings stored in the map.
 */
//
// TODO: define further classes and methods for the implementation of the binary search tree, if
//  needed.
//
public class IntVarConstTreeMap {

    //TODO: additional variables, constructors and methods must be private.

    /**
     * Constructs {@code this} as an empty map.
     */
    public IntVarConstTreeMap() {

        //TODO: implement constructor.
    }
    private IntVarConstTreeMap(IntVar key, IntConst value) {
        //TODO: implement constructor.
    }

    /**
     * Constructs this map as a copy of the specified {@code map}. This map will have the same
     * key-value mappings as {@code map}. This map will also have the same tree structure as
     * {@code map}. The individual {@link IntVar} and {@link IntConst} objects themselves are
     * reused (they need not be duplicated, since they are immutable).
     * If {@code map} is changed later, it will not affect {@code this} and vice versa.
     *
     * @param map the map from which key-value mappings are copied to this new map,
     *      {@code map != null}.
     */
    public IntVarConstTreeMap(IntVarConstTreeMap map) {
        //TODO: implement constructor.
    }

    /**
     * Adds a new key-value association to this map. If the key already exists in this map,
     * the value is replaced and the old value is returned. Otherwise, {@code null} is returned.
     *
     * @param key a variable or {@code null}.
     * @param value the constant to be associated with the key, {@code value != null}.
     * @return the old value if the key already existed in this map, or {@code null} otherwise.
     */
    public IntConst put(IntVar key, IntConst value) {
        //TODO: implement method.
        return null;
    }

    /**
     * Returns the value associated with the specified key, i.e. the constant associated with the
     * specified variable. Returns {@code null} if the key is not contained in this map.
     *
     * @param key a variable or {@code null}.
     * @return the value associated with the specified key or {@code null} if the key is
     * not contained in this map.
     */
    public IntConst get(IntVar key) {
        //TODO: implement method.
        return null;
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map.
     */
    public int size() {
        //TODO: implement method.
        return 0;
    }

    /**
     * Returns a new queue with all the keys of this map. The returned queue provides all keys of
     * this map according to the key order relation.
     *
     * This means that for any two keys {@code x} and {@code y}, {@code x} is added before
     * {@code y} to the queue, if {@code x == null && y != null} or
     * if {@code x.getName().compareTo(y.getName()) < 0}.
     * If there are variables with equal names, they are consecutive entries in the returned queue
     * (their relative order is unspecified).
     *
     * @return a queue with the keys of this map.
     */
    public IntVarQueue getKeyQueue() {
        //TODO: implement method.
        return null;
    }

    private IntVarQueue getKeyQueuePlus(IntVarQueue toReturn) {
        //TODO: implement method.
        return null;
    }
}

// TODO: define further classes, if needed (either here or in a separate file).
