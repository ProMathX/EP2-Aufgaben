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

    }


    @Override
    public boolean contains(IntConst element) {
        return false;
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
        return null;
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
        // range nur smallest to largest
        return "";
    }

    public void add(IntConst c) {
    }

    @Override
    public IntConstRange getRangeView() {
        return null;

    }

    @Override
    public IntConstIterator iterator() {
        return null;
    }

    @Override
    public IntConst getSmallest() {
        return null;
    }

    @Override
    public IntConst getLargest() {
        return null;
    }
}


