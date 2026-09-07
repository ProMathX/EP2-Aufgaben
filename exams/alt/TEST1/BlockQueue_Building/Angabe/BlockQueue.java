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
    //TODO: additional variables, constructors and methods must be private.


    /**
     * Initializes 'this' as an empty list.
     */
    public BlockQueue() {

    }

    private BlockQueue(Block block) {

    }

    public BlockQueue getNext() {
        return null;
    }

    public Block getBlock() {
        return null;
    }

    /**
     * Initializes this queue as an independent copy of 'queue'. Later changes of 'this'
     * will not affect 'queue' and vice versa.
     *
     * @param queue the queue from which the elements are copied to 'this', queue != null.
     */
    public BlockQueue(BlockQueue queue) {
        //TODO: implement method.
    }

    /**
     * Adds the specified element 'v' to this queue.
     *
     * @param v the variable that is added ('v' can also be 'null').
     */
    public void add(Block v) {
        //TODO: implement method.
    }

    /**
     * Retrieves and removes an element from this queue. Returns 'null' if the list is empty.
     *
     * @return the next element in this queue, or 'null' if the queue is empty.
     */
    public Block poll() {
        //TODO: implement method.
        return null;

    }

    /**
     * Returns the number of entries in this queue (including 'null' entries).
     *
     * @return the number of entries in this queue (including 'null' entries).
     */
    public int size() {
        //TODO: implement method.
        return 0;

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
        //TODO: implement method.
        return null;
    }
}

// TODO: define further classes, if needed (either here or in a separate file).
