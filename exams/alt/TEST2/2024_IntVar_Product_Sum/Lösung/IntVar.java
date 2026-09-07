import java.util.NoSuchElementException;

/**
 * This class represents a free variable which can take on integer values. Each object of
 * this class represents a different variable (regardless of the name). This means that
 * for two 'IntVar' reference values 'a' and 'b', a.equals(b) == true only if 'a' and 'b'
 * refer to the same object (a == b has value 'true').
 *
 * A variable is also a monomial with a coefficient of 1 and the variable part is 'this'.
 * A variable contains only one variable, namely 'this'.
 */
//
// TODO: activate statement in method 'times'.
//
public class IntVar implements Monomial
{
    private final String name;

    /**
     * Initializes this variable with a specified name.
     *
     * @param name, the name != null.
     */
    public IntVar(String name) {

        this.name = name;
    }

    /**
     * Returns the name of this variable.
     *
     * @return the name of this variable.
     */
    public String getName() {

        return name;
    }

    /**
     * Returns a readable representation of 'this', which is the name of this variable.
     *
     * @return a readable representation of 'this'.
     */
    @Override
    public String toString() {

        return name;
    }

    /**
     * Returns the coefficient of 'this', which is just 1 for a variable (x = 1*x).
     *
     * @return the coefficient of 'this'.
     */
    @Override
    public IntConstNonNeg getCoefficientPart() {

        return new IntConstNonNeg(1);
    }

    /**
     * Returns the variable part of 'this', which is just 'this' itself.
     *
     * @return the variable part of 'this'.
     */
    @Override
    public Monomial getVariablePart() {

        return this;
    }

    /**
     * Returns the product of 'this' and 'c'.
     *
     * @param c the constant multiplier, c != null.
     * @return the product of 'this' and 'c'.
     */
    @Override
    public Monomial times(IntConstNonNeg c) {
        //TODO: activate statement.
        return new Product(c, this);
    }

    @Override
    public MonomialIterator iterator() {
        return new MonomialIterator() {

            private boolean state = true;

            @Override
            public boolean hasNext() {
                return state;

            }

            @Override
            public Monomial next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("no monomial!");
                }
                state=false;
                return IntVar.this;
            }
        };
    }

    @Override
    public IntVarSet getIntVarSetView() {

        return new IntVarSet() {
            @Override
            public boolean contains(IntVar v) {
                return v.equals(IntVar.this);
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof IntVar other){
            return this.name.equals(other.name);
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

        return name.hashCode();
    }

}


