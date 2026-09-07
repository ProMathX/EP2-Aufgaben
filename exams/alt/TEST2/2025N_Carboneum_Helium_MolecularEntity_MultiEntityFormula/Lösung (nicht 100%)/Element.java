import java.util.Objects;

/**
 * This interface represents a chemical element.
 * PLEASE DO NOT CHANGE THIS FILE.
 */
public interface Element extends Comparable<Element> {

    /**
     * Returns a readable representation of {@code this}, which is the element symbol.
     * For example, the element 'Hydrogenium' returns the string representation "H".
     *
     * @return a readable representation of {@code this}.
     */
    String toString();

    /**
     * Compares this element to another for ordering. All elements are ordered lexicographically
     * according to their symbol, except Hydrogenium (`H`) and Carboneum (`C`) which are "less than"
     * other elements (according to Hill order).
     *
     * @param other the other element to compare to; {@code other !=  null}.
     * @return a negative integer, zero, or a positive integer according to the order relation
     * of elements used in chemical formulas.
     */
    @Override
    default int compareTo(Element other) {
        if (this.equals(other)) return 0;

        // check for special cases (Hill order).
        if (this.equals(new Hydrogenium())) return -1;
        if (other.equals(new Hydrogenium())) return 1;
        if (this.equals(new Carboneum())) return -1;
        if (other.equals(new Carboneum())) return 1;

        // all other elements are lexicographically ordered.
        return this.toString().compareTo(other.toString());
    }

    /**
     * Compares {@code this} and {@code obj} for equality.
     *
     * @param obj the object to compare with
     * @return {@code true} if {@code obj} represents the same element as {@code this};
     *         {@code false} otherwise
     */
    @Override
    boolean equals(Object obj);

    /**
     * Returns the hash code of {@code this}.
     *
     * @return the hash code of {@code this}.
     */
    @Override
    int hashCode();
}
