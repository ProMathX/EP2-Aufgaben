/**
 * Objects of 'SquareFreeTerm' represent single square-free terms which are products of at least one
 * variable and one non-zero coefficient. All occurring variables have an exponent of 1 (no
 * squares or higher degrees). For example, '3xy' or '1z' are square-free terms. Constants are also
 * square-free terms.
 *
 * PLEASE DO NOT CHANGE THIS FILE!
 */
public interface SquareFreeTerm extends SquareFreeExpression {

    /**
     * Returns the constant coefficient in this term.
     *
     * @return the constant coefficient in this term.
     */
    NonNegIntConst getCoeff();
}
