/**
 * A queue for {@link IntVar} objects implemented as a singly linked list.
 * There is nothing special in this queue implementation: besides the copy constructor, the class
 * has the standard queue methods {@code add, poll, size, toString}.
 * The number of elements of the queue is not limited. The queue may also contain entries of
 * {@code null}.
 *
 * PLEASE DO NOT CHANGE THIS FILE.
 */
public class IntVarQueue {

    private ListNode head;
    private ListNode tail;
    private int size;

    /**
     * Initializes {@code this} as an empty list.
     */
    public IntVarQueue() {}

    /**
     * Initializes this queue as an independent copy of {@code queue}. Later changes of {@code this}
     * will not affect {@code queue} and vice versa.
     *
     * @param queue the queue from which the elements are copied to {@code this}, queue != null.
     */
    public IntVarQueue(IntVarQueue queue) {

        ListNode current = queue.head;
        while(current != null) {
            this.add(current.getElem());
            current = current.getNext();
        }
    }

    /**
     * Adds the specified element {@code v} to this queue.
     * @param v the variable that is added ({@code v} can also be {@code null}).
     */
    public void add(IntVar v) {

        if (head == null) {
            head = tail = new ListNode(v, null);
        } else {
            tail.setNext(new ListNode(v, null));
            tail = tail.getNext();
        }
        size++;
    }

    /**
     * Retrieves and removes an element from this queue. Returns {@code null} if the list is empty.
     * @return the next element in this queue, or {@code null} if the queue is empty.
     */
    public IntVar poll() {

        if (head == null) {
            return null;
        }
        IntVar toReturn = head.getElem();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return toReturn;
    }

    /**
     * Returns the number of entries in this queue (including {@code null} entries).
     * @return the number of entries in this queue (including {@code null} entries).
     */
    public int size() {

        return size;
    }

    /**
     * Returns a string representation of this queue, with all elements ordered from
     * the element added first to the one added latest.
     * @return a string representation of this queue.
     */
    public String toString() {

        String result = "[";
        ListNode current = head;
        while (current != null) {
            result += current + (current.getNext() != null ? "," : "");
            current = current.getNext();
        }
        return result + "]";
    }
}

 /**
  * The list node class.
  */
 class ListNode {
    private IntVar elem;
    private ListNode next;

    public ListNode(IntVar v, ListNode next) {
        this.elem = v;
        this.next = next;
    }

    @Override
    public String toString() {
        return elem == null ? "null" : elem.toString();
    }

    public IntVar getElem() {
        return elem;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode node) {
        next = node;
    }
}

