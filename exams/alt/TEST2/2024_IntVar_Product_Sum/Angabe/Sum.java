/**
 * This class represents a polynomial corresponding to a sum of different monomials,
 * like 3*x*y + 4*x*x + 2*x*x*y + 3.
 *
 * A sum has at least one monomial (the constant 0).
 */
//
// TODO: Complete the methods in 'Sum'.
//       You can define further classes and methods for the implementation.
//       You may use the Java-Collection framework.
//
public class Sum //implements Polynomial
{

    /**
     * Initializes 'this' as the polynomial with the single monomial 0. Polynomials with
     * multiple terms can be constructed by calling 'add'.
     */
    public Sum() {
        //TODO: implement constructor
    }

    /**
     * Add the specified polynomial to 'this'. For example, if 'this' corresponds to 3*x*y*y + 2*x
     * and 'other' to 1*x*y*y then 'this' becomes 4*x*y*y + 2*x.
     * The method leaves 'other' unchanged.
     *
     * @param other the other polynomial to add to this, other != null.
     * Precondition: other != null.
     */
    public void add(Polynomial other) {
        //TODO: implement method
    }
}
//TODO: define further classes, if needed, either here or in a separate file.
