import java.util.HashMap;
import java.util.Map;

/**
 * A formula entity (e.g., `H2O` or `CO2` or `He`). This formula entity represents either a
 * monatomic formula (atoms of such species can exist unbounded, such as `He`) or a molecule in
 * which multiple atoms are bounded. You can think of a formula entity as a
 * collection of {@link Element}s with associated multiplicities.
 *
 * <p>This interface also provides predefined constants. For simplicity,
 * (in this He-H-C-O simulation) you can assume that this selection of formulas is complete.
 * There are no further elements and molecules.
 * </p>
 *
 * PLEASE DO NOT CHANGE THIS FILE!
 */
public interface SingleEntityFormula extends Formula {

    Carboneum C = new Carboneum();
    Helium He = new Helium();
    MolecularEntity H2CO3 = new MolecularEntity(
            new HashMap<Element, Integer>(Map.of(
                    new Hydrogenium(), 2,
                    (Element) C, 1,
                    new Oxygenium(), 3)));
    MolecularEntity CO2 = new MolecularEntity(
            new HashMap<Element, Integer>(Map.of((Element)new Carboneum(), 1, new Oxygenium(), 2)));
    MolecularEntity H2O = new MolecularEntity(
            new HashMap<Element, Integer>(Map.of(new Hydrogenium(), 2, new Oxygenium(), 1)));
    MolecularEntity CO = new MolecularEntity(
            new HashMap<Element, Integer>(Map.of((Element)new Carboneum(), 1, new Oxygenium(), 1)));
    MolecularEntity CH4 = new MolecularEntity(
            new HashMap<Element, Integer>(Map.of((Element)new Carboneum(), 1, new Hydrogenium(), 4)));
    MolecularEntity C2H4 = new MolecularEntity(
            new HashMap<Element, Integer>(Map.of((Element)new Carboneum(), 2, new Hydrogenium(), 4)));
    MolecularEntity O2 = new MolecularEntity(
            new HashMap<Element, Integer>(Map.of(new Oxygenium(), 2)));
    MolecularEntity H2 = new MolecularEntity(
            new HashMap<Element, Integer>(Map.of(new Hydrogenium(), 2)));

    @Override
    /**
     * Renders this entity as a string by concatenating element symbols with numeric counts.
     *
     * <p>Elements are output according to the {@link Element#compareTo(Element)} order.
     * Counts of {@code 1} are omitted (e.g., {@code H2O} instead of {@code H2O1}).</p>
     *
     * Hint: Since {@link Element} implements {@link Comparable<Element>} you can use
     * the java collection framework for creating an ordered output.
     *
     * @return the textual representation (e.g., {@code "H2CO3"})
     */
    public String toString();

    /**
     * Returns a new java.util.HashMap<Element, Integer> with one key-value pair for each
     * element occurring in this formula entity. The element is associated with the number of its atoms in
     * this formula entity.
     * The returned object is *not* a view, but an independent map.
     * (However, {@link Element} keys and {@link Integer} values need not be duplicated,
     * since they are immutable.)
     *
     * @return a new java.util.HashMap<Element, Integer> with all elements and
     * their number occurring in this formula entity.
     */
    HashMap<Element, Integer> getMap();
}
