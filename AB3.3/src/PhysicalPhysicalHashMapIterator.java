/**
 * Iterator over the keys stored in a {@link PhysicalPhysicalHashMap}.
 *
 * <p>The iterator scans the internal hash table and
 * returns the key of each occupied table entry.</p>
 *
 * <p>The iteration order is determined by the internal table layout and is
 * therefore unspecified.</p>
 */
public class PhysicalPhysicalHashMapIterator implements PhysicalIterator
{

    private Physical[] keys;
    private int index;

    /**
     * Creates a new iterator over the specified hash table key array.
     *
     * @param keys the internal key array of the hash map;
     *             {@code keys != null}
     */
    public PhysicalPhysicalHashMapIterator(Physical[] keys) {
        this.keys = keys;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        while (index < keys.length && keys[index] == null) {
            index++;
        }

        return index < keys.length;
    }

    @Override
    public Physical next() {
        if (!hasNext()) {
            return null;
        }

        return keys[index++];
    }
}