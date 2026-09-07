
/**
 * A stack data structure for storing {@link CheckoutCounter} objects.
 * <p>
 * This class implements a dynamic array-based stack that follows the
 * Last-In-First-Out (LIFO) principle. Elements are added to and removed
 * from the top of the stack using the {@code push} and {@code pop} methods.
 * <p>
 * The stack automatically increases its internal storage capacity when it
 * becomes full. The order of elements is preserved, and the most recently
 * added element is always returned first.
 * <p>
 * This implementation does not allow direct access to elements other than
 * the top of the stack.
 */


public class CheckoutCounterStack {
    private CheckoutCounter[] stack;
    private int size;

    //TODO: define variables
    

    /**
     * Initializes this stack with an initial capacity of 8.
     *
     */
    public CheckoutCounterStack() {
        this.stack=new CheckoutCounter[8];
        this.size=0;

        //TODO: define constructor.
        
    }

    /**
     * Initializes this CheckoutCounterStack as an independent copy of an existing CheckoutCounterStack.
     *
     * This copy constructor initializes a new stack with the same elements, capacity,
     * and internal state as the source stack. The new stack is independent of the source
     * stack, meaning modifications to one will not affect the other.
     * The new stack stores references to the same {@link CheckoutCounter} objects as the source stack.
     *
     * @param source the existing CheckoutCounterStack to copy; must not be {@code null}
     */
    public CheckoutCounterStack(CheckoutCounterStack source) {
        if (source == null) return;

        this.stack = new CheckoutCounter[source.stack.length];
        this.size = source.size;

        for (int i = 0; i < source.size; i++) {
            this.stack[i] = source.stack[i];
        }

        //TODO: define constructor.
        
    }

    /**
     * Initializes this stack with an initial power of two capacity.
     *
     * @param initialCapacity the length of the internal array in the beginning;
     *                        initialCapacity is a power of two
     *                        (i.e., initialCapacity = 2ⁿ for some integer n > 0).
     */
    public CheckoutCounterStack(int initialCapacity) {
        this.stack=new CheckoutCounter[initialCapacity];
        this.size=0;
        //TODO: define constructor.
        
    }

    /**
     * Adds the specified CheckoutCounter {@code p} to this stack. If this push operation leads to a full occupation of
     * the internal array, this method calls {@link CheckoutCounterStack#doubleCapacity()}.
     *
     * @param p the element that is added to the stack.
     */
    public void push(CheckoutCounter p) {
        if(p==null){
            return;
        }
        if (size == stack.length) {
            this.doubleCapacity();
        }
        stack[size] = p;
        size++;
        //TODO: implement method.
        
    }

    /**
     * Doubles the size of the array used by this stack. This method is called if 'push' is called
     * and the push operation leads to a full occupation of the internal array.
     */
    private void doubleCapacity() {
        CheckoutCounter[] newStack = new CheckoutCounter[stack.length * 2];
        for (int i = 0; i < stack.length; i++) {
            newStack[i]=stack[i];
        }
        stack=newStack;
        //TODO: implement method.
        
    }


    /**
     * Retrieves but not removes the head of this stack,
     * or returns {@code null} if this stack is empty.
     *
     * @return the head of this stack (or {@code null} if this stack is empty).
     */
    public CheckoutCounter peek() {
        if(size==0){
            return null;
        }
        //TODO: implement method.
        return stack[size-1];
    }

    /**
     * Retrieves and removes the head of this stack,
     * or returns  {@code null} if this stack is empty.
     *
     * @return the head of this stack (or {@code null} if this stack is empty).
     */
    public CheckoutCounter pop() {
        if(size==0){
            return null;
        }
        CheckoutCounter toReturn = stack[--size];
        stack[size]=null;
        return toReturn;
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack.
     */
    public int size() {

        //TODO: implement method.
        return size;
    }

    /**
     * Checks if this stack is empty.
     *
     * @return the true if this stack is empty, false otherwise.
     */
    public boolean isEmpty() {

        //TODO: implement method.
        return size==0;
    }
}
