/**
 * Simple FIFO queue for ants.
 *
 * <p>This queue stores {@link Ant} objects and follows the
 * <em>First-In-First-Out (FIFO)</em> principle: the first element
 * inserted into the queue is the first one removed.</p>
 *
 * <p>The queue is implemented using a circular buffer, based on an array that grows
 * automatically when its capacity is exceeded.</p>
 */
public class AntQueue {

    private Ant[] buffer;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    /**
     * Creates an empty queue with a specified initial capacity.
     * @param initialCapacity the initial capacity of the queue; {@code initialCapacity > 0}
     */
    public AntQueue(int initialCapacity) {
        buffer = new Ant[initialCapacity];
    }

    /**
     * Creates a new queue that is a copy of the specified queue.
     *
     * The new queue contains the same elements as {@code queue}.
     *
     * @param queue the queue to copy; {@code queue != null}
     */
    public AntQueue(AntQueue queue) {
        buffer = queue.buffer.clone();
        head = queue.head;
        tail = queue.tail;
        size = queue.size;
    }

    /**
     * Adds an ant to the end of the queue.
     *
     * <p>If the internal array is full, its capacity is doubled
     * before inserting the new element.</p>
     *
     * @param a the {@link Ant} to add to the queue; {@code a != null}
     */
    public void add(Ant a) {
        if (size == buffer.length) {
            Ant[] newBuffer = new Ant[buffer.length * 2];
            System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
            buffer = newBuffer;
        }

        buffer[head] = a;
        head = (head + 1) % buffer.length;
        size++;
    }

    /**
     * Removes and returns the first element of the queue.
     *
     * <p>This method removes the element at the head of the queue
     * and advances the head position.</p>
     *
     * @return the first {@link Ant} in the queue or {@code null} if {@code size() == 0}.
     */
    public Ant poll() {
        Ant ant = buffer[tail];
        buffer[tail] = null;
        tail = (tail + 1) % buffer.length;
        size--;
        return ant;
    }

    /**
     * Returns the first element of the queue without removing it.
     *
     * <p>The queue remains unchanged after this operation.</p>
     *
     * @return the first {@link Ant} in the queue or {@code null} if {@code size() == 0}.
     */
    public Ant peek() {
        return buffer[tail];
    }

    /**
     * Returns the number of elements currently stored within the queue.
     *
     * @return the current queue size.
     */
    public int size() {
        return size;
    }
}