/**
 * Represents a supermarket management system that handles multiple checkout counters (dt. "Kassen"),
 * tracks revenue (dt. "erfasst den Umfang"), and manages customer waiting lines using a stack-based approach.
 * <p>
 * Newly opened checkout counters are put on top the stack, and checkout counters are only closed if they are empty
 * and on top of the stack.  Customers are processed across multiple checkout counters and the revenue is tracked.
 * </p>
 *
 */
public class Supermarket {
    /**
     * A stack implementation that manages all active checkout counters in the supermarket.
     * The top of the stack represents the most recently opened checkout counter.
     */
    private CheckoutCounterStack counters;

    /**
     * The total revenue (dt. "Gesamtumsatz") collected from processing customers across all checkout counters.
     * This value accumulates as customers are processed through the {@link #processCustomers(int)} method.
     */
    private int revenue;

    /**
     * Initializes this Supermarket with the provided waiting lines.
     *
     * Each waiting line in the array 'waitingLines' is converted into a new separate checkout counter and pushed onto
     * the counter stack. The order of waiting lines determines their initial position in the stack,
     * with the last waiting line becoming the top counter.
     *
     * @param waitingLines an array of 'CustomerQueue' objects representing initial waiting lines;
     *                     Each queue will be assigned to a new 'CheckoutCounter' object and pushed onto the
     *                     'CheckoutCounterStack'.
     *                     Precondition: {@code waitingLines != null} and {@code waitingLine[i] != null} for all valid
     *                     {@code i}
     */
    public Supermarket(CustomerQueue[] waitingLines) {

        //DO NOT CHANGE THIS CONSTRUCTOR!
        counters = new CheckoutCounterStack();
        for (int i = 0; i < waitingLines.length; i++) {
            counters.push(new CheckoutCounter(waitingLines[i]));
        }
    }


    /**
     * Closes and removes all consecutive empty checkout counters from the top of the stack.
     *
     * This method checks from the top of the counter stack downward and removes counters
     * that have no customers in their waiting line. It stops when it encounters a counter
     * with at least one customer.
     *
     * @return the number of checkout counters that were closed
     */
    public int closeEmptyCounters() {
        //TODO: implement method.
        return 0;
    }

    /**
     * Opens a new checkout counter by splitting the waiting line of the current top counter.
     * <p>
     * The {@code n} first customers of the current top counter remain in this counter, while the other customers move to
     * the newly opened counter that becomes the new top of the stack. The order of customers is not changed.
     * If {@code n} is larger than the number of customers in the top counter, the method does nothing.
     * Example:
     *
     * The current top counter contains the customers in the order {c1, c2, c3, c4, c5}
     * With n = 2, the current top counter holds the customers {c1, c2}, while the newly opened top counter contains the
     * queue {c3, c4, c5}
     *
     * @param n the number of customers that remain in the current top counter ({@code n > 0}); if the top counter's
     *          waiting line has {@code n} or fewer customers, this method does nothing
     */
    public void openNewCounter(int n) {
        return;
        //TODO: implement method.
        
    }


    /**
     * Processes the specified number of customers from each checkout counter and accumulates the total revenue.
     *
     * This method iterates through all checkout counters (without modifying the original stack),
     * processing up to {@code n} customers from each counter. The revenue from all processed
     * customers is summed and added to the total revenue.
     *
     * @param n the number of customers to process from each counter ({@code n >= 0}).
     */
    public void processCustomers(int n){

        //DO NOT CHANGE THIS METHOD!
        CheckoutCounterStack countersTemp = new CheckoutCounterStack(counters);
        while (!countersTemp.isEmpty()) {
            revenue += countersTemp.pop().processCustomers(n);
        }
    }

    /**
     * Returns a string representation of all checkout counters in order from bottom to top.
     *
     * The returned string shows each counter's position in the stack (bottom = 1.) and the number of customers
     * currently waiting in line. If no counters are open, the method returns "No open counters".
     *
     * Example: "1. Counter with 7 customer(s), 2. Counter with 4 customer(s), 3. Counter with 3 customer(s)
     *
     * @return a formatted string listing all counters with their customer counts,
     *         or "No open counters" if the stack is empty
     */
    public String countersToString() {

        //DO NOT CHANGE THIS METHOD!
        if (counters.isEmpty()) return "No open counters";
        CheckoutCounterStack countersTemp = new CheckoutCounterStack(counters);
        CheckoutCounterStack reversedStack = new CheckoutCounterStack();
        while (!countersTemp.isEmpty()) {
            reversedStack.push(countersTemp.pop());
        }
        String s = "";
        int i = 1;
        while (!reversedStack.isEmpty()) {
            s += i++ + ". Counter with " + reversedStack.pop().getWaitingline().size() + " customer(s), ";
        }
        return s.substring(0, s.length() - 2);
    }


    /**
     * Returns the total revenue collected from all customer processing operations.
     *
     * @return the total revenue accumulated across all checkout counters
     */
    public int getRevenue() {

        //DO NOT CHANGE THIS METHOD!
        return revenue;
    }
}