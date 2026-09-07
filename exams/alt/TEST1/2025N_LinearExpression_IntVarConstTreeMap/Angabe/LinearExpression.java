/**
 * This class represents a simple linear expression. A linear expression is a sum of
 * linear terms each containing at most a single variable. There is at most one term representing
 * a constant which does not have a variable.
 *
 * A linear term with a coefficient of 0 is not represented explicitly.
 *
 * An example for a linear expression represented by this class is 3x+y+5.
 */
public class LinearExpression {

    // The map never stores values of 'null'. The only mapping allowed to a value of 0 is the one
    // with a key of {@code null} representing the constant.
    private IntVarConstTreeMap map = new IntVarConstTreeMap();
    //TODO: additional variables, constructors and methods must be private.

    /**
     * Constructs this linear expression from a specified constant.
     *
     * @param c the constant being wrapped as this linear expression, {@code c != null}.
     */
    public LinearExpression(IntConst c) {

        map.put(null, c);
    }

    /**
     * Constructs this linear expression consisting of the term {@code 1v}
     * (coefficient of one times the specified variable).
     *
     * @param v the variable being wrapped as this linear expression, {@code v != null}.
     */
    public LinearExpression(IntVar v) {

        map.put(v, new IntConst(1));
    }

    /**
     * Constructs a linear expression as a copy of the specified expression.
     * Calling methods of this expression will not affect the specified expression
     * and vice versa.
     *
     * @param e the expression from which all the terms are copied to this new expression,
     *          {@code e != null}.
     */
    public LinearExpression(LinearExpression e) {

        this.map = new IntVarConstTreeMap(e.map);
    }

    /**
     * Returns a new linear expression representing the sum of {@code this} and the
     * term {@code 1v}.
     *
     * @param v the second summand, {@code v != null}.
     * @return the sum of {@code this} and {@code v}.
     */
    public LinearExpression plus(IntVar v) {

        //TODO: implement method.
        return null;
    }

    /**
     * Returns a new linear expression representing the sum of {@code this} and {@code c}.
     *
     * @param c the second summand, {@code c != null}.
     * @return the sum of {@code this} and {@code c}.
     */
    public LinearExpression plus(IntConst c) {

        //TODO: implement method.
        return null;
    }

    /**
     * Returns a new linear expression representing the sum of {@code this} and {@code e}.
     *
     * @param e the second summand, {@code e != null}.
     * @return the sum of {@code this} and {@code e}.
     */
    public LinearExpression plus(LinearExpression e) {

        //TODO: implement method.
        return null;
    }

    /**
     * A readable representation of this expression in which each of its variables appears only
     * once preceded by a coefficient, unless the coefficient is 1.
     * The variables appear in lexicographic order according to their names. If present, the
     * constant term appears at the beginning of the string.
     * (See {@link ApplicationTest1} for examples.)
     *
     * @return readable representation of this expression.
     */
    @Override
    public String toString() {

        IntVarQueue queue = map.getKeyQueue();
        String result = "";

        while(queue.size() > 0) {
            IntVar v = queue.poll();
            IntConst c = map.get(v);
            if(c.isZero()) {
                continue;
            }

            String s = c.toString();
            if(c.isOne()) {
                s = "";
            }

            if (!result.isEmpty() && !s.startsWith("-")) {
                result += "+";
            }
            result += s;
            if (v != null) result += v.toString();
        }

        return result.isEmpty() ? "0" : result;
    }
}
