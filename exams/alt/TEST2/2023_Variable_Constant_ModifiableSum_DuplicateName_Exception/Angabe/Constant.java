import java.util.*;

// This class represents an integer constant (no objects of class 'Variable' are contained
// in this expression).
//
public class Constant implements Expression {

    // Initializes 'this' with the specified value.
    public Constant(int value) {
        // TODO
    }

    @Override
    // Evaluates the constant with the provided variable-value mapping.
    // Since a constant does not depend on variables, it returns itself.
    public Expression evaluate(HashMap<Variable, Constant> map) {
        return this;
    }

    // Returns a new 'Constant' object representing the sum of this constant and another constant.
    public Constant sumWith(Constant c) {
        // TODO
        return null;
    }

    @Override
    // Since a constant does not depend on variables, the coefficient of the
    // specified variable is always 0.
    public Constant coefficientOf(Variable variable) {
        // TODO
        return null;
    }

    @Override
    // Returns the sum of all constants in the constant expression.
    // Since 'this' is a constant itself, it returns itself.
    public Constant getConstant() {
        return this;
    }

    @Override
    // Since a constant does not depend on variables, an empty map is returned.
    public Map<Variable, Constant> asMap() {
        return new HashMap<>();
    }


    // Returns the value of this constant.
    public int intValue() {
        // TODO
        return 0;
    }

    @Override
    // Returns 'true' only if this constant is equal to the given object.
    // Two constants are considered equal if they have the same value.
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public VariableSet getSetView() {
        // TODO
        return null;

    }
}
