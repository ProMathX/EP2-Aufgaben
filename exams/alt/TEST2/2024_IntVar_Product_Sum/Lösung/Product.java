import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * This class represents a product with one constant and at least one variable,
 * like 5*x*y or 3*x.
 */
//
// TODO: Complete the methods in 'Product'.
//       You can define further classes and methods for the implementation.
//       You may use the Java-Collection framework.
//
public class Product implements Monomial // TODO: activate clause.
{
    private IntConstNonNeg coeff;
    private IntVar[] vars;


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
        this.coeff=coeff;
        this.vars=vars;
        Arrays.sort(this.vars, Comparator.comparing(IntVar::getName));
        //Arrays.sort(this.vars, (x,y)-> x.getName().compareTo(y.getName()));

        //TODO: implement constructor.
    }


    @Override
    public IntConstNonNeg getCoefficientPart() {
        return this.coeff;
    }

    @Override
    public Monomial getVariablePart() {
        if(this.vars.length==0){
            return new IntConstNonNeg(0);
        }
        return new Product(new IntConstNonNeg(1), this.vars);
    }

    @Override
    public IntVarSet getIntVarSetView() {
        return new IntVarSet() {
            @Override
            public boolean contains(IntVar v) {
                for(IntVar var : vars){
                    if(var.equals(v)){
                        return true;
                    }
                }
                return false;
            }
        };
    }

    @Override
    public Polynomial times(IntConstNonNeg c) {
        return new Product(this.coeff.times(c),this.vars);
    }

    @Override
    public MonomialIterator iterator() {
        return new MonomialIterator() {

            private int currentIndex=0;
            @Override
            public boolean hasNext() {
                return currentIndex<vars.length;
            }

            @Override
            public Monomial next() {
                if(!hasNext()){
                    throw new NoSuchElementException("no monomial!");
                }
                return vars[currentIndex++];
            }
        };
    }

    @Override
    public String toString(){
        StringBuilder toReturn = new StringBuilder();
        toReturn.append(coeff);
        for (int i = 0; i < vars.length; i++) {
            toReturn.append("*"+this.vars[i]);
        }
        return toReturn.toString();
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Product other){
            return this.coeff.equals(other.coeff) && Arrays.equals(this.vars,other.vars);
        }
        return false;
    }

    /**
     * Returns the hash code of 'this'.
     *
     * @return the hash code of 'this'.
     */
    @Override
    public int hashCode() {

        return this.coeff.hashCode()+Arrays.hashCode(this.vars);
    }
}

//TODO: define further classes, if needed, either here or in a separate file.
