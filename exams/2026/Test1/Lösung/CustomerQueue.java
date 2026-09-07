/**
 * A queue implementation for managing a collection of Customer objects.
 * This queue uses a circular, array-based buffer to efficiently add and remove elements,
 * automatically expanding when capacity is reached.
 * <p>
 * The class calls the private method {@link #doubleCapacity() doubleCapacity()}, if an external call of
 * {@link #add(Customer) add()} leads to a full occupation of the internal array.
 */

public class CustomerQueue {
    private Customer[] customer;
    private int size;
    private int head;
    private int tail;

    //TODO: define variables
    

    /**
     * Initializes this queue with an initial capacity of 8.
     */
    public CustomerQueue() {
        this.customer=new Customer[8];
        this.size=0;
        this.head=0;
        this.tail=0;


        //TODO: define constructor.
        
    }

    /**
     * Initializes this queue with an initial power of two capacity.
     *
     * @param initialCapacity the length of the internal array in the beginning;
     *                        Precondition (no check necessary): initialCapacity is a power of two
     *                        (i.e., initialCapacity = 2ⁿ for some integer n > 0).
     */
    public CustomerQueue(int initialCapacity) {
        if(initialCapacity<1){
            initialCapacity=1;
        }
        this.customer=new Customer[initialCapacity];
        this.size=0;
        this.head=0;
        this.tail=0;

        //TODO: define constructor.
        
    }


    /**
     * Adds the specified Customer {@code c} to this queue. Doubles the capacity of this
     * queue if the addition leads to a full occupation of the internal array.
     *
     * @param c the element that is added to the queue; must not be {@code null}
     */
    public void add(Customer c) {
        if (size == customer.length) {
            this.doubleCapacity();
        }
        customer[tail] = c;
        tail = (tail + 1) % customer.length;
        size++;


        //TODO: implement method.
        
    }

    /**
     * Doubles the size of the array used by this queue. This method is called if {@code add} is called
     * and the addition leads to a full occupation of the internal array.
     */
    private void doubleCapacity() {
        int oldLength = customer.length;
        int newLength = oldLength == 0 ? 8 : oldLength * 2;
        Customer[] customersNew = new Customer[newLength];

        for (int i = 0; i < size; i++) {
            customersNew[i] = customer[(head + i) % oldLength];
        }
        customer = customersNew;
        head = 0;
        tail = size;

        //TODO: implement method
        
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue (or {@code null} if this queue is empty).
     */
    public Customer poll() {
        if (size == 0) {
            return null;
        }
        Customer toReturn = customer[head];
        customer[head] = null;
        head = (head + 1) % customer.length;
        size--;
        return toReturn;

        //TODO: implement method.
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue.
     */
    public int size() {

        //TODO: implement method.
        return size;
    }

}
