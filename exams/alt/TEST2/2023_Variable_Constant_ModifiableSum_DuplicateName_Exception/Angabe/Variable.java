import java.util.*;

// Represents a variable. 'Variable' implements 'Expression'.
// Each variable is uniquely identified by its
// instance. Two variables are considered equal only if they have the same identity (regardless
// of their name).
//
public class Variable implements Expression
{

    public Variable(String name) {
        // TODO

    }

    @Override
    // Evaluates this expression using the provided variable-value mapping.
    // If the map contains an entry for this variable, we return the associated value, else the variable itself (this)
    // is returned.
    // Precondition: map != null.
    public Expression evaluate(HashMap<Variable, Constant> map) {
        // TODO
        return null;
    }

    @Override
    // Returns the coefficient of the specified variable in the expression. If the variable is equal to 'this', 1 is
    // returned, else 0,
    // Precondition: variable != null.s
    public Constant coefficientOf(Variable variable) {
        // TODO
        return null;
    }

    @Override
    // Returns the sum of all constants in the expression. Since there are no constants in this expression, always 0
    // is returned.
    public Constant getConstant() {
        // TODO
        return null;
    }

    @Override
    // Returns a map that associates each variable in this expression with its coefficient.
    // For example, for the expression x + y + x + 3 the map has two mappings, associating variable
    // 'x' with constant 2 and variable 'y' with constant 1.
    public Map<Variable, Constant> asMap() {
        // TODO
        return null;
    }

    @Override
    // Returns a 'VariableSet' view of 'this'.
    public VariableSet getSetView() {
        // TODO
        return null;
    }
}
