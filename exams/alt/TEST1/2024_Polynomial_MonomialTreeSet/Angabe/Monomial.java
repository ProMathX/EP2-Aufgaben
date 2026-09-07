/**
 * This class represents a monomial, which is a algebraic
 * expression of the form c⋅xᵈ where 'c' is the constant coefficient,
 * 'x' is the variable and 'd' the constant degree of the monomial.
 * PLEASE, DO NOT CHANGE THIS FILE.
 */
public class Monomial {

    private final int degree, coefficient;

    /**
     * Initializes this monomial with its degree and coefficient. The variable cannot be specified
     * and is the same for all monomials.
     *
     * @param degree      the degree of this monomial (can also be 0).
     * @param coefficient the coefficient of this monomial (can also be 0).
     */
    public Monomial(int degree, int coefficient) {

        this.degree = degree;
        this.coefficient = coefficient;
    }

    /**
     * If 'this' and 'm' have the same degree, this method returns a new monomial
     * representing the sum of 'this' and 'm'. Otherwise, the method returns 'null'.
     *
     * @param m the second summand, m != null.
     * @return a new monomial representing the sum of 'this' and 'm' if 'this' and 'm'
     * have the same degree, otherwise 'null'.
     */
    public Monomial plus(Monomial m) {

        if (this.degree != m.degree) {
            return null;
        }
        return new Monomial(degree, this.coefficient + m.coefficient);
    }

    /**
     * Returns the degree of this monomial.
     *
     * @return the degree of this monomial.
     */
    public int getDegree() {
        return degree;
    }

    /**
     * Returns the coefficient of this monomial.
     *
     * @return the coefficient of this monomial.
     */
    public int getCoefficient() {
        return coefficient;
    }

    /**
     * Returns a string representation of this monomial in the format: 'coefficient' followed by
     * "x^" and the degree, for example "3x^2".
     *
     * @return a string representation of this monomial.
     */
    @Override
    public String toString() {
        return coefficient + "x^" + degree;
    }
}
