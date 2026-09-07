/**
 * Iterator over the keys stored in a {@link PhysicalPhysicalHashMapSetView}.
 *
 * <p>The iterator scans the internal hash table of the backing map and
 * returns the key of each occupied table entry.</p>
 *
 * <p>The iteration order is determined by the internal table layout and is
 * therefore unspecified.</p>
 */
public class PhysicalPhysicalHashMapSetViewIterator implements PhysicalIterator
{

    private Physical[] keys;
    private int[] modCounterBox;
    private int expectedModCount;

    private int index;

    /**
     * Creates a new iterator over the specified hash table key array.
     *
     * @param keys the internal key array of the hash map;
     *             {@code keys != null}
     * @param modCounterBox shared modification counter reference
     */
    public PhysicalPhysicalHashMapSetViewIterator(Physical[] keys, int[] modCounterBox) {
        this.keys = keys;
        this.modCounterBox = modCounterBox;
        this.expectedModCount = modCounterBox[0];
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
        if (modCounterBox[0] != expectedModCount) {
            throw new ConcurrentModificationException(modCounterBox[0] - expectedModCount);
        }

        if (!hasNext()) {
            return null;
        }

        return keys[index++];
    }
}