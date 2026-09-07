/**
 * Represents the left-hand or right-hand side of a chemical reaction formula.
 *
 * <p>Formulas may represent a single formula entity, like `H2O` or `O2`
 * (see {@link SingleEntityFormula}), or a combination of formula entities,
 * like the combination `2H2+O2` of two entities of molecular hydrogen and
 * one entity of molecular oxygen (see {@link MultiEntityFormula}).</p>
 *
 * PLEASE DO NOT CHANGE THIS FILE!
 */
public interface Formula {

    /**
     * Returns an {@link ElementSet} view of {@code this}. Members of this set are the
     * {@link Element}s of {@code this} (no duplicates - multiple occurrences of equal elements in
     * this formula are consequently viewed as one element).
     * Later changes to {@code this} will be reflected in the returned view.
     *
     * @return a {@link ElementSet} view of this formula.
     */
    ElementSet getElementSetView();

    /**
     * Returns a human-readable representation of this formula.
     *
     * <p>Implementations omit coefficients of {@code 1} and join formula entity parts with
     * {@code '+'}. Example: "2H2+O2+2CO2" (multi entity formula)
     * or "H2O" (single molecular entity).</p>
     *
     * <p>While the order of the formula entities in the sum is not specified,
     * within every entity the order in which elements appear is according to the
     * natural order of the class {@link Element}, given by the
     * method {@link Element#compareTo(Element)}. Example: "H2CO3".</p>
     *
     * @return a string representation of this formula.
     */
    String toString();

    /**
     * Compares the specified object with {@code this} for equality. Returns {@code true} if the
     * given object is of the same subtype of {@code Formula} as {@code this} and represents the
     * same formula in the chemical sense. This means each formula entity of {@code this} must
     * have an equal counterpart in {@code obj} with the same coefficient and vice versa. Otherwise,
     * {@code false} is returned.
     * For example, `H2O+CO2` is equal to `CO2+H2O`, but not equal to `H2CO3`
     * and also not equal to `3H2O+CO2`.
     *
     * @param obj the object to check for equality.
     * @return {@code true} if and only if the given object is of the same class as {@code this}
     * and represents the same formula.
     */
    boolean equals(Object obj);

    /**
     * Returns the hash code of {@code this}.
     * @return the hash code of {@code this}.
     */
    int hashCode();
}
