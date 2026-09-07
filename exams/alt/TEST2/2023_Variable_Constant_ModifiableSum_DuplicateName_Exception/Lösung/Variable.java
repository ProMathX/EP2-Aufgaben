import java.util.*;

// Represents a variable. 'Variable' implements 'Expression'.
// Each variable is uniquely identified by its
// instance. Two variables are considered equal only if they have the same identity (regardless
// of their name).
//
public class Variable implements Expression
{

    private final String name;

    public Variable(String name) {
        this.name=name;
        // TODO

    }

    @Override
    // Evaluates this expression using the provided variable-value mapping.
    // If the map contains an entry for this variable, we return the associated value, else the variable itself (this)
    // is returned.
    // Precondition: map != null.
    public Expression evaluate(HashMap<Variable, Constant> map) {
        // TODO
        if(map.containsKey(this)){   // vagy: if(map.keySet().contains(this)
            return map.get(this);
        }
        return this;
    }

    @Override
    // Returns the coefficient of the specified variable in the expression. If the variable is equal to 'this', 1 is
    // returned, else 0,
    // Precondition: variable != null.s
    public Constant coefficientOf(Variable variable) {
        // TODO
        if(variable.equals(this)){
            return new Constant(1);
        }
        return new Constant(0);
    }

    @Override
    // Returns the sum of all constants in the expression. Since there are no constants in this expression, always 0
    // is returned.
    public Constant getConstant() {
        // TODO
        return new Constant(0);
    }

    public String getName() {
        return name;
    }

    @Override
    // Returns a map that associates each variable in this expression with its coefficient.
    // For example, for the expression x + y + x + 3 the map has two mappings, associating variable
    // 'x' with constant 2 and variable 'y' with constant 1.
    public Map<Variable, Constant> asMap() {
        // TODO
        HashMap<Variable, Constant> map = new HashMap<>();
        map.put(this, new Constant(1));
        return map;

        // vagy: return new HashMap<>(Map.of(this, new Constant(1)));
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    // Returns a 'VariableSet' view of 'this'.
    public VariableSet getSetView() {
        // TODO
        return new VariableSet() {
            @Override
            public boolean contains(Variable variable) {
                return variable.equals(Variable.this);
            }

            @Override
            public VariableIterator iterator() {
                return new VariableIterator() {

                    private boolean hasnext=true;
                    @Override
                    public boolean hasNext() {
                        return hasnext;
                    }

                    @Override
                    public Variable next() {
                        if(!hasnext){
                            throw new NoSuchElementException("no more variables!");
                        }
                        hasnext=false;
                        return Variable.this;
                    }
                };
            }
        };
    }
}
