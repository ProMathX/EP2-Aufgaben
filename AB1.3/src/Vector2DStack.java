/**
 * Stack storing {@link Vector2D} objects.
 *
 * <p>This stack stores {@link Vector2D} objects. It follows the
 * <em>Last-In-First-Out (LIFO)</em> principle: the most recently pushed
 * element is the first one removed.</p>
 *
 * <p>The stack is implemented using a dynamically growing array.</p>
 */
public class Vector2DStack {

    private Vector2D[] array;
    private int currentIndex = -1;

    /**
     * Creates an empty stack with an initial capacity of 32 elements.
     */
    public Vector2DStack() {
        array = new Vector2D[32];
    }

    /**
     * Pushes a new vector on top of the stack.
     *
     * <p>If the internal array is full, its capacity is doubled before
     * inserting the new element.</p>
     *
     * @param v the {@link Vector2D} value to push onto the stack
     */
    public void push(Vector2D v) {
        if (++currentIndex == array.length) {
            Vector2D[] newArray = new Vector2D[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[currentIndex] = v;
    }

    /**
     * Removes and returns the topmost element. Returns {@code null} if the stack is empty.
     *
     * @return the top {@link Vector2D} element, or {@code null} if the stack is empty.
     */
    public Vector2D pop() {
        if (isEmpty()) {
            return null;
        }
        Vector2D vector2D = array[currentIndex];
        array[currentIndex--] = null;
        return vector2D;
    }

    /**
     * Returns the element currently at the top of the stack
     * without removing it. Returns {@code null} if the stack is empty.
     *
     * @return the top {@link Vector2D} element, or {@code null} if the stack is empty.
     */
    public Vector2D peek() {
        if (isEmpty()) {
            return null;
        }

        return array[currentIndex];
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return {@code true} if the stack contains no elements,
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return currentIndex < 0;
    }

    /**
     * Removes all elements from the stack. After this operation the stack is empty.
     */
    public void clear() {
        for (int i = currentIndex; i >= 0; i--) {
            array[i] = null;
        }
        currentIndex = -1;
    }

    /**
     * Returns the number of elements currently stored in the stack.
     *
     * @return the current stack size
     */
    public int size() {
        return currentIndex + 1;
    }
}