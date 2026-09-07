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
public class MolecularEntity // implements SingleEntityFormula // TODO: uncomment clause.
{
    //TODO: additional variables, constructors or methods must be private (except when overridden).

    /**
     * Creates a single molecular entity according to the given element-count map.
     *
     * @param map map of element counts; {@code map != null}. Expected to contain
     *            only non-null keys and positive counts.
     */
    public MolecularEntity(HashMap<Element, Integer> map) {
        //TODO: implement constructor.
    }


    /**
     * Renders this entity as a string by concatenating element symbols with numeric counts.
     *
     * <p>Elements are output according to the {@link Element#compareTo(Element)} order.
     * Counts of {@code 1} are omitted (e.g., {@code H2O} instead of {@code H2O1}).</p>
     *
     * @return the textual representation (e.g., {@code "H2CO3"})
     */
    @Override
    public String toString() {
        //TODO: implement method.
        return null;
    }

    public HashMap<Element, Integer> getMap() {
        return null;
    }

    //TODO: define missing parts of the class.
}

// TODO: define further classes, if needed, either here or in a separate file.