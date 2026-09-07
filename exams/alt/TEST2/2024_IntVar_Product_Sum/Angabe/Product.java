/**
 * This class represents a product with one constant and at least one variable,
 * like 5*x*y or 3*x.
 */
//
// TODO: Complete the methods in 'Product'.
//       You can define further classes and methods for the implementation.
//       You may use the Java-Collection framework.
//
public class Product //implements Monomial // TODO: activate clause.
{

    // TODO: define missing parts of this class.

    /**
     * Initializes 'this' as a product of the specified coefficient and variables.
     * Variables can occur more often than once in the specified array.
     * (The number of occurrences corresponds to the exponent of the variable.)
     *
     * This class must be used only for non-trivial products:
     * The preconditions given below ensure that this class is not used for representing
     * objects that can be represented by 'IntConstNonNeg' or 'IntVar', like for example: 1*x or 0*x*y.
     *
     * The method throws an 'IllegalArgumentException' if the preconditions are not met.
     *
     * @param coeff the coefficient in this product,
     *              coeff != null && !coeff.isZero().
     * @param vars an array with the variables of this product.
     *             coeff.isOne() && vars.length >= 2 || !coeff.isOne() && vars.length >= 1,
     *             vars[i] != null for all valid i.
     * @throws IllegalArgumentException if the preconditions are not fulfilled (no detail message).
     */
    public Product(IntConstNonNeg coeff, IntVar... vars) {

        //TODO: implement constructor.
    }

}

//TODO: define further classes, if needed, either here or in a separate file.
