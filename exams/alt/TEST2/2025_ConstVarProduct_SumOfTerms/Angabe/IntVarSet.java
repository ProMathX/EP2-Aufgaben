import java.util.HashSet;

/**
 * A set of {@link IntVar} elements. For simplicity, it only provides selected methods.
 * PLEASE DO NOT CHANGE THIS FILE!
 */
public interface IntVarSet {

    /**
     * Checks whether the specified variable is a member of this set, i.e., if this set
     * has an element equal to the specified variable.
     *
     * @param v the variable to test for membership, {@code v != null}.
     * @return {@code true} if this set contains a term equal to {@code v};
     *          {@code false} otherwise
     */
    boolean contains(IntVar v);

    /**
     * Returns a new {@code java.util.HashSet<IntVar>} with all the elements of
     * this set.
     * The returned object is *not* a view, but an independent set.
     * (However, {@link IntVar} elements themselves need not be duplicated,
     * since they are immutable.)
     *
     * @return a new {@code java.util.HashSet<IntVar>} with all the elements of this set.
     */
    HashSet<IntVar> copyToHashSet();

    /**
     * Replaces in {@code this} the element {@code u} with the new element {@code v}.
     * If {@code u} is not contained in this set, the method has no effect.
     * It is not allowed that {@code v} is already contained in this set when calling this method
     * (precondition).
     *
     * @param u the element to be replaced, {@code u != null}.
     * @param v the new element that replaces {@code u},
     *          {@code v != null && this.contains(v) == false}.
     */
    void replace(IntVar u, IntVar v);
}
