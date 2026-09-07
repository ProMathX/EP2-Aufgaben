import java.time.temporal.ValueRange;
import java.util.*;

// This class represents a sum of two expressions. Since the two expressions can themselves be
// objects of 'ModifiableSum', we naturally get tree-like structures, where objects of 'Variable'
// and 'Constant' form the leafs of the tree. The implementation of this class can, but need not
// be based on a tree structure.
//
public class ModifiableSum implements Expression {

    // Initializes 'this' with the two operands of the sum. If 'e1' and 'e2' contain at least two
    // variables with the same name but different identities, a 'DuplicateNameException' is thrown.
    // Precondition: 'e1' and 'e2' are not null.
    public ModifiableSum(Expression e1, Expression e2) throws DuplicateNameException {

    }


    // This method adds 'expression' to 'this'.
    // If 'expression' contains a variable with the same name but different identity than
    // a variable in 'this', a 'DuplicateNameException' is thrown.
    // Precondition: other != null.
    public void add(Expression e) throws DuplicateNameException {

    }

    @Override
    // Evaluates this expression using the provided variable-value mapping. For example,
    // if 'map' associates variable x with constant 2 and variable y with constant 3, the
    // expression x + y is evaluated to the expression 2 + 3. If 'map' contains the mapping
    // for y, but no mapping for x, then x + y is evaluated to x + 3. If there is neither
    // a mapping for x nor for y, then x + y is evaluated to x + y.
    // Precondition: map != null.
    public Expression evaluate(HashMap<Variable, Constant> map) {
        // TODO
        return null;
    }

    @Override
    // Returns the coefficient of the specified variable in the expression. For example,
    // in the expression x + y + x + 3 the variable 'x' has a coefficient of 2, while 'y'
    // has the coefficient 1 (and variables that are not occurring in the expression have a
    // coefficient of 0).
    // Precondition: variable != null.
    public Constant coefficientOf(Variable variable) {
        // TODO
        return null;
    }

    @Override
    // Returns the sum of all constants in the expression. For example,
    // for the expression x + y + x + 3 the method returns 3. For the expression 3 + x + 4
    // the method returns 7.
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

//TODO: define additional classes as needed, either here or in a separate file.