// A single continuous closed interval of double values.
// Please, do not change this class definition!
//
public class Interval {

    private double lower;
    private double upper;

    // Initializes 'this' with the lower and upper bound of the
    // closed interval ('lower' and 'upper' and all values in
    // between are elements of the interval).
    // Precondition: lower <= upper.
    public Interval(double lower, double upper) {

        this.lower = lower;
        this.upper = upper;
    }

    // Checks if 'this' and 'interval' intersect.
    // Returns -1 if all elements of 'this' are less than the smallest element of 'interval' and
    // returns 1 if all elements of 'this' are greater than the largest element of 'interval'.
    // Otherwise (i.e. they intersect) the method returns 0.
    // Precondition: interval != null
    public int compare(Interval interval) {
        if (this.upper < interval.lower) {
            return -1;
        }

        if (this.lower > interval.upper) {
            return 1;
        }

        return 0;
    }

    // The hull is the enclosing interval with the minimum of the lower bounds of 'this'
    // and 'interval' as lower bound and the maximum of the upper bounds of 'this' and 'interval'
    // as upper bound.
    // Note that the hull corresponds to the union of the two intervals if they intersect.
    public Interval hull(Interval interval) {

        return new Interval(Math.min(this.lower, interval.lower),
                Math.max(this.upper, interval.upper));

    }

    @Override
    // Returns a readable representation of 'this' including the lower and upper
    // bound of this interval. The format is shown by the following example:
    // [0.9, 4.0]
    // (See further examples in 'PraxisTest1.java'.)
    public String toString() {

        return "[" + lower + ", " + upper + "]";
    }
}
