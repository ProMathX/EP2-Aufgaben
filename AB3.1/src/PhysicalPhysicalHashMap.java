/**
 * Hash-table implementation of {@link PhysicalPhysicalMap}.
 *
 * <p>This implementation uses open addressing with linear probing.
 * Keys are compared using {@code equals}; hash positions are computed
 * using {@code hashCode}.</p>
 *
 * <p>This map does not store {@code null} keys or {@code null} values.</p>
 */
public class PhysicalPhysicalHashMap implements PhysicalPhysicalMap {

    private Physical[] keys;
    private Physical[] values;
    private int size;

    /**
     * Creates an empty map.
     */
    public PhysicalPhysicalHashMap() {
        keys = new Physical[10];
        values = new Physical[10];
        size = 0;
    }

    private int getIndex(Physical key) {
        int index = key.hashCode() % keys.length;
        if (index < 0) {
            index = index + keys.length;
        }
        return index;
    }

    @Override
    public Physical put(Physical key, Physical value) {
        if (size >= keys.length / 2) {
            Physical[] oldKeys = keys;
            Physical[] oldValues = values;
            keys = new Physical[oldKeys.length * 2];
            values = new Physical[oldValues.length * 2];
            size = 0;
            for (int i = 0; i < oldKeys.length; i++) {
                if (oldKeys[i] != null) {
                    put(oldKeys[i], oldValues[i]);
                }
            }
        }

        int index = getIndex(key);

        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                Physical oldValue = values[index];
                values[index] = value;
                return oldValue;
            }
            index = (index + 1) % keys.length;
        }

        keys[index] = key;
        values[index] = value;
        size++;
        return null;
    }

    @Override
    public Physical get(Physical key) {
        int index = getIndex(key);

        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % keys.length;
        }

        return null;
    }

    @Override
    public boolean containsKey(Physical key) {
        return get(key) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        keys = new Physical[10];
        values = new Physical[10];
        size = 0;
    }
}
