// A linked list with elements of type 'Interval' supporting queue access methods.
// (The class represents a queue designed for holding intervals prior to processing.)
//
// The intervals of the queue can be accessed in a FIFO (first-in-first-out) manner,
// i.e., the interval that was first inserted by 'addLast' is retrieved first by 'pollFirst'.
// The number of elements of the queue is not limited.
//
public class IntervalQueue {

    private IntervalQueue(Interval interval){
        // TODO: Implementation.

    }


    // Inserts the specified element into this queue (adds the specified element at the end of
    // the queue).
    // Precondition: interval != null
    public void addLast(Interval interval) {
        // TODO: Implement method.

    }

    // Retrieves and removes the head of this queue, or returns 'null' if this queue is empty.
    public Interval pollFirst() {
        // TODO: Implement method.
        return null;
    }

    // Retrieves, but does not remove, the head of this queue, or returns 'null' if this queue is
    // empty.
    public Interval peekFirst() {
        // TODO: Implement method.

        return null;
    }

    // Returns 'true' if and only if this queue contains no elements.
    public boolean isEmpty() {
        // TODO: Implement method.

        return false;
    }

    // Returns the number of elements in this queue.
    public int size() {
        // TODO: Implement method.

        return 0;
    }

    @Override
    // Returns a readable representation with all elements of this queue in brackets, separated by
    // commas. The exact format is shown by the following example with three intervals:
    // [-1.2, 5.0], [7.33, 12.5], [3.3, 8.7]
    // Returns "EMPTY" if the queue is empty.
    public String toString() {
        // TODO: Implement method.

        return null;

    }
}
