import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;

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
public class SumOfTerms implements SquareFreeExpression //TODO: uncomment clause.
{
    private final HashSet<SquareFreeTerm> terms;
    {
        terms=new HashSet<>();
    }

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
        terms.add(t1);
        terms.add(t2);
        //TODO: implement constructor.
    }

    /**
     * Initializes 'this' as a sum of a term and a constant.
     * @param t the term, {@code t != null}.
     * @param c a constant, {@code c != null && c.isZero() == false}.
     */
    public SumOfTerms(SquareFreeTerm t, NonNegIntConst c) {
        if(t.getSetView().copyToHashSet().isEmpty()) {
            ConstVarProduct toAdd = new ConstVarProduct(c, new HashSet<>());
            toAdd.plus(t);
            terms.add(toAdd);
        }else{
            terms.add(t);
            terms.add(new ConstVarProduct(c, new HashSet<>()));
        }
        //TODO: implement constructor.
    }
    public SumOfTerms(HashSet<SquareFreeTerm> t){
        terms.addAll(t);
    }
    /**
     * Returns a linear expression representing the sum of {@code this} and {@code e}. The result is
     * represented by an object of the most specific subtype of {@code SquareFreeExpression}.
     * For example, if the result can be reduced to a single term with variables times
     * a coefficient the returned object is instance of {@code SquareFreeTerm} (for example
     * {@code ConstVarProduct}). If it can be reduced to just a constant the returned object is of
     * type {@code NonNegIntConst}.
     * @param e the second summand != null.
     * @return the sum of {@code this} and {@code e}.
     */
    @Override
    public SquareFreeExpression plus(SquareFreeExpression e) {
        HashSet<SquareFreeTerm> copyFreeTerms = new HashSet<>(terms);
        SquareFreeExpression copyFreeExpr = new SumOfTerms(copyFreeTerms);

        for (SquareFreeTerm term: e){
            copyFreeExpr=copyFreeExpr.plus(term);

        }


        return copyFreeExpr;
    }
    /**
     * The {@code plus} method specifically for constants
     * (see specification of {@code plus(SquareFreeExpression)}).
     * @param c the second summand != null.
     * @return the sum of {@code this} and {@code c}.
     */
    @Override
    public SquareFreeExpression plus(NonNegIntConst c) {

        HashSet<SquareFreeTerm> copyFreeTerms = new HashSet<>(terms);

        SquareFreeTerm result=null;
        for (SquareFreeTerm term : copyFreeTerms){
            if(term.getSetView().copyToHashSet().isEmpty()){
                result=term;
                break;
            }
        }
        if(result!=null){
            NonNegIntConst newCoeff=result.getCoeff().plus(c);
            copyFreeTerms.remove(result);
            copyFreeTerms.add(new ConstVarProduct(newCoeff, new HashSet<>()));
        }else{
            copyFreeTerms.add(new ConstVarProduct(c, new HashSet<>()));
        }

        return new SumOfTerms(copyFreeTerms);


    }
    /**
     * The {@code plus} method specifically for square-free terms, i.e. products of a coefficient
     * and variables.
     * (see specification of {@code plus(SquareFreeExpression)}).
     * @param t the second summand != null.
     * @return the sum of {@code this} and {@code t}.
     */
    @Override
    public SquareFreeExpression plus(SquareFreeTerm t) {

        HashSet<SquareFreeTerm> copyFreeTerms = new HashSet<>(terms);

        SquareFreeTerm result=null;
        for (SquareFreeTerm term : copyFreeTerms){
            if(term.getSetView().copyToHashSet().equals(t.getSetView().copyToHashSet())){
                result=term;
                break;
            }
        }
        if(result!=null){
            NonNegIntConst newCoeff=result.getCoeff().plus(t.getCoeff());
            copyFreeTerms.remove(result);
            copyFreeTerms.add(new ConstVarProduct(newCoeff, t.getSetView().copyToHashSet()));
        }else{
            copyFreeTerms.add(t);
        }

        return new SumOfTerms(copyFreeTerms);

    }
    /**
     * Returns a {@link IntVarSet} view of {@code this} containing all variables occurring in
     * this linear expression. Any call to {@link IntVarSet#replace(IntVar, IntVar) replace
     * (oldVar, newVar)} on that set will update the underlying expression by substituting every
     * occurrence of {@code oldVar} with {@code newVar}.
     *
     * @return a {@link IntVarSet} view of {@code this}.
     */
    @Override
    public IntVarSet getSetView() {
        return new IntVarSet() {
            @Override
            public boolean contains(IntVar v) {
                for (SquareFreeTerm term : terms){
                    if(term.getSetView().contains(v)){
                        return true;
                    }
                }
                return false;
            }

            @Override
            public HashSet<IntVar> copyToHashSet() {
                HashSet<IntVar> vars = new HashSet<>();
                for(SquareFreeTerm term : terms){
                    vars.addAll(term.getSetView().copyToHashSet());
                }
                return vars;
            }

            @Override
            public void replace(IntVar u, IntVar v) {
                for(SquareFreeTerm term : terms){
                    term.getSetView().replace(u, v);
                }

            }
        };
    }
    /**
     * Returns an iterator over all the {@link SquareFreeTerm}.elements of this expression.
     * The order of the elements is not specified.
     *
     * @return an iterator over all the {@link SquareFreeTerm}.elements of this expression.
     */
    @Override
    public TermIterator iterator() {
        return new TermIterator() {

            private int index=0;
            @Override
            public boolean hasNext() {
                return index<terms.size();
            }

            @Override
            public SquareFreeTerm next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                return (SquareFreeTerm) terms.toArray()[index++];
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder toReturn=new StringBuilder();
        for(SquareFreeTerm s: terms){
            if(toReturn.length()>0){
                toReturn.append(" + ");
            }
            toReturn.append(s);
        }
        return toReturn.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SumOfTerms o){
            return o.terms.equals(this.terms);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return terms.hashCode();
    }

    //TODO: define missing parts of this class.
}

// TODO: define further classes, if needed, either here or in a separate file.
