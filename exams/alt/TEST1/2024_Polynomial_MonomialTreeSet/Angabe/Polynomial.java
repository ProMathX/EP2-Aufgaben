/**
 * A polynomial that is made of multiple monomials. The simplest
 * polynomial is made of one single monomial.
 */
public class Polynomial {

    /**
     * Initializes this polynomial as a sum of the monomials in set.
     *
     * @param set, the set of monomials to be summed up, set is not empty.
     */
    public Polynomial(MonomialTreeSet set) {
    }

    /**
     * Returns a string representation of this polynomial in which the terms appear ordered
     * according to their degree and there is at most one term with a specific degree (terms of
     * the same degree are represented by their sum).
     * In case of a negative coefficient a preceding '+' is not written. Monomials with
     * coefficient of 0 do not appear in the string representation.
     * Example: "1x^0+2x^3+1x^4-3x^5"
     *
     * @return the string representation of this polynomial.
     */
    public String toString() {
        return "";
    }
}
