// A linked list with elements of type 'Interval' supporting queue access methods.
// (The class represents a queue designed for holding intervals prior to processing.)
//
// The intervals of the queue can be accessed in a FIFO (first-in-first-out) manner,
// i.e., the interval that was first inserted by 'addLast' is retrieved first by 'pollFirst'.
// The number of elements of the queue is not limited.
//
public class IntervalQueue {
    private Interval interval=null;
    private IntervalQueue next=null;

    public IntervalQueue(){

    }
    private IntervalQueue(Interval interval){
        this.interval=interval;
    }


    // Inserts the specified element into this queue (adds the specified element at the end of
    // the queue).
    // Precondition: interval != null
    public void addLast(Interval interval) {
        IntervalQueue current=this;
        while (current.next!=null){
            current=current.next;
        }
        current.next=new IntervalQueue(interval);
    }

    // Retrieves and removes the head of this queue, or returns 'null' if this queue is empty.
    public Interval pollFirst() {
        if(this.next==null){
            return null;
        }
        Interval toReturn=this.next.interval;
        this.next=this.next.next;
        return toReturn;
    }

    // Retrieves, but does not remove, the head of this queue, or returns 'null' if this queue is
    // empty.
    public Interval peekFirst() {

        return this.next!=null ? this.next.interval : null;
    }

    // Returns 'true' if and only if this queue contains no elements.
    public boolean isEmpty() {

        return this.next==null;
    }

    // Returns the number of elements in this queue.
    public int size() {
        if(this.next==null){
            return 0;
        }else {
            IntervalQueue current=this.next;
            int c=0;
            while (current!=null){
                current=current.next;
                c++;
            }
            return c;
        }
    }

    @Override
    // Returns a readable representation with all elements of this queue in brackets, separated by
    // commas. The exact format is shown by the following example with three intervals:
    // [-1.2, 5.0], [7.33, 12.5], [3.3, 8.7]
    // Returns "EMPTY" if the queue is empty.
    public String toString() {
        if(this.next==null){
            return "EMPTY";
        }
        StringBuilder toReturn=new StringBuilder();
        IntervalQueue current=this.next;
        while (current!=null){
            toReturn.append(current.interval.toString());
            current=current.next;
        }
        return toReturn.toString();

    }
}
