/**
 * A set of 'Monomial' objects implemented as a binary search tree. The monomials are ordered
 * according to their degree. Monomials of the same degree are ordered according to their
 * coefficient.
 * The set allows multiple monomials to have the same degree and coefficient as long as
 * the monomials are not identical. The order of monomials with the same degree
 * and coefficient is not specified.
 * The number of elements of the set is not limited. The set does not have entries of 'null'.
 */
//
// TODO: Complete the methods in 'MonomialTreeSet'.
//       You can define further classes and methods for the implementation of the
//       binary search tree if needed.
//       Do NOT use the Java-Collection framework in 'MonomialTreeSet' or any other class.
//
public class MonomialTreeSet {

    /**
     * Initializes 'this' as an empty list.
     */
    public MonomialTreeSet() {
    }

    /**
     * Initializes this set as an independent copy of 'set'. Later changes of 'this'
     * will not affect 'set' and vice versa.
     *
     * @param set the set from which the elements are copied to 'this', set != null.
     */
    public MonomialTreeSet(MonomialTreeSet set) {

    }

    /**
     * Adds the specified element 'm' to this set. If 'm' is already contained in this set,
     * the methods has no effect.
     *
     * @param m the monomial that is added, m != null.
     */
    public void add(Monomial m) {

    }

    /**
     * Returns 'true' if and only if 'm' is contained in this set. More formally, returns
     * 'true' if and only if this set contains an element 'e' such that e == m.
     * (There can be at most one such element.)
     *
     * @param m the element to be checked, m != null.
     * @return 'true' if and only if 'm' is contained in this set.
     */
    public boolean contains(Monomial m) {
        return false;
    }


    /**
     * Adds all elements of this set to the specified queue in the order of the tree.
     * The monomial with the lowest degree (and coefficient) is added first.
     *
     * @param q the queue to which all elements of 'this' are added, q != null.
     */
    public void addAllToQueue(MonomialQueue q) {

    }
}
