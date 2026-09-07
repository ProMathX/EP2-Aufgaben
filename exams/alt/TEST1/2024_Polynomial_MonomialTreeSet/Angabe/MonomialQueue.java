/**
 * A queue for 'Monomial' objects implemented as a singly linked list. The number of elements
 * of the queue is not limited. The queue may also contain entries of 'null'.
 * PLEASE, DO NOT CHANGE THIS FILE.
 */
public class MonomialQueue {

    private ListNode head;
    private ListNode tail;
    private int size;

    /**
     * Initializes 'this' as an empty list.
     */
    public MonomialQueue() {
    }

    /**
     * Initializes this queue as an independent copy of 'queue'. Later changes of 'this'
     * will not affect 'queue' and vice versa.
     *
     * @param queue the queue from which the elements are copied to 'this', queue != null.
     */
    public MonomialQueue(MonomialQueue queue) {

        ListNode current = queue.head;
        while (current != null) {
            this.add(current.getElem());
            current = current.getNext();
        }
    }

    /**
     * Adds the specified element 'm' to this queue.
     *
     * @param m the variable that is added ('m' can also be 'null').
     */
    public void add(Monomial m) {

        if (head == null) {
            head = tail = new ListNode(m, null);
        } else {
            tail.setNext(new ListNode(m, null));
            tail = tail.getNext();
        }
        size++;
    }

    /**
     * Retrieves and removes an element from this queue. Returns 'null' if the list is empty.
     *
     * @return the next element in this queue, or 'null' if the queue is empty.
     */
    public Monomial poll() {

        if (head == null) {
            return null;
        }
        Monomial toReturn = head.getElem();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return toReturn;
    }

    /**
     * Returns the number of entries in this queue (including 'null' entries).
     *
     * @return the number of entries in this queue (including 'null' entries).
     */
    public int size() {

        return size;
    }

    /**
     * Returns a string representation of this queue, with all elements ordered from
     * the element added first to the one added latest.
     *
     * @return a string representation of this queue.
     */
    public String toString() {

        String result = "";
        ListNode current = head;
        while (current != null) {
            result += current + (current.getNext() != null ? "," : "");
            current = current.getNext();
        }
        return result;
    }
}

/**
 * The list node class.
 */
class ListNode {
    private Monomial elem;
    private ListNode next;

    public ListNode(Monomial b, ListNode next) {
        this.elem = b;
        this.next = next;
    }

    @Override
    public String toString() {
        return elem.toString();
    }

    public Monomial getElem() {
        return elem;
    }

    public ListNode getNext() {
        return next;
    }

    void setNext(ListNode node) {
        next = node;
    }
}

