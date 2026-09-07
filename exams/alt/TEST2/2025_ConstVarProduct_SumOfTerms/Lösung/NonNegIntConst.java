import java.util.*;

/**
 * This class represents a non-negative constant integer value (>= 0).
 * PLEASE DO NOT CHANGE THIS FILE!
 */
public class NonNegIntConst implements SquareFreeTerm {

    private int value;

    // IntConst object representing commonly used values:
    public static final NonNegIntConst ZERO = new NonNegIntConst(0);
    public static final NonNegIntConst ONE = new NonNegIntConst(1);

    /**
     * Initializes this constant with the specified value.
     * @param value the value which {@code this} represents, value >= 0.
     */
    public NonNegIntConst(int value) {

        this.value = value;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dispatches to either {@link #plus(NonNegIntConst)} or {@link #plus(SquareFreeTerm)},
     * depending on the runtime type of {@code e}.
     * </p>
     */
    @Override
    public SquareFreeExpression plus(SquareFreeExpression e) {
        return e.plus(this);
    }

    /**
     * Returns the sum of {@code this} and {@code c}.
     *
     * @param c the second operand, {@code c != null}.
     * @return the sum of {@code this} and {@code c}.
     */
    public NonNegIntConst plus(NonNegIntConst c) {

        return new NonNegIntConst(c.value + this.value);
    }

    /**
     * Returns a new {@link SumOfTerms} representing the sum of this constant and the given term.
     *
     * @param t the second summand != null.
     * @return the sum of {@code this} and the specified term.
     */
    @Override
    public SquareFreeExpression plus(SquareFreeTerm t) {

        return (SquareFreeExpression) new SumOfTerms(t, this);
                //cast can be removed
    }

    /**
     * Returns {@code true} only if {@code this} represents the value 0.
     * @return {@code true} if {@code this} represents the value 0, otherwise {@code false}.
     */
    public boolean isZero() {

        return value == 0;
    }

    /**
     * Returns the product of {@code this} and {@code c}.
     * @param c the second operand, {@code c != null}.
     * @return the sum of {@code this} and {@code c}.
     */
    public NonNegIntConst times(NonNegIntConst c) {

        return new NonNegIntConst(c.value * this.value);
    }

    /**
     * {@inheritDoc}
     * Since this constant is a term without variables, the returned set view
     * does not have any element.
     * @return an empty set.
     */
    @Override
    public IntVarSet getSetView() {
        return new EmptyConst();
    }

    /**
     * Returns a decimal string representation of this constant.
     * @return a decimal string representation of {@code this}.
     */
    @Override
    public String toString() {

        return Integer.toString(value);
    }

    /**
     * Compares {@code this} and {@code o} for equality.
     *
     * @param o the object to compare with
     * @return {@code true} if {@code o} is an {@code IntConst} with the same integer value;
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof NonNegIntConst intVars)) return false;
        return value == intVars.value;
    }

    /**
     * Returns the hash code of {@code this}.
     *
     * @return the hash code of {@code this}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    /**
     * Returns an iterator over the variables occurring in this expression.
     * Since this is a constant, the iterator has no elements.
     *
     * @return an empty {@link TermIterator}.
     */
    @Override
    public TermIterator iterator() {
        return new SingleTermIterator(this);
    }

    /**
     * {@inheritDoc}
     * @return the constant coefficient of this term, which is just {@code this}.
     */
    @Override
    public NonNegIntConst getCoeff() {
        return this;
    }

}

/**
 * An empty set.
 */
class EmptyConst implements IntVarSet {

    @Override
    public boolean contains(IntVar t) {
        return false;
    }

    @Override
    public HashSet<IntVar> copyToHashSet() {
        return new HashSet<>();
    }

    @Override
    public void replace(IntVar u, IntVar v) {
        // do nothing, since there are no variables.
    }
}