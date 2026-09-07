import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A 'CompactIntConstSet' implements 'IntConstSet' as a collection of
 * non-overlapping, non-consecutive 'IntConstRangeSet' objects. Consecutive
 * ranges are stored as a single 'IntConstRangeSet' object, rather than two
 * separate objects. For example, instead of a set storing two objects 3-5 and 6-9 the set is
 * represented internally by a single object 3-9 of class 'IntConstRangeSet'.
 */
//
// TODO: Complete the methods in 'CompactIntConstSet'.
//       You can define further classes and methods for the implementation.
//       You may use the Java-Collection framework.
//
public class CompactIntConstSet implements IntConstSet // TODO: uncomment clause.
{

    //TODO: define missing parts of the class.

    /**
     * Initialises 'this' as an empty set.
     */
    public CompactIntConstSet() {

    }

    /**
     * Adds the specified element 'e' to this set if the set contains no element 'e2' such that
     * e.equals(e2). If this set already contains such an element, the call leaves the set unchanged.
     *
     * @param e the element to be added to the set, e != null.
     */
    public void add(IntConst e) {

    }

    /**
     * Returns a readable representation of the set. The representation shows the numbers in
     * ascending order separated by ','. Wherever a range of consecutive numbers from n to m
     * appears in the representation this representation is in the form n-m.
     * <p>
     * Example:
     * 1,3,6-9,12-20,22.
     *
     * @return a readable representation of the set.
     */
    public String toString() {
        return "";
    }

    @Override
    public IntConstRange getRangeView() {
        return null;
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
     * Returns 'true' if 'o' is also of class 'CompactIntConstSet' and represents the same
     * set as 'this' in a mathematical sense (has equal 'IntConst' elements).
     * Otherwise, 'false' is returned.
     * The method should not compare objects by using their toString() method.
     *
     * @param o the other object to compare with.
     * @return 'true' if 'this' and 'o' are equal and 'false' otherwise.
     */
    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public IntConstIterator iterator() {
        return null;
    }
}
