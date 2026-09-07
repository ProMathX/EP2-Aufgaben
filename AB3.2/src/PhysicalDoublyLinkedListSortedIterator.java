/**
 * Iterator that returns the elements of a {@link PhysicalDoublyLinkedList}
 * in ascending order according to a {@link PhysicalComparator}.
 *
 * <p>The list itself is not modified. The iterator repeatedly searches for
 * the smallest element that has not yet been returned. Thus, the iterator
 * follows the idea of a selection-based traversal.</p>
 *
 * <p>Only non-{@code null} elements are considered. Entries with value
 * {@code null} are skipped and never returned by this iterator.</p>
 */
public class PhysicalDoublyLinkedListSortedIterator implements PhysicalIterator {

    private PhysicalDoublyLinkedListNode position;
    private PhysicalComparator comparator;
    private PhysicalDoublyLinkedListNode lastReturnedNode;
    private int remaining;

    /**
     * Creates a new sorted iterator.
     *
     * @param head the first node of the list, or {@code null} if the list is empty
     * @param comparator the comparator defining the order; {@code comparator != null}
     */
    public PhysicalDoublyLinkedListSortedIterator(
            PhysicalDoublyLinkedListNode head,
            PhysicalComparator comparator) {
        this.position = head;
        this.comparator = comparator;
        this.lastReturnedNode = null;
        int count = 0;
        PhysicalDoublyLinkedListNode current = head;
        while (current != null) {
            if (current.getValue() != null) count++;
            current = current.getNext();
        }
        this.remaining = count;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        return remaining > 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Physical next() {
        if (remaining == 0) return null;

        PhysicalDoublyLinkedListNode minNode = null;
        boolean passedLast = lastReturnedNode == null;

        PhysicalDoublyLinkedListNode current = position;
        while (current != null) {
            if (current.getValue() != null) {
                if (lastReturnedNode == null) {
                    if (minNode == null || comparator.compare(current.getValue(), minNode.getValue()) < 0) {
                        minNode = current;
                    }
                } else {
                    int cmp = comparator.compare(current.getValue(), lastReturnedNode.getValue());
                    boolean isCandidate = cmp > 0 || (cmp == 0 && passedLast);
                    if (isCandidate && (minNode == null || comparator.compare(current.getValue(), minNode.getValue()) < 0)) {
                        minNode = current;
                    }
                }
            }
            if (current == lastReturnedNode) passedLast = true;
            current = current.getNext();
        }

        lastReturnedNode = minNode;
        remaining--;
        return minNode != null ? minNode.getValue() : null;
    }
}
