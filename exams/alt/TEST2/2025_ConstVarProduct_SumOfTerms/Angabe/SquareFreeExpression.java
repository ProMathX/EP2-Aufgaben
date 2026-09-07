/**
 * Represents a square‐free (multilinear) expression in multiple variables, in which each
 * variable has an exponent of at most 1 (degree of at most 1). Such an expression
 * is either a single term or a sum of terms, each of which is either
 * <ul>
 *   <li>a constant term with no variables (degree 0), or</li>
 *   <li>a square‐free term with variables (degree 1):
 *      a nonzero coefficient times a product of distinct variables (no variable appears more
 *      than once).</li>
 * </ul>
 *
 * <p>Examples:</p>
 * <ul>
 *   <li>No‐variable square‐free term, i.e. a constant: {@code 5}</li>
 *   <li>Single‐variable square‐free term: {@code 3x}</li>
 *   <li>Two‐variable square‐free term: {@code 2xy}</li>
 *   <li>Sum: {@code 3x + 2xy + 5 + 4yz}</li>
 * </ul>
 * There are no zero‐coefficient terms in a linear expression.
 * Objects of {@code SquareFreeExpression} are iterable: They provide an iterator over
 * all terms of the expression.
 */
public interface SquareFreeExpression extends TermIterable {

    /**
     * Returns a linear expression representing the sum of {@code this} and {@code e}. The result is
     * represented by an object of the most specific subtype of {@code SquareFreeExpression}.
     * For example, if the result can be reduced to a single term with variables times
     * a coefficient the returned object is instance of {@code SquareFreeTerm} (for example
     * {@code ConstVarProduct}). If it can be reduced to just a constant the returned object is of
     * type {@code NonNegIntConst}.
     * @param e the second summand != null.
     * @return the sum of {@code this} and {@code e}.
     */
    SquareFreeExpression plus(SquareFreeExpression e);

    /**
     * The {@code plus} method specifically for constants
     * (see specification of {@code plus(SquareFreeExpression)}).
     * @param c the second summand != null.
     * @return the sum of {@code this} and {@code c}.
     */
    SquareFreeExpression plus(NonNegIntConst c);

    /**
     * The {@code plus} method specifically for square-free terms, i.e. products of a coefficient
     * and variables.
     * (see specification of {@code plus(SquareFreeExpression)}).
     * @param t the second summand != null.
     * @return the sum of {@code this} and {@code t}.
     */
    SquareFreeExpression plus(SquareFreeTerm t);

    /**
     * Returns a {@link IntVarSet} view of {@code this} containing all variables occurring in
     * this linear expression. Any call to {@link IntVarSet#replace(IntVar, IntVar) replace
     * (oldVar, newVar)} on that set will update the underlying expression by substituting every
     * occurrence of {@code oldVar} with {@code newVar}.
     *
     * @return a {@link IntVarSet} view of {@code this}.
     */
    IntVarSet getSetView();

    /**
     * Returns a human‐readable form of this expression.
     * <ul>
     *   <li>Terms with equal variables are combined: each variable product appears exactly
     *   once, with its coefficient.</li>
     *   <li>There are no zero‐coefficient terms in the representation.</li>
     *   <li>The constant term (if non‐zero) appears as a standalone number.</li>
     *   <li>Terms are concatenated without guaranteed order (e.g. “2zx+3y+5”).</li>
     * </ul>
     *
     * @return a string representation of this expression.
     */
    String toString();

    /**
     * Compares the specified object with {@code this} for equality. Returns {@code true} if the
     * given object is of the same subtype of {@code SquareFreeExpression} as {@code this} and
     * represents the same expression in the mathematical sense. This means each term of this
     * must have an equal counterpart in {@code obj} and vice versa. Otherwise, {@code false} is
     * returned.
     * @param obj the object to check for equality.
     * @return if the given object represents the same mathematical expression.
     */
    boolean equals(Object obj);

    /**
     * Returns the hash code of {@code this}.
     * @return the hash code of {@code this}.
     */
    int hashCode();

    /**
     * Returns an iterator over all the {@link SquareFreeTerm}.elements of this expression.
     * The order of the elements is not specified.
     *
     * @return an iterator over all the {@link SquareFreeTerm}.elements of this expression.
     */
    TermIterator iterator();
}
