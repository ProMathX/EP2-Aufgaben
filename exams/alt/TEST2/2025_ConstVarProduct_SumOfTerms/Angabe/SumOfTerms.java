/**
 * This class represents a square-free expression consisting of more than one term.
 * For example, 3x+1yz+5 consists of multiple terms. {@code SumOfTerms} provides an iterator over all
 * terms of this sum. The order of the iteration is not specified.
 * In this example it iterates over elements '3x', '1yz' and '5'. This class implements
 * {@code SquareFreeExpression}.
 */
//
// TODO: define further classes, if needed.
//
public class SumOfTerms // implements SquareFreeExpression //TODO: uncomment clause.
{

    //TODO: additional variables, constructors or methods must be private (except when overridden).

    /**
     * Initializes 'this' as a sum of two terms. The sum can not be expressed as
     * a single term.
     * @param t1 the first term in this sum, {@code t1 != null}.
     * @param t2 the second term in this sum, {@code t2 != null}.
     *          The following conditions holds: t1.getSetView().equals(t2.getSetView()) == false,
     *           i.e. the sum of the two terms not be expressed as a single term.
     */
    public SumOfTerms(SquareFreeTerm t1, SquareFreeTerm t2) {
        //TODO: implement constructor.
    }

    /**
     * Initializes 'this' as a sum of a term and a constant.
     * @param t the term, {@code t != null}.
     * @param c a constant, {@code c != null && c.isZero() == false}.
     */
    public SumOfTerms(SquareFreeTerm t, NonNegIntConst c) {
        //TODO: implement constructor.
    }


    //TODO: define missing parts of this class.
}

// TODO: define further classes, if needed, either here or in a separate file.
