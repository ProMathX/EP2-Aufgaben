/**
 * Doubly linked list with elements of type {@link Physical}.
 *
 * <p>The list is implemented as a (non-cyclic) doubly linked structure with
 * references to the first (head) and last node (last).</p>
 */
public class PhysicalDoublyLinkedList {

    private PhysicalDoublyLinkedListNode head;
    private PhysicalDoublyLinkedListNode last;
    private int size;

    /**
     * Creates an empty list.
     */
    public PhysicalDoublyLinkedList() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Creates a new list that is a copy of the specified list. Later changes of
     * {@code this} (like adding or removing elements) will not affect {@code list} and
     * vice versa.
     *
     * <p>The new list contains the same elements and in the same order
     * as {@code list}.</p>
     *
     * @param list the list to copy; {@code list != null}
     */
    public PhysicalDoublyLinkedList(PhysicalDoublyLinkedList list) {
        this();

        if (list.isEmpty()) {
            return;
        }

        PhysicalDoublyLinkedListNode listNode = list.head;

        while (listNode != null) {
            addLast(listNode.getValue());
            listNode = listNode.getNext();
        }

    }

    /**
     * Adds an element at the head of the list.
     *
     * @param v the element to add
     */
    public void addFirst(Physical v) {
        PhysicalDoublyLinkedListNode node = new PhysicalDoublyLinkedListNode(v, null, head);
        if (isEmpty()) {
            head = node;
            last = node;
        } else {
            head.setPrev(node);
            head = node;
        }
        size++;
    }

    /**
     * Adds an element at the end of the list.
     *
     * @param p the element to add
     */
    public void addLast(Physical p) {
        PhysicalDoublyLinkedListNode node = new PhysicalDoublyLinkedListNode(p, last, null);

        if (isEmpty()) {
            head = node;
            last = node;
        } else {
            last.setNext(node);
            last = node;
        }
        size++;
    }

    /**
     * Adds an element at the specified position in the list.
     *
     * <p>If {@code index == 0}, the element is inserted at the head of the list.
     * If {@code index == size()}, the element is inserted at the end of the list.
     * All elements currently stored at positions greater than or equal to
     * {@code index} are shifted by one position toward the end of the list.</p>
     *
     * @param index the position at which the element is to be inserted;
     *              {@code 0 <= index <= size()}
     * @param p     the element to add
     */
    public void add(int index, Physical p) {
        if (index == 0) {
            addFirst(p);
            return;
        }

        if (index == size) {
            addLast(p);
            return;
        }

        PhysicalDoublyLinkedListNode node = head;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        PhysicalDoublyLinkedListNode prev = node.getPrev();

        PhysicalDoublyLinkedListNode toInsert = new PhysicalDoublyLinkedListNode(p, prev, node);

        prev.setNext(toInsert);
        node.setPrev(toInsert);
        size++;
    }

    /**
     * Removes and returns the head element of the list.
     *
     * <p>This method removes the first element of the list.</p>
     *
     * @return the first element in the list, or {@code null} if {@code size() == 0}
     */
    public Physical pollFirst() {
        if (isEmpty()) {
            return null;
        }

        Physical value = head.getValue();

        head = head.getNext();
        if (head == null) {
            last = null;
        } else {
            head.setPrev(null);
        }
        size--;

        return value;
    }

    /**
     * Removes and returns the last element of the list.
     *
     * <p>This method removes the last element of the list.</p>
     *
     * @return the last element in the list, or {@code null} if {@code size() == 0}
     */
    public Physical pollLast() {
        if (isEmpty()) {
            return null;
        }

        Physical value = last.getValue();

        last = last.getPrev();
        if (last == null) {
            head = null;
        } else {
            last.setNext(null);
        }
        size--;

        return value;
    }

    /**
     * Returns the head element of the list without removing it.
     *
     * <p>The list remains unchanged after this operation.</p>
     *
     * @return the first element in the list, or {@code null} if {@code size() == 0}
     */
    public Physical peekFirst() {
        if (isEmpty()) {
            return null;
        }

        return head.getValue();
    }

    /**
     * Returns the last element of the list without removing it.
     *
     * <p>The list remains unchanged after this operation.</p>
     *
     * @return the last element in the list, or {@code null} if {@code size() == 0}
     */
    public Physical peekLast() {
        if (isEmpty()) {
            return null;
        }
        return last.getValue();
    }

    /**
     * Returns whether this list contains the specified element (identical to `p`).
     *
     * @param p the element to search for
     * @return {@code true} if present, otherwise {@code false}
     */
    public boolean contains(Physical p) {
        PhysicalDoublyLinkedListNode current = head;

        while (current != null) {
            if (current.getValue() == p) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Returns the element at the specified position in the list.
     *
     * <p>The first element has index {@code 0}.</p>
     *
     * @param index the index of the element to return;
     *              {@code 0 <= index < size()}
     * @return the element at the specified position
     */
    public Physical get(int index) {
        if (isEmpty()) {
            return null;
        }

        PhysicalDoublyLinkedListNode current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    /**
     * Removes and returns the element at the specified position in the list.
     *
     * <p>All elements following the removed element are shifted by one position
     * toward the head of the list.</p>
     *
     * @param index the index of the element to remove;
     *              {@code 0 <= index < size()}
     * @return the removed element
     */
    public Physical remove(int index) {
        if (isEmpty()) {
            return null;
        }

        PhysicalDoublyLinkedListNode toRemove = head;

        if (size() == 1) {
            pollFirst();
            return toRemove.getValue();
        }

        for (int i = 0; i < index; i++) {
            toRemove = toRemove.getNext();
        }

        PhysicalDoublyLinkedListNode prev = toRemove.getPrev();
        PhysicalDoublyLinkedListNode next = toRemove.getNext();

        if (prev == null) {
            head = next;
        } else {
            prev.setNext(next);
        }

        if (next == null) {
            last = prev;
        } else {
            next.setPrev(prev);
        }

        size--;
        return toRemove.getValue();
    }

    /**
     * Returns whether this list contains no elements.
     *
     * @return {@code true} if {@code size() == 0}, {@code false} otherwise
     */
    public boolean isEmpty() {

        return size() == 0;
    }

    /**
     * Removes all elements from the list.
     */
    public void clear() {
        head = null;
        last = null;
        size = 0;
    }

    /**
     * Returns the number of elements currently stored in the list.
     *
     * @return the current size of the list
     */
    public int size() {
        return size;
    }
}
