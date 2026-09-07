/**
 * A set of {@link Element} elements. This set has no duplicate elements.
 * For simplicity, it only provides selected methods.
 *
 * PLEASE DO NOT CHANGE THIS FILE!
 */
public interface ElementSet extends ElementIterable {

    /**
     * Checks whether the specified element is a member of this set, i.e., if this set
     * has an element equal to the specified element.
     *
     * @param e the element to test for membership, {@code e != null}.
     * @return {@code true} if this set contains an element equal to {@code e};
     *          {@code false} otherwise
     */
    boolean contains(Element e);

    /**
     * {@inheritDoc}
     *
     * The iterator returns each element occurring in this set. The order is not specified.
     *
     * The behavior of an iterator is unspecified if the underlying set is modified while the
     * iteration is in progress (don't worry about this case).
     *
     * @return an iterator over elements of type {@code Element}.
     */
    ElementIterator iterator();
}
