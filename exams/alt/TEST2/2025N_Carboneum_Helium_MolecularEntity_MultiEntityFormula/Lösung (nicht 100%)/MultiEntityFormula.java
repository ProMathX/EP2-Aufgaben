import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * A combination (sum) of one or more {@link SingleEntityFormula} items with associated integer
 * coefficients, for example: `2H2+O2` (coefficient 2 for `H2`, coefficient 1 for `O2`).
 */
//
// TODO: define further classes, if needed.
//
public class MultiEntityFormula implements Formula //TODO: uncomment clause.
{

    //TODO: additional variables, constructors or methods must be private (except when overridden).

    private ArrayList<MolecularEntity> molecularEntities;

    {
        molecularEntities=new ArrayList<>();
    }
    /**
     * Initializes 'this' as a sum of two formulas. If {@code entity1.equals(entity2) == true} then this
     * multi entity formula represents one formula entity with a coefficient of 2. For example,
     * {@code new MultiEntityFormula(O2, O2)} represents `2O2`.
     *
     * @param entity1 the first formula, {@code entity1 != null}.
     * @param entity2 the second formula, {@code entity2 != null}.
     */
    public MultiEntityFormula(SingleEntityFormula entity1, SingleEntityFormula entity2) {
        this.add(entity1);
        this.add(entity2);


        //TODO: implement constructor.
    }

    /**
     * A modifying method that rewrites the internal state of {@code this}.
     * Adds the entity {@code entity} to {@code this} without trying to form a
     * chemical reaction.
     * For example, if {@code f} corresponds to an object representing `H2+O2`, then after calling
     * {@code f.add(SingleEntityFormula.H2)}, {@code f} represents `2H2+O2` (not `2H2O`).
     *
     * @param entity The formula entity to be added to {@code this}, {@code entity != null}.
     */
    void add(SingleEntityFormula entity) {
//        if(molecularEntities.contains((MolecularEntity) entity)){
//            int index=molecularEntities.get(molecularEntities.indexOf((MolecularEntity) entity)).getElementSetView();
//            molecularEntities.remove((MolecularEntity) entity);
//            molecularEntities.add((MolecularEntity) entity);
//        }else{
//            molecularEntities.add((MolecularEntity) entity);
//        }


        //TODO: implement method.
    }

    /**
     * <p>Returns a new formula that corresponds to the chemical reaction of the entities
     * of {@code this} using {@link ReactionOracle}. For example calling {@link #tryReact()} on
     * the formula `O2+2H2` with two {@link SingleEntityFormula} objects will result in a
     * {@link MultiEntityFormula} `2H2O` having only one {@link SingleEntityFormula} object with
     * coefficient of 2. Calling the method on formula `C+O2` will result in a single
     * {@link SingleEntityFormula} object `CO2`. The result is of the most specific dynamic subtype of
     * {@link Formula}.</p>
     *
     * <p>The method does not change {@code this}.</p>
     *
     * <p>The method implementation uses the class {@link ReactionOracle}. If the entities do not
     * react (i.e., {@link ReactionOracle#reactFromAtomCounts} returns an empty map),
     * a copy of {@code this} is returned.</p>
     *
     * @return a new {@link Formula} representing the result of the reaction
     *  of entities in {@code this}.
     */
    public Formula tryReact() {

        //TODO: implement method.
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj != null && obj.getClass() == MultiEntityFormula.class);
    }

    @Override
    public int hashCode() {
        return molecularEntities.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder toReturn=new StringBuilder();
        for (int i = 0; i < molecularEntities.size(); i++) {
            if(!toReturn.isEmpty()){
                toReturn.append(" + ");
            }
            toReturn.append(molecularEntities.get(i).toString());
        }
        //TODO: implement method.
        return toReturn.toString();
    }

    @Override
    public ElementSet getElementSetView() {
        return new ElementSet() {
            @Override
            public boolean contains(Element e) {
                for (int i = 0; i < molecularEntities.size(); i++) {
                    if(molecularEntities.get(i).equals(e)){
                        return true;
                    }
                }
                return false;
            }

            @Override
            public ElementIterator iterator() {
                return new ElementIterator() {

                    int index=0;

                    @Override
                    public boolean hasNext() {
                        return index<molecularEntities.size();
                    }

                    @Override
                    public Element next() {
                        if(!hasNext()){
                            throw new NoSuchElementException();
                        }
                        return (Element) molecularEntities.get(index++);
                    }
                };
            }
        };


    }

    //TODO: define missing parts of the class.
}

// TODO: define further classes, if needed, either here or in a separate file.