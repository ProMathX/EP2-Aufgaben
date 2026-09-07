# EP2 Test 1

### General Notes

* The solution to your task must be implemented within the provided project and therefore in the existing files.
* You are *not* allowed to use the Java Collections Framework to solve this task.
* Do not modify the given method signatures or the signatures of the constructors.
* All object variables and any additional methods or constructors you create in the given classes must be `private`.
* Projects that do not compile will be graded with 0 points without exception.

## Domain Information

The task models a simplified checkout process in a supermarket. Customers (`Customer`) are represented as an abstract data type that stores the total value of the shopping cart (`cartValue`). At the checkout counters (`CheckoutCounter`), waiting customers are processed one after another. For this purpose, each checkout counter maintains a queue (First-In-First-Out, `CustomerQueue`) of customers. When customers are served at the checkout, they are removed from the queue in order and their cart value is returned.

All checkout counters in the supermarket are represented by a stack (Last-In-First-Out, `CheckoutCounterStack`) within the `Supermarket` class. The supermarket can operate multiple checkout counters in parallel, process their customers, and track the total revenue. If needed, a new checkout counter can be opened by splitting the queue of the topmost counter — the first `n` customers remain at the original counter, while the remaining customers are moved to the newly opened topmost counter. Empty checkout counters can be closed again.

## Task Description

The files to be modified for this test are:

* [CustomerQueue.java](../src/CustomerQueue.java)
* [CheckoutCounter.java](../src/CheckoutCounter.java)
* [CheckoutCounterStack.java](../src/CheckoutCounterStack.java)
* [Supermarket.java](../src/Supermarket.java)

Complete these classes at the locations marked with TODO.
The class [Customer.java](../src/Customer.java) is already fully provided and must not be modified.

The class [ApplicationTest1.java](../src/ApplicationTest1.java) can be used to test your implementation.

### Points Distribution

* `CustomerQueue`: 2 points
* `CheckoutCounterStack`: 3 points
* `CheckoutCounter`: 3 points
* `Supermarket`: 8 points

**Total: 16 points**
