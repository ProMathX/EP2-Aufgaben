/**
 * A singly linked list implementation for storing {@link Physical} objects
 * in sorted order according to a specified {@link PhysicalComparator}.
 * The list is implemented as a recursive data structure with one node
 *  for each element in the list.
 *
 * <p>The ordering of elements is defined by
 * {@link PhysicalComparator#compare(Physical, Physical)}.</p>
 *
 * <p>This list maintains its elements in <strong>descending order</strong>
 * with respect to the comparator. More precisely, for any two consecutive
 * elements {@code a} (before) and {@code b} (after) in the list, it holds that:</p>
 *
 * <pre>
 * comparator.compare(a, b) >= 0
 * </pre>
 *
 * <p>That is, elements considered <em>greater</em> by the comparator
 * appear closer to the head of the list.</p>
 */

public class OrderedPhysicalSinglyLinkedList {

    //TODO: add additional variables, if necessary

    /**
     * Creates an empty list with the given {@link PhysicalComparator}.
     *
     * @param comparator the {@link PhysicalComparator} used for maintaining the order of elements in this list
     *                   (comparator != null)
     */
    public OrderedPhysicalSinglyLinkedList(PhysicalComparator comparator) {

        //TODO: implement method.
    }

    /**
     * Inserts a {@link Physical} into the list while maintaining the ordering
     * defined by {@link PhysicalComparator#compare(Physical, Physical)}.
     *
     * The new element {@code p} is inserted before the first element that is smaller
     * than or equal to {@code p} according to the comparator. If no such element exists,
     * it is appended to the end.
     *
     * The method also allows insertion of multiple identical elements.
     *
     * CONSTRAINT: The method must traverse the list only once!
     *
     * @param p the Physical to insert; {@code p != null}
     */
    public void insert(Physical p) {

        //TODO: implement method
        
    }


    /**
     * Returns whether this list contains a Physical equal to the specified Physical.
     *
     * <p>Equality is determined using the identity operator {@code ==}.</p>
     *
     * CONSTRAINT: The method should exploit the ordering of elements and visit only
     * the necessary nodes.  In particular, the method must not visit nodes that cannot
     * possibly contain {@code p} due to the ordering.
     *
     * @param p the element to search for; {@code p != null}
     * @return {@code true} if this list contains an element identical to {@code p},
     * {@code false} otherwise
     */
    public boolean contains(Physical p) {
        return false;
        //TODO: implement method.
    }

    /**
     * Returns an array of length {@code this.size()} containing all Physicals in this list, in order from head to the
     * end of the list.
     *
     * CONSTRAINT: The method must traverse the list only once!
     *
     * @return an array of all Physicals in the list
     */
    public Physical[] asArray() {
        return null;
        //TODO: implement method.
    }

    /**
     * Returns the number of elements currently stored in the list.
     *
     * @return the current size of the list
     */
    public int size() {
        return 0;
        //TODO: implement method.
    }

    /**
     * Removes all elements {@code x} from this list for which {@code comparator.compare(x, p) <= 0} holds.
     *
     * After execution, only elements {@code x} with {@code comparator.compare(x, p) > 0} remain.
     *
     * <p>CONSTRAINT: The method must traverse the list only once.</p>
     *
     * @param p the reference element; {@code p != null}
     */
    public void removeBelow(Physical p) {

        // TODO: implement method.
        
    }
}

