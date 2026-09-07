import java.util.*;

/**
 * A set of consecutive IntConst numbers from 'smallest' to 'largest' (inclusive).
 */
//
// TODO: Implementation of this class.
//
public class IntConstRangeSet implements IntConstSet, IntConstRange //TODO: activate clause.
{

    // TODO: Define missing parts of the class.
    //  Further methods can be added if necessary
    private IntConst smallest;
    private IntConst largest;

    /**
     * Initializes 'this' with the smallest and largest element of this range (inclusive).
     * Throws an IllegalLimitException with the detail message "illegal range limits"
     * if largest.lessThan(smallest) == true. If largest.equals(smallest) == true, this set
     * has only a single element.
     *
     * @param smallest the smallest number in this set.
     * @param largest  the largest number in this set.
     * @throws IllegalLimitException with the detail message "illegal range limits"
     *                               if largest.lessThan(smallest) == true.
     */
    public IntConstRangeSet(IntConst smallest, IntConst largest) {
        if (largest.lessThan(smallest)) {
            throw new IllegalLimitException("illegal range limits");

        }
        this.smallest = smallest;
        this.largest = largest;
    }


    @Override
    public boolean contains(IntConst element) {
        if (element == null) {
            throw new IllegalLimitException("element is null");
        }
        return !largest.lessThan(element) && !element.lessThan(smallest);
    }

    /**
     * Returns the union of this set and the specified set (see specification in 'IntConstSet').
     * The method returns a new object of the most specific subtype of 'IntConstSet':
     * The returned object is of 'IntConstRangeSet' if the returned set can be represented by a
     * single range. Otherwise, the returned set is of 'CompactIntConstSet'.
     *
     * @param other the other set, other != null.
     * @return a new set representing the union of 'this' with 'other'.
     */
    //@Override
    public IntConstSet union(IntConstSet other) {
        if (other == null) {
            throw new IllegalLimitException("element is null");
        }
        if(this.equals(other)){
            return this;
        }
        if (other instanceof IntConstRangeSet otherRange) {
            if(this.compare(otherRange)==0){

                IntConst newSmall = otherRange.smallest.lessThan(this.smallest) ? otherRange.smallest : this.smallest;
                IntConst newLarge = otherRange.largest.lessThan(this.largest) ? this.largest : otherRange.largest;

                return new IntConstRangeSet(newSmall, newLarge);
            }
        }
        CompactIntConstSet result = new CompactIntConstSet();
        for (var element : this) {
            result.add(element);
        }
        for (var element : other) {
            result.add(element);
        }
        return result;

        // Eredeti
//        if (other == null) {
//            throw new IllegalLimitException("element is null");
//        }
//        if(this.equals(other)){
//            return this;
//        }
//        if (other instanceof IntConstRangeSet otherRange) {
//            if(this.compare(otherRange)==0){
//
//                IntConst newSmall = otherRange.smallest.lessThan(this.smallest) ? otherRange.smallest : this.smallest;
//                IntConst newLarge = otherRange.largest.lessThan(this.largest) ? this.largest : otherRange.largest;
//
//                return new IntConstRangeSet(newSmall, newLarge);
//            } else {
//                return new CompactIntConstSet().union(this).union(otherRange);
//            }
//        }
//        if(other instanceof CompactIntConstSet otherCompact) {
//            return otherCompact.union(this);
//        }
//        throw new IllegalArgumentException("invalid type");
    }


    /**
     * Returns a readable representation of 'this' in the form smallest-largest,
     * for example "3-12". If smallest.equals(largest) the string consists of just the single
     * number (for example "12").
     *
     * @return a readable representation of 'this'.
     */
    @Override
    public String toString() {
        if (smallest.equals(largest)) {
            return smallest.toString();
        } else {
            return smallest.toString() + "-" + largest.toString();
        }
    }

    public void add(IntConst c) {
        if (c == null) {
            throw new IllegalLimitException("element is null");
        }
        if (c.lessThan(smallest)) {
            smallest = c;
        } else if (largest.lessThan(c)) {
            largest = c;
        }
    }


    @Override
    public IntConstRange getRangeView() {
        return this;

    }

    @Override
    public boolean equals(Object o){
        if(o instanceof IntConstRangeSet other){
            return this.smallest.equals(other.smallest) && this.largest.equals(other.largest);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return smallest.hashCode() + largest.hashCode();
    }

    @Override
    public IntConstIterator iterator() {
        return new IntConstIterator() {

            private IntConst current = smallest;

            @Override
            public boolean hasNext() {
                return !largest.lessThan(current);
            }

            @Override
            public IntConst next() {
                IntConst result = current;
                current = current.plus(new IntConst(1));
                return result;
            }
        };
    }

    @Override
    public IntConst getSmallest() {
        return this.smallest;
    }

    @Override
    public IntConst getLargest() {
        return this.largest;
    }
}


