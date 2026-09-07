/**
 * Iterator over a {@link PhysicalDoublyLinkedList}.
 *
 * <p>The iterator traverses the list from the first element to the last
 * element.</p>
 */
public class PhysicalDoublyLinkedListIterator implements PhysicalIterator {

    PhysicalDoublyLinkedListNode position;

    /**
     * Creates a new iterator starting at the specified node.
     *
     * @param start the first node to be returned, or {@code null} if the
     *              iteration is empty
     */
    public PhysicalDoublyLinkedListIterator(PhysicalDoublyLinkedListNode start) {
        this.position = start;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        return position != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Physical next() {
        if (position == null) {
            return null;
        }
        Physical value = position.getValue();
        position = position.getNext();
        return value;
    }
}