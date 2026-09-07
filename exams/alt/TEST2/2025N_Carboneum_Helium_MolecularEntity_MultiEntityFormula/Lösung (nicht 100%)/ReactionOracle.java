import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A static reaction helper that assembles known {@link SingleEntityFormula}
 * instances from a collection (multiset) of atoms. For simplicity, (in this He-H-C-O simulation)
 * you can assume that this selection of formulas is complete. There are no further elements and
 * molecules.
 *
 * @implSpec The implementation applies each known formula in a fixed, documented order,
 *           repeatedly as long as all required atoms are available. For each successful
 *           application the corresponding atom counts are subtracted. This continues
 *           until no known formula can be formed anymore. The algorithm is greedy and
 *           does not perform backtracking or optimality search. If not all elements are
 *           consumed, a reaction is not possible and therefore rejected.
 *
 * <h3>Example</h3>
 * <pre>{@code
 * Map<Element,Integer> atoms = new HashMap<>();
 * atoms.put(Element.H, 2);
 * atoms.put(Element.O, 1);
 * HashMap<FormulaEntity,Integer> map = ReactionOracle.reactFromAtomCounts(atoms);
 * // map contains: { H2O -> 1 }
 * }
 * </pre>
 *
 * PLEASE DO NOT CHANGE THIS FILE.
 */
public final class ReactionOracle {

    private ReactionOracle() {}

    /**
     * Fixed list of known formulas. The order is semantically relevant and defines
     * the canonicalization order of the result.
     */
    static final SingleEntityFormula[] KNOWN = new SingleEntityFormula[] {
            // casts are not necessary once `implements` clauses are all activated.
            (SingleEntityFormula) SingleEntityFormula.H2CO3,  // carbonic acid
            (SingleEntityFormula) SingleEntityFormula.CO2,
            (SingleEntityFormula) SingleEntityFormula.H2O,
            (SingleEntityFormula) SingleEntityFormula.CO,
            (SingleEntityFormula) SingleEntityFormula.CH4,
            (SingleEntityFormula) SingleEntityFormula.C2H4,
            (SingleEntityFormula) SingleEntityFormula.O2,
            (SingleEntityFormula) SingleEntityFormula.H2,
            (SingleEntityFormula) SingleEntityFormula.C,
            (SingleEntityFormula) SingleEntityFormula.He
    };

    /**
     * Forms a canonical combination from the provided atom inventory by greedily composing
     * known {@link SingleEntityFormula} instances in the order defined by {@link #KNOWN}.
     *
     * @param atomCounts a non-null map of available atoms with non-negative counts; will not
     *                   be mutated by this method.
     * @return a non-null {@link LinkedHashMap} from new formula entities to coefficient; will be
     *      empty if not all provided elements will be part of new formula entities. If the
     *      returned map is empty, it means that the formula does not react.
     */
    public static HashMap<SingleEntityFormula, Integer> reactFromAtomCounts(Map<Element, Integer> atomCounts) {

        HashMap<SingleEntityFormula, Integer> newMap = new HashMap<SingleEntityFormula, Integer>();

        for (SingleEntityFormula entity : KNOWN) {
            while (canForm(entity, atomCounts)) {
                subtract(entity, atomCounts);
                Integer old = newMap.get(entity);
                newMap.put(entity, old == null ? 1 : old + 1);
            }
        }
        if (!atomCounts.isEmpty()) {
            return new HashMap<SingleEntityFormula, Integer>();
        }
        return newMap;
    }

    /**
     * Checks whether all atoms required by {@code entity} are available in {@code counts}.
     *
     * @param entity the non-null formula whose atomic requirements are to be checked
     * @param counts a non-null map of available atoms with non-negative counts; not mutated
     * @return {@code true} if {@code entity} can be formed from {@code counts}; {@code false} otherwise
     *
     * @implNote Does not mutate {@code counts}. Requires that {@code entity.getMap()} is non-null and well-formed.
     */
    private static boolean canForm(SingleEntityFormula entity, Map<Element, Integer> counts) {
        for (Map.Entry<Element, Integer> need : entity.getMap().entrySet()) {
            Integer have = counts.get(need.getKey());
            if (have == null || have < need.getValue()) return false;
        }
        return true;
    }

    /**
     * Subtracts the atoms of {@code entity} from {@code counts}. Removes entries whose count drops to zero.
     *
     * @param entity the non-null formula whose atoms will be subtracted from {@code counts}
     * @param counts a non-null, mutable map of available atoms that will be mutated in-place
     *
     * @implSpec Mutates {@code counts} in-place. Callers must ensure via {@link #canForm(SingleEntityFormula, Map)}
     *           that sufficient atoms are available; otherwise behavior is unspecified.
     */
    private static void subtract(SingleEntityFormula entity, Map<Element, Integer> counts) {
        for (Map.Entry<Element, Integer> need : entity.getMap().entrySet()) {
            Element el = need.getKey();
            int left = counts.get(el) - need.getValue();
            if (left == 0) counts.remove(el);
            else counts.put(el, left);
        }
    }
}
