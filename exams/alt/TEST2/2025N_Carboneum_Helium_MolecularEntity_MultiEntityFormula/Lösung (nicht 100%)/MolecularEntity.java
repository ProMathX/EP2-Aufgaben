import java.util.*;

/**
 * A molecule, i.e., concrete {@link SingleEntityFormula} involving multiple bounded atoms. This
 * corresponds to a collection (multiset) of {@link Element}s in which each {@link Element} is
 * associated with a positive count (multiplicity).
 *
 * Note, that this class represents a single molecule and not a multi entity combination.
 *
 * <p>For example, {@code {H -> 2, O -> 1} renders as {@code "H2O"}.</p>
 */
public class MolecularEntity implements SingleEntityFormula // TODO: uncomment clause.
{
    private HashMap<Element, Integer> moleculaMap;
    //TODO: additional variables, constructors or methods must be private (except when overridden).

    /**
     * Creates a single molecular entity according to the given element-count map.
     *
     * @param map map of element counts; {@code map != null}. Expected to contain
     *            only non-null keys and positive counts.
     */
    public MolecularEntity(HashMap<Element, Integer> map) {
        this.moleculaMap=map;
        //TODO: implement constructor.
    }

    @Override
    public ElementSet getElementSetView() {
        return new ElementSet() {
            @Override
            public boolean contains(Element e) {
                for (Element a : moleculaMap.keySet()) {
                    if(a.equals(e)){
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
                        return index < moleculaMap.size();
                    }

                    @Override
                    public Element next() {
                        if(!hasNext()){
                            throw new NoSuchElementException();
                        }
                        return (Element) moleculaMap.keySet().toArray()[index++];
                    }
                };
            }
        };
    }

    @Override
    /**
     * Renders this entity as a string by concatenating element symbols with numeric counts.
     *
     * <p>Elements are output according to the {@link Element#compareTo(Element)} order.
     * Counts of {@code 1} are omitted (e.g., {@code H2O} instead of {@code H2O1}).</p>
     *
     * @return the textual representation (e.g., {@code "H2CO3"})
     */
    public String toString() {
        StringBuilder toReturn=new StringBuilder();
        for (int i = 0; i < moleculaMap.size(); i++) {
            if(!moleculaMap.entrySet().toArray()[i].equals(1)){
                toReturn.append(moleculaMap.entrySet().toArray()[i]);
            }
            toReturn.append(moleculaMap.keySet().toArray()[i]);
        }
        //TODO: implement method.
        return toReturn.toString();
    }

    @Override
    public int hashCode() {
        return moleculaMap.keySet().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MolecularEntity o){
            for (int i = 0; i < moleculaMap.size(); i++) {
                if(!moleculaMap.keySet().contains(o)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public HashMap<Element, Integer> getMap() {
        return this.moleculaMap;
    }

    //TODO: define missing parts of the class.
}

// TODO: define further classes, if needed, either here or in a separate file.