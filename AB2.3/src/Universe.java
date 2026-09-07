/**
 * A universe that stores celestial bodies sorted by their distance to the origin of the universe located at (0.0, 0.0).
 * Sorting is accomplished in ascending order, meaning the closest body is considered at the first rank.
 *
 * <p>This class maintains a ranking of {@link CelestialBody} objects by using a {@link UniverseTreeMap} with a
 * {@link DistanceComparator} as internal representation. All celestial bodies are stored as keys in the internal
 * map, with their associated names stored as string values.</p>
 */
public class Universe {
    private UniverseTreeMap map = null;

    /**
     * Creates an empty universe.
     *
     * <p>The universe is initialized with a new {@link UniverseTreeMap} that uses
     * a {@link DistanceComparator} to order celestial bodies by their distance to (0.0, 0.0).</p>
     */
    public Universe() {
        this.map = new UniverseTreeMap(new DistanceComparator());
    }

    /**
     * Adds a celestial body to the universe in sorted distance order.
     *
     * <p>If an identical body (same object reference) already exists in this universe,
     * its associated name is updated with the new name provided. Otherwise, the body
     * is inserted at the appropriate position according to its radius.</p>
     *
     * <p>The internal ordering is maintained automatically by the {@link UniverseTreeMap}
     * using the {@link DistanceComparator}.</p>
     *
     * @param b the celestial body to add; {@code b != null}
     * @param name the name to associate with this celestial body; {@code name != null}
     */
    public void addBody(CelestialBody b, String name) {

        this.map.put(b, name);
    }

    /**
     * Returns the name associated with the specified celestial body.
     *
     * <p>Searches for the exact same body object (by reference) in this universe.
     * If found, returns the associated name string. Otherwise, returns {@code null}.</p>
     *
     * <p>Note: This method checks object identity, not distance equality. Two different
     * {@link CelestialBody} objects with the same distance are considered distinct.</p>
     *
     * @param b the celestial body to search for; {@code b != null}
     * @return the associated name string, or {@code null} if the body is not in this universe
     */
    public String getName(CelestialBody b) {

        return this.map.get(b);
    }

    /**
     * Returns the names of all celestial bodies stored in this universe.
     *
     * <p>The returned array contains the names in ascending order of the
     * bodies' distance to the origin (0.0, 0.0), as defined by the
     * {@link DistanceComparator} used internally.</p>
     *
     * <p>If the universe is empty, an empty array is returned.</p>
     *
     * @return an array containing the names of all stored celestial bodies,
     *         sorted by increasing distance to the origin
     */
    public String[] getNames() {
        return this.map.values();
    }

    /**
     * Adds a prefix to celestial body names in this universe.
     *
     * <p>If the specified celestial body exists in this universe (same object
     * reference), the prefix is added only to its associated name.</p>
     *
     * <p>If the specified body does not exist in this universe, the prefix is
     * added to the names of all stored celestial bodies.</p>
     *
     * @param b the celestial body whose name should be prefixed; {@code b != null}
     * @param prefix the prefix to add; {@code prefix != null}
     */
    public void addPrefixToNames(CelestialBody b, String prefix) {
        String s = map.get(b);

        if (s == null) {
            map.addPrefix(prefix);
            return;
        }

        map.put(b, prefix + s);

    }

    /**
     * Adds a celestial body to this universe only if it represents the current minimum.
     *
     * <p>The specified body is inserted only if its distance to the origin (0.0, 0.0)
     * is strictly smaller than the distance of all celestial bodies currently stored
     * in this universe.</p>
     *
     * <p>If the universe is empty, the body is added unconditionally.</p>
     *
     * <p>If the specified body does not qualify as the new minimum, this method
     * leaves the universe unchanged.</p>
     *
     * @param b the celestial body to add if it is the current minimum; {@code b != null}
     * @param v the name to associate with the celestial body; {@code v != null}
     */
    public void addBodyIfMinimum(CelestialBody b, String v) {
        map.addIfMinimum(b, v);
    }
}