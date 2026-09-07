import java.util.*;

// This class represents a polynomial corresponding to a sum of terms, where each term is a
// 'Monomial' object multiplied by a coefficient, like 3*x*y + 4*x*x + 1*x*x*y + 3*1. (Factors
// of one are omitted in the string representation, see specification of 'toString'.)
// A polynomial may also consist of a single term like 2*x*y.
//
public class SimplePolynomial implements Polynomial //TODO: activate clause.
{
    private final HashMap<Monomial, Integer> terms;
    // TODO: define missing parts of this class (including getters as needed).


    // Initializes 'this' with one term corresponding to coefficient*m. Polynomials with
    // multiple terms can be constructed by calling 'sumWith'.
    // Precondition: m != null && coefficient > 0.
    public SimplePolynomial(Monomial m, int coefficient) {
        this.terms = new HashMap<>();
        this.terms.put(m, coefficient);
        // TODO: implement constructor.
    }

    public SimplePolynomial() {
        this.terms = new HashMap<>();
    }

    // Add the specified polynomial to 'this'. For example, if 'this' corresponds to 3*x*y*y + 2*x
    // and 'other' to x*y*y then 'this' becomes 4*x*y*y + 2*x.
    // Precondition: other != null.
    void add(Polynomial other) {
        for (Monomial othermon : other.asMap().keySet()) {
            int coef = other.getCoefficientOf(othermon);
            int currentCoeff = this.getCoefficientOf(othermon);    // keresés
            if (currentCoeff == 0) {   // ha a this-ben nincs ilyen monom
                this.terms.put(othermon, coef);
            } else {
                this.terms.put(othermon, coef + currentCoeff);
            }
        }
        // TODO: implement method.

    }

    // Evaluates this polynomial using the provided 'value' for 'v'. For example,
    // the result of p.evaluate(x, 2) if 'p' is the polynomial 3*x*x*x*y is the polynomial 24*y.
    // (For simplicity, we assume that 'value' is a positive integer.)
    // Precondition: v != null && value > 0.
    @Override
    public Polynomial evaluate(Variable v, int value) {
        SimplePolynomial result=new SimplePolynomial();
        for (Monomial monomial : terms.keySet()) {
            int coeff = this.terms.get(monomial);
            SimplePolynomial evalPoli = (SimplePolynomial) monomial.evaluate(v, value);
            Monomial evalMono = evalPoli.iterator().next();
            int coeffEval = evalPoli.getCoefficientOf(evalMono);

            result.add(new SimplePolynomial(evalMono,coeffEval*coeff));
        }

        return result;

    }

    @Override
    public VariableSet getVariableSetView() {
        return new VariableSet() {
            @Override
            public boolean contains(Variable variable) {
                for (Monomial moni : terms.keySet()) {
                    if (moni.getVariableSetView().contains(variable)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    @Override
    public int getCoefficientOf(Monomial m) {
        if (m == null) {
            throw new IllegalArgumentException();
        }
        if (terms.get(m) != null) {
            return terms.get(m);
        }
        return 0;
    }

    @Override
    public HashMap<Monomial, Integer> asMap() {
        return this.terms;
    }

    @Override
    public MonomialIterator iterator() {
        return new MonomialIterator() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < terms.size();
            }

            @Override
            public Monomial next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("no more monomials!");
                }
                return (Monomial) terms.keySet().toArray()[currentIndex++];
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
//        for (var element : terms.entrySet()) {
//            toReturn.append(element.getValue()).append()
//        }
        for (var element : terms.keySet()) {
            if (!toReturn.isEmpty()) {
                toReturn.append(" + ");
            }
            var coeff = terms.get(element);
            toReturn.append(coeff == 1 ? "" : (coeff + "*")).append(element);
        }
        return toReturn.toString();


    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SimplePolynomial o) {
            return this.terms.equals(o.terms);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return terms.hashCode();
    }
}
