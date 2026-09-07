/**
 * Set view of the keys stored in a {@link PhysicalPhysicalHashMap}.
 *
 * <p>This set is backed by the underlying map. Changes to the map are
 * reflected in this set view, and changes performed through this set view
 * affect the underlying map.</p>
 *
 * <p>Adding an element to this set inserts the element as a key into the
 * underlying map and associates it with {@code null}.</p>
 *
 * <p>The iteration order is determined by the internal hash table and is
 * not specified. Iterators of this set view may throw
 * {@link ConcurrentModificationException} if the backing map is structurally
 * modified during iteration.</p>
 */
public class PhysicalPhysicalHashMapSetView implements PhysicalSet {

    private PhysicalPhysicalHashMap map;
    private Physical[][] keysBox;
    private int[] modCounterBox;

    /**
     * Creates a new key-set view backed by the specified map.
     *
     * @param map the backing map; {@code map != null}
     * @param keysBox a shared mutable reference to the internal key array
     *                of the backing map; {@code keysBox != null}
     *                and {@code keysBox.length >= 1}
     * @param modCounterBox a shared mutable modification counter used to
     *                      detect structural changes during iteration;
     *                      {@code modCounterBox != null}
     *                      and {@code modCounterBox.length >= 1}
     */
    public PhysicalPhysicalHashMapSetView(
            PhysicalPhysicalHashMap map,
            Physical[][] keysBox,
            int[] modCounterBox) {

        this.map = map;
        this.keysBox = keysBox;
        this.modCounterBox = modCounterBox;
    }

    /**
     * {@inheritDoc}
     *
     * <p>If {@code p} is not already a key of the backing map, it is inserted
     * with associated value {@code null}.</p>
     *
     * <p>If an equal key already exists, the backing map remains unchanged.</p>
     *
     * @param p the element to add; {@code p != null}
     * @return {@code true} if the backing map changed as a result of the call,
     *         otherwise {@code false}
     */
    @Override
    public boolean add(Physical p) {
        if (contains(p)) {
            return false;
        } else {
            map.put(p, null);
            return true;
        }
    }

    @Override
    public boolean contains(Physical p) {
        return map.containsKey(p);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public PhysicalIterator iterator() {
        return new PhysicalPhysicalHashMapSetViewIterator(keysBox[0], modCounterBox);
    }
}