import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * This class represents a polynomial corresponding to a sum of different monomials,
 * like 3*x*y + 4*x*x + 2*x*x*y + 3.
 * <p>
 * A sum has at least one monomial (the constant 0).
 */
//
// TODO: Complete the methods in 'Sum'.
//       You can define further classes and methods for the implementation.
//       You may use the Java-Collection framework.
//
public class Sum implements Polynomial {
    private final ArrayList<Monomial> monomials;

    /**
     * Initializes 'this' as the polynomial with the single monomial 0. Polynomials with
     * multiple terms can be constructed by calling 'add'.
     */
    public Sum() {
        this.monomials = new ArrayList<>();
        //TODO: implement constructor
    }

    /**
     * Add the specified polynomial to 'this'. For example, if 'this' corresponds to 3*x*y*y + 2*x
     * and 'other' to 1*x*y*y then 'this' becomes 4*x*y*y + 2*x.
     * The method leaves 'other' unchanged.
     *
     * @param other the other polynomial to add to this, other != null.
     *              Precondition: other != null.
     */
    public void add(Polynomial other) {
        if (other instanceof IntConstNonNeg o && o.isZero()) {
            return;
        }
        if (other instanceof Product o) {
            Monomial foundMonomial = null;
            for (Monomial monomial : monomials) {
                if (monomial.getVariablePart().equals(o.getVariablePart())) {
                    foundMonomial = monomial;
                    break;
                }
            }

            if (foundMonomial == null) {
                monomials.add(o);
            } else {
                int counter = 0;
                for (var element : o) {
                    counter++;
                }
                IntVar[] newVars = new IntVar[counter];
                int i = 0;
                for (var element : o) {
                    newVars[i] = (IntVar) element;
                    i++;
                }
                Product newMonomial = new Product(foundMonomial.getCoefficientPart().plus(o.getCoefficientPart()), newVars);
                monomials.remove(foundMonomial);
                monomials.add(newMonomial);
            }
        }
        //TODO: implement method
    }

    @Override
    public IntVarSet getIntVarSetView() {
        return new IntVarSet() {
            @Override
            public boolean contains(IntVar v) {
                for (Monomial monomial : monomials) {
                    if (monomial.getIntVarSetView().contains(v)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    @Override
    public Polynomial times(IntConstNonNeg c) {
        Sum toReturn = new Sum();
        for (Monomial monomial : monomials) {
            toReturn.add(monomial.times(c));
        }
        return toReturn;
    }

    @Override
    public MonomialIterator iterator() {

        return new MonomialIterator() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < Sum.this.monomials.size();
            }

            @Override
            public Monomial next() {
                if(!hasNext()){
                    throw new NoSuchElementException("no monomial!");
                }
                return monomials.get(currentIndex++);

            }
        };
    }

    @Override
    public String toString() {
        StringBuilder toReturn=new StringBuilder();
        for (Monomial monomial : monomials) {

            if(!toReturn.isEmpty()){
                toReturn.append(" + ");
            }

            if(monomial instanceof Product p && p.getCoefficientPart().isOne()){
                toReturn.append(monomial.toString().replace("1*",""));
            }else{
                toReturn.append(monomial.toString());
            }


        }
        if(toReturn.isEmpty()){
            toReturn.append(0);
        }
        return toReturn.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Sum other){
            return this.monomials.equals(other.monomials);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return monomials.hashCode();
    }
}
//TODO: define further classes, if needed, either here or in a separate file.
