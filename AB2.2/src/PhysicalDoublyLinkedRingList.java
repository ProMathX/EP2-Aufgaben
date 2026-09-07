/**
 * Doubly linked circular list with sentinel (NIL) node
 * and elements of type {@link Physical}.
 *
 * <p>The list is implemented as a doubly linked ring. A dedicated NIL node
 * is always present and simplifies all insert/remove operations:
 * for an empty list, {@code nil.next == nil} and {@code nil.prev == nil}.</p>
 */
public class PhysicalDoublyLinkedRingList {

    private ListNode nil;
    private int size;

    /**
     * Creates an empty list.
     */
    public PhysicalDoublyLinkedRingList() {
        nil = new ListNode(null);
        nil.setNext(nil);
        nil.setPrev(nil);
        size = 0;
    }

    /**
     * Creates a new list that is a copy of the specified list.
     * Later changes of {@code this} do not affect {@code list} and vice versa.
     *
     * @param list the list to copy; {@code list != null}
     */
    public PhysicalDoublyLinkedRingList(PhysicalDoublyLinkedRingList list) {
        nil = new ListNode(list.nil.getValue());
        nil.setNext(nil);
        nil.setPrev(nil);

        ListNode node = list.nil.getNext();
        for (int i = 0; i < list.size; i++) {
            addLast(node.getValue());
            node = node.getNext();
        }
    }

    /**
     * Adds an element at the head of the list.
     *
     * @param p the element to add
     */
    public void addFirst(Physical p) {
        ListNode listNode = new ListNode(p);

        if (size == 0) {
            nil.setNext(listNode);
            nil.setPrev(listNode);
            listNode.setNext(nil);
            listNode.setPrev(nil);
        } else {
            listNode.setNext(nil.getNext());
            listNode.setPrev(nil);
            nil.getNext().setPrev(listNode);
            nil.setNext(listNode);
        }
        size++;
    }

    /**
     * Adds an element at the end of the list.
     *
     * @param p the element to add
     */
    public void addLast(Physical p) {
        ListNode listNode = new ListNode(p);

        if (size == 0) {
            nil.setNext(listNode);
            nil.setPrev(listNode);
            listNode.setNext(nil);
            listNode.setPrev(nil);
        } else {
            listNode.setNext(nil);
            listNode.setPrev(nil.getPrev());
            nil.getPrev().setNext(listNode);
            nil.setPrev(listNode);
        }
        size++;
    }

    /**
     * Adds an element at the specified position in the list.
     *
     * <p>If {@code index == 0}, the element is inserted at the head of the list.
     * If {@code index == size()}, the element is inserted at the end of the list.</p>
     *
     * @param index the insertion index; {@code 0 <= index <= size()}
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

        ListNode node = nil.getNext();
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        ListNode prev = node.getPrev();
        ListNode newNode = new ListNode(p);

        prev.setNext(newNode);
        node.setPrev(newNode);
        newNode.setNext(node);
        newNode.setPrev(prev);

        size++;
    }

    /**
     * Removes and returns the head element of the list.
     *
     * @return the first element, or {@code null} if the list is empty
     */
    public Physical pollFirst() {
        if (size == 0) {
            return null;
        }

        ListNode node = nil.getNext();

        if (size == 1) {
            nil.setNext(nil);
            nil.setPrev(nil);
        } else {
            nil.setNext(node.getNext());
            node.getNext().setPrev(nil);
        }

        size--;
        return node.getValue();
    }

    /**
     * Removes and returns the last element of the list.
     *
     * @return the last element, or {@code null} if the list is empty
     */
    public Physical pollLast() {
        ListNode toRemove = nil.getPrev();

        if (toRemove == nil) {
            return null;
        }

        if (size == 1) {
            nil.setNext(nil);
            nil.setPrev(nil);
        } else {
            toRemove.getPrev().setNext(nil);
            nil.setPrev(toRemove.getPrev());
        }

        size--;
        return toRemove.getValue();
    }

    /**
     * Returns the head element without removing it.
     *
     * @return the first element, or {@code null} if the list is empty
     */
    public Physical peekFirst() {
        return nil.getNext().getValue();
    }

    /**
     * Returns the last element without removing it.
     *
     * @return the last element, or {@code null} if the list is empty
     */
    public Physical peekLast() {
        return nil.getPrev().getValue();
    }

    /**
     * Returns whether this list contains the specified element (identical to `p`).
     *
     * @param p the element to search for
     * @return {@code true} if present, otherwise {@code false}
     */
    public boolean contains(Physical p) {
        for (int i = 0; i < size; i++) {
            if (get(i) == p) return true;
        }
        return false;
    }

    /**
     * Returns the element at the specified position.
     *
     * @param index the index; {@code 0 <= index < size()}
     * @return the element at the specified position
     */
    public Physical get(int index) {
        ListNode node = nil.getNext();
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node.getValue();
    }

    /**
     * Removes and returns the element at the specified position.
     *
     * @param index the index; {@code 0 <= index < size()}
     * @return the removed element
     */
    public Physical remove(int index) {
        ListNode toRemove = nil.getNext();

        for (int i = 0; i < index; i++) {
            toRemove = toRemove.getNext();
        }

        ListNode next = toRemove.getNext();
        ListNode prev = toRemove.getPrev();
        next.setPrev(prev);
        prev.setNext(next);

        if (index == 0) {
            nil.setNext(next);
        }

        if (index == size) {
            nil.setPrev(prev);
        }
        size--;
        return toRemove.getValue();
    }

    /**
     * Removes all elements from the list.
     */
    public void clear() {
        nil = new ListNode(null);
        nil.setNext(nil);
        nil.setPrev(nil);
        size = 0;
    }

    /**
     * Returns whether this list contains no elements.
     *
     * @return {@code true} if empty, otherwise {@code false}
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements currently stored in the list.
     *
     * @return the current size
     */
    public int size() {
        return size;
    }

    /**
     * Removes all elements from the beginning of this list up to index {@code i}
     * (inclusive) and returns them as a new list.
     *
     * <p>The first removed element is the element that was stored at index
     * {@code 0} before the operation, and the last removed element is the
     * element that was stored at index {@code i} before the operation.</p>
     *
     * <p>The relative order of the removed elements in the returned list is
     * the same as in this list before the removal.</p>
     *
     * <p>After the operation, this list contains only the elements with
     * indices greater than {@code i} in their original order.</p>
     *
     * @param i the last index to remove; {@code 0 <= i < size()}
     * @return a new list containing all removed elements in their original order
     */
    public PhysicalDoublyLinkedRingList removeUntil(int i) {
        PhysicalDoublyLinkedRingList newList = new PhysicalDoublyLinkedRingList();
        if (size == 0) {
            return newList;
        }

        for (int j = 0; j <= i; j++) {
            newList.add(j, remove(j));
        }

        return newList;
    }
}

class ListNode {

    private Physical value;
    private ListNode next;
    private ListNode prev;

    public ListNode(Physical value) {
        this.value = value;
    }

    public Physical getValue() {
        return value;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode getPrev() {
        return prev;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

}

