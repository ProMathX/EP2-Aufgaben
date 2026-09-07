/**
 * A universe that stores celestial bodies sorted by their radius (descending).
 * The celestial body with the highest radius is always at the first position and
 * represents the largest object in the universe.
 *
 * This class maintains a ranked list of {@link CelestialBody} objects by using a
 * {@link OrderedPhysicalSinglyLinkedList} with a {@link RadiusComparator} as internal representation.
 */
public class Universe {

    private OrderedPhysicalSinglyLinkedList list = null;
    //TODO: add additional variables, if necessary


    /**
     * Creates an empty universe.
     */
    public Universe() {
        this.list = new OrderedPhysicalSinglyLinkedList(new RadiusComparator());
        //TODO: implement method.

    }

    /**
     * Adds a celestial body to the universe in sorted order by radius.
     * If an identical body already exists in this universe, nothing happens.
     *
     * @param b the celestial body to add; {@code b != null}
     */
    public void addBody(CelestialBody b) {
        if (!list.contains(b)) {
            list.insert(b);
        }
        // TODO: implement method.
        
    }

    /**
     * Removes all celestial bodies from this universe whose radius is
     * less than or equal to the radius of the specified {@link Physical}.
     *
     * @param b the reference object used for radius comparison;
     *          {@code p != null}
     */
    public void removeBelow(CelestialBody b) {
        //TODO: implement method.
        list.removeBelow(b);
    }

    /**
     * Returns a formatted String representation of the universe.
     *
     * The representation includes the total number of celestial bodies followed by
     * a comma-separated list of the top 3 bodies in radius order. Each body entry consists
     * of their position number, name, and radius in parentheses.
     *
     * If the universe contains no celestial bodies, the method should return "Empty universe"
     *
     * <p><b>Output format examples:</b></p>
     * <pre>
     * "Empty universe"                                          // empty list
     * "Bodies: 1 | 1. Saturn (58232 km)"                        // single body
     * "Bodies: 2 | 1. Saturn (58232 km), 2. Earth (6371 km)"    // two bodies
     * "Bodies: 3 | 1. Saturn (58232 km), 2. Earth (6371 km), 3. Moon (1737 km)"  // three bodies
     * "Bodies: 5 | 1. Saturn (58232 km), 2. Earth (6371 km), 3. Moon (1737 km)"  // five bodies
     * </pre>
     *
     * Hint: {@link CelestialBody} already contains an implementation of {@code toString()}.
     *
     * @return a String representation in the format "Bodies: {count} | position1. name1 (radius1), position2. name2 (radius2), ..."
     *         or "Empty universe" for an empty list
     */
    @Override
    public String toString() {
        if (list.size() == 0) {
            return "Empty universe";
        }

        Physical[] arr = list.asArray();
        String result = "Bodies: " + arr.length + " | ";

        // Maximum a Top 3-at írjuk ki
        int limit = Math.min(3, arr.length);
        for (int i = 0; i < limit; i++) {
            result += (i + 1) + ". " + arr[i].toString();
            // Csak akkor teszünk vesszőt, ha nem az utolsó elemnél járunk a kiírásban
            if (i < limit - 1) {
                result += ", ";
            }
        }

        //TODO: implement method.
        return result;
    }
}