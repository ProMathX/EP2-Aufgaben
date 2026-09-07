import java.util.HashSet;
import java.util.NoSuchElementException;

/**
 * This class represents a product of a positive constant coefficient and at least one variable
 * (such as `3x` or `1xz`).
 */
//
// TODO: define further classes, if needed.
//
public class ConstVarProduct implements SquareFreeTerm // TODO: uncomment clause.
{
    private final NonNegIntConst coeff;
    private HashSet<IntVar> vars;

    //TODO: additional variables, constructors or methods must be private (except when overridden).

    /**
     * Initialized this product of {@code coeff} and multiple variables specified by {@code vars}.
     * @param coeff the positive coefficient of the term (which is not 0),
     *        {@code coeff != null && coeff.isZero() == false}.
     * @param vars the variables in the term, {@code vars != null && vars.length > 0} and all
     *             entries of {@code vars} are not {@code null}.
     */
    public ConstVarProduct(NonNegIntConst coeff, HashSet<IntVar> vars) {
        this.coeff=coeff;
        this.vars=vars;
        // TODO: implement constructor.
    }

    // TODO: uncomment this block:
    @Override
    // returns the sum of {@code this} and {@code e}.
    public SquareFreeExpression plus(SquareFreeExpression e) {
        return e.plus(this);
    }

    @Override
    // returns the sum of {@code this} and {@code t}.
    public SquareFreeExpression plus(SquareFreeTerm t) {

        if (t.getSetView().copyToHashSet().equals(this.vars)) {
            NonNegIntConst c = t.getCoeff().plus(this.getCoeff());
            return new ConstVarProduct(c, this.getSetView().copyToHashSet());
        }
        return new SumOfTerms(this, t);
    }

    @Override
    public IntVarSet getSetView() {
        return new IntVarSet() {
            @Override
            public boolean contains(IntVar v) {
                return vars.contains(v);
            }

            @Override
            public HashSet<IntVar> copyToHashSet() {
                return new HashSet<>(vars);
            }

            @Override
            public void replace(IntVar u, IntVar v) {
                boolean s = vars.remove(u);
                if(s){
                    vars.add(v);
                }
            }
        };
    }

    @Override
    public TermIterator iterator() {
        return new TermIterator() {

            private boolean hasnext=true;
            @Override
            public boolean hasNext() {
                return hasnext;
            }

            @Override
            public SquareFreeTerm next() {
                if(!hasnext){
                    throw new NoSuchElementException();
                }
                hasnext=false;
                return ConstVarProduct.this;
            }
        };
    }

    @Override
    // returns the sum of {@code this} and {@code c}.
    public SquareFreeExpression plus(NonNegIntConst c) {

        if (c.isZero()) {
            return this;
        }
        return new SumOfTerms(this, c);
    }

    @Override
    public NonNegIntConst getCoeff() {
        return this.coeff;
    }

    @Override
    public String toString() {
        StringBuilder toReturn=new StringBuilder();
        toReturn.append(coeff);
        for (IntVar g : vars){
            toReturn.append(g);
        }
        return toReturn.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ConstVarProduct o){
            return o.vars.equals(this.vars) && o.coeff.equals(this.coeff);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.coeff.hashCode() + this.vars.hashCode();
    }

    //TODO: end of block to uncomment

    //TODO: define missing parts of the class.
}

// TODO: define further classes, if needed, either here or in a separate file.
