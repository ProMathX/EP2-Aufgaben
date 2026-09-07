import java.util.HashSet;

/**
 * This class represents a product of a positive constant coefficient and at least one variable
 * (such as `3x` or `1xz`).
 */
//
// TODO: define further classes, if needed.
//
public class ConstVarProduct // implements SquareFreeTerm // TODO: uncomment clause.
{

    //TODO: additional variables, constructors or methods must be private (except when overridden).

    /**
     * Initialized this product of {@code coeff} and multiple variables specified by {@code vars}.
     * @param coeff the positive coefficient of the term (which is not 0),
     *        {@code coeff != null && coeff.isZero() == false}.
     * @param vars the variables in the term, {@code vars != null && vars.length > 0} and all
     *             entries of {@code vars} are not {@code null}.
     */
    public ConstVarProduct(NonNegIntConst coeff, HashSet<IntVar> vars) {
        // TODO: implement constructor.
    }

    /* TODO: uncomment this block:
    @Override
    // returns the sum of {@code this} and {@code e}.
    public SquareFreeExpression plus(SquareFreeExpression e) {
        return e.plus(this);
    }

    @Override
    // returns the sum of {@code this} and {@code t}.
    public SquareFreeExpression plus(SquareFreeTerm t) {
    }

     */
    //TODO: end of block to uncomment

    //TODO: define missing parts of the class.
}

// TODO: define further classes, if needed, either here or in a separate file.
