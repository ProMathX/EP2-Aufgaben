/**
 * A checkout counter (dt. "Kassa") that manages a queue of customers ({@code CustomerQueue}) waiting to be served.
 * This class is able to process a specific amount of customers in the line and to calculate
 * the total revenue (dt. "Gesamtumsatz").
 */
public class CheckoutCounter {

    /**
     * The queue of customers waiting in line at this checkout counter.
     * Customers are served in first-in-first-out order.
     */
    private CustomerQueue waitingLine;


    /**
     * Constructs a new CheckoutCounter with the specified {@link CustomerQueue} as waiting
     * line.
     *
     * @param waitingLine the {@link CustomerQueue} this CheckoutCounter is initialized with;
     *                    must not be {@code null}
     */
    public CheckoutCounter(CustomerQueue waitingLine) {

        //TODO: define constructor
        
    }

    /**
     * Processes the next {@code n} customers in the waiting line by removing them from the waiting line
     * and checking out their cart value {@link Customer#getCartValue()}. The method returns the total cart value of
     * all checked out customers. If the waiting line is empty, this method returns 0.
     * If {@code n} is larger than the number of customers in the waiting line, all customers are processed.
     *
     * @param n the number of customers to be removed from the waiting line if this counter {@code n >= 0}.
     * @return the total shopping cart value of all checked out customers, or 0 if the waiting line is empty.
     */
    public int processCustomers(int n) {
        //TODO: implement method
        return 0;
    }


    /**
     * Returns the waiting line of this checkout counter.
     *
     * @return the waiting line of this checkout counter.
     */
    public CustomerQueue getWaitingline() {

        //DO NOT CHANGE THIS METHOD!
        return waitingLine;
    }
}