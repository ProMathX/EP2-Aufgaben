public class ApplicationTest1 {
    private static void check(String testName, Object expected, Object actual) {
        if (java.util.Objects.equals(expected, actual)) {
            ok();
        } else {
            fail(testName, expected, actual);
        }
    }

    private static void fail(String testName, Object expected, Object actual) {
        System.out.println(testName + " FAILED -> Expected: " + expected + ", Actual: " + actual);
    }

    private static void ok() {
        System.out.println("OK");
    }

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("CustomerQueue TESTS");
        System.out.println("===============================================");

        CustomerQueue queue1 = new CustomerQueue();
        Customer c1 = new Customer(5);
        Customer c2 = new Customer(3);

        queue1.add(c1);
        check("CustomerQueue add", 1, queue1.size());

        queue1.add(c2);
        check("CustomerQueue add second", 2, queue1.size());

        Customer polled = queue1.poll();
        check("CustomerQueue poll", true, polled != null);
        check("CustomerQueue poll value", 5, polled.getCartValue());
        check("CustomerQueue size after poll", 1, queue1.size());

        Customer c3 = new Customer(5);
        Customer c4 = new Customer(3);
        Customer c5 = new Customer(2);
        queue1.add(c3);
        queue1.add(c4);
        queue1.add(c5);
        check("CustomerQueue size after adds", 4, queue1.size());

        Customer first = queue1.poll();
        check("CustomerQueue FIFO order", 3, first.getCartValue());

        CustomerQueue expandQueue = new CustomerQueue(2);
        expandQueue.add(new Customer(1));
        expandQueue.add(new Customer(2));
        expandQueue.add(new Customer(3));
        check("CustomerQueue capacity expansion", 3, expandQueue.size());

        System.out.println("\n===============================================");
        System.out.println("CheckoutCounter TESTS");
        System.out.println("===============================================");

        CustomerQueue line2 = new CustomerQueue();
        Customer customerA = new Customer(5);
        line2.add(customerA);
        CheckoutCounter counter2 = new CheckoutCounter(line2);
        int revenue2 = counter2.processCustomers(1);
        check("CheckoutCounter uses provided queue reference", 0, line2.size());
        check("CheckoutCounter revenue after processing", 5, revenue2);

        CustomerQueue line3 = new CustomerQueue();
        Customer c6 = new Customer(4);   // total 4
        Customer c7 = new Customer(3);    // total 3
        line3.add(c6);
        line3.add(c7);
        CheckoutCounter counter3 = new CheckoutCounter(line3);
        int revenue3 = counter3.processCustomers(2);
        check("CheckoutCounter multiple customers revenue", 7, revenue3);
        check("CheckoutCounter multiple customers queue empty", 0, line3.size());

        CustomerQueue emptyLine = new CustomerQueue();
        CheckoutCounter counter4 = new CheckoutCounter(emptyLine);
        int revenue4 = counter4.processCustomers(1);
        check("CheckoutCounter process empty queue", 0, revenue4);

        System.out.println("\n===============================================");
        System.out.println("CheckoutCounterStack TESTS");
        System.out.println("===============================================");

        CheckoutCounterStack stack1 = new CheckoutCounterStack();
        CheckoutCounter counter1_new = new CheckoutCounter(new CustomerQueue());
        CheckoutCounter counter2_new = new CheckoutCounter(new CustomerQueue());
        stack1.push(counter1_new);
        check("CheckoutCounterStack push", 1, stack1.size());
        stack1.push(counter2_new);
        check("CheckoutCounterStack multiple pushes", 2, stack1.size());

        CheckoutCounter popped = stack1.pop();
        check("CheckoutCounterStack pop", true, popped != null);
        check("CheckoutCounterStack pop size", 1, stack1.size());

        CheckoutCounter stackPeek = stack1.peek();
        check("CheckoutCounterStack peek", true, stackPeek != null);
        check("CheckoutCounterStack peek size", 1, stack1.size());

        check("CheckoutCounterStack pop after peek", counter1_new, stack1.pop());

        CheckoutCounterStack expandStack = new CheckoutCounterStack(2);
        expandStack.push(new CheckoutCounter(new CustomerQueue()));
        expandStack.push(new CheckoutCounter(new CustomerQueue()));
        expandStack.push(new CheckoutCounter(new CustomerQueue()));
        check("CheckoutCounterStack capacity expansion", 3, expandStack.size());

        CheckoutCounterStack original = new CheckoutCounterStack();
        original.push(new CheckoutCounter(new CustomerQueue()));
        CheckoutCounterStack copy = new CheckoutCounterStack(original);
        check("CheckoutCounterStack copy constructor", 1, copy.size());

        System.out.println("\n===============================================");
        System.out.println("Supermarket TESTS");
        System.out.println("===============================================");

        CustomerQueue[] waitingLines = {new CustomerQueue(), new CustomerQueue(), new CustomerQueue()};
        waitingLines[0].add(new Customer(5));
        waitingLines[0].add(new Customer(3));
        waitingLines[1].add(new Customer(2));

        Supermarket supermarket = new Supermarket(waitingLines);
        String countersStr = supermarket.countersToString();
        check("Supermarket constructor", countersStr, "1. Counter with 2 customer(s), 2. Counter with 1 customer(s), 3. Counter with 0 customer(s)");

        supermarket.processCustomers(1);
        check("Supermarket revenue after processing", 7, supermarket.getRevenue());

        int closedCount = supermarket.closeEmptyCounters();
        check("Supermarket closeEmptyCounters", 2, closedCount);

        CustomerQueue[] waitingLines2 = {new CustomerQueue(), new CustomerQueue()};
        waitingLines2[0].add(new Customer(5));
        waitingLines2[0].add(new Customer(3));
        waitingLines2[1].add(new Customer(2));
        waitingLines2[1].add(new Customer(3));
        waitingLines2[1].add(new Customer(4));
        supermarket = new Supermarket(waitingLines2);
        supermarket.openNewCounter(1);
        check("Supermarket openNewCounter", "1. Counter with 2 customer(s), 2. Counter with 1 customer(s), 3. Counter with 2 customer(s)", supermarket.countersToString());

        System.out.println("\n===============================================");
        System.out.println("ALL TESTS COMPLETED");
        System.out.println("===============================================");
    }
}
