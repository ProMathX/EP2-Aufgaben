/**
 * A queue for 'Block' objects implemented as a singly linked list. The number of elements of the
 * queue is not limited. The queue may also contain entries of 'null'.
 */
//
// TODO: Complete the methods in 'BlockQueue'.
//       You can define further classes and methods for the implementation of
//       the singly linked list if needed.
//       Do NOT use the Java-Collection framework in 'Building' or any other class.
//
public class BlockQueue {
    private Block block;
    private BlockQueue next;
    //TODO: additional variables, constructors and methods must be private.


    /**
     * Initializes 'this' as an empty list.
     */
    public BlockQueue() {
        this.block = null;
        this.next = null;

    }

    private BlockQueue(Block block) {
        this.block = block;
        this.next = null;

    }

    public BlockQueue getNext() {
        return next;
    }

    public Block getBlock() {
        return block;
    }

    /**
     * Initializes this queue as an independent copy of 'queue'. Later changes of 'this'
     * will not affect 'queue' and vice versa.
     *
     * @param queue the queue from which the elements are copied to 'this', queue != null.
     */
    public BlockQueue(BlockQueue queue) {
        if (queue == null || queue.size() == 0) {
            this.block = null;
            this.next = null;
        }else {
            BlockQueue current = this;
            queue = queue.next;
            while (queue != null) {
                current.next = new BlockQueue(queue.block);
                queue = queue.next;
                current = current.next;

            }
        }
    }

    /**
     * Adds the specified element 'v' to this queue.
     *
     * @param v the variable that is added ('v' can also be 'null').
     */
    public void add(Block v) {
        BlockQueue current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new BlockQueue(v);

    }

    /**
     * Retrieves and removes an element from this queue. Returns 'null' if the list is empty.
     *
     * @return the next element in this queue, or 'null' if the queue is empty.
     */
    public Block poll() {
        if (this.next == null) {
            return null;
        }
        Block toReturn = this.next.block;
        this.next = this.next.next;
        return toReturn;

    }

    /**
     * Returns the number of entries in this queue (including 'null' entries).
     *
     * @return the number of entries in this queue (including 'null' entries).
     */
    public int size() {
        BlockQueue current = this.next;
        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }
        return size;

    }

    /**
     * Returns a string representation of this queue. The string representation consists
     * of the queue's elements in the order they have been added to the queue,
     * enclosed in square brackets ("[]"). Adjacent elements are separated by ','.
     * Example: "[[2x5],[4x2],[2x3]]"
     *
     * @return a string representation of this queue.
     */
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append("[");
        BlockQueue current = this.next;
        while (current != null) {
            toReturn.append(current.block.toString() + ",");
            current = current.next;
        }
        toReturn.deleteCharAt(toReturn.length() - 1);
        toReturn.append("]");
        return toReturn.toString();

    }
}

// TODO: define further classes, if needed (either here or in a separate file).
