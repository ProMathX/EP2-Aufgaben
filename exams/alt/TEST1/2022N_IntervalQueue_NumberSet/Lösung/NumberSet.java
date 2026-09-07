
// A set of non-intersecting intervals of double numbers, sorted in ascending order (numerically,
// according to their values). The set uses a queue to process and store the intervals.
//
// TODO: Implementation of this class.
//
public class NumberSet {


    private IntervalQueue queue; // use a queue to process and store the intervals

    // Initializes 'this' with the unions of the specified intervals
    // as an ordered set of non-intersecting intervals.
    // This means that for any intersecting intervals in 'intervals'
    // their union is added instead of separate intervals.
    // Precondition: intervals != null && intervals.length > 0,
    // intervals[i] != null for any valid 'i'.
    public NumberSet(Interval... intervals) {
        queue=new IntervalQueue();
        for (Interval interval : intervals) {
            add(interval);
        }
    }


    // Inserts the specified interval to 'this' and makes sure that
    // no intersecting intervals exists after insertion. This means that
    // all intervals of 'this' intersecting with 'interval' are removed and
    // instead the union of 'interval' and all removed intervals is added.
    // Precondition: interval != null
    public void add(Interval interval) {
        if(this.queue.isEmpty()){
            queue.addLast(interval);
        }
        IntervalQueue newQueue=new IntervalQueue();
        boolean intervalAdded=false;
        while (!queue.isEmpty()){
            Interval current=queue.peekFirst();
            int cmp=current.compare(interval);
            if(cmp==-1){
                newQueue.addLast(queue.pollFirst());
            } else if (cmp==1) {
                if(!intervalAdded) {
                    newQueue.addLast(interval);
                    intervalAdded=true;
                }
                newQueue.addLast(queue.pollFirst());

            }else{
                interval=interval.hull(queue.pollFirst());
            }
        }
        if(!intervalAdded) {
            newQueue.addLast(interval);
        }
        queue=newQueue;
    }

    // Returns a readable representation with all intervals of this set separated by commas. The
    // intervals are ordered ascending (numerically, according to their values). The exact format
    // is shown by the following example with two intervals:
    // [-1.2, 8.7], [20.0, 30.0]
    // Returns "EMPTY" if the set is empty.
    public String toString() {
        return queue.toString();
    }
}
