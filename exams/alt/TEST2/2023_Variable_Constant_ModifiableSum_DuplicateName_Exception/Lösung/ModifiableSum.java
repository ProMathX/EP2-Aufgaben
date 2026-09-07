import java.time.temporal.ValueRange;
import java.util.*;

// This class represents a sum of two expressions. Since the two expressions can themselves be
// objects of 'ModifiableSum', we naturally get tree-like structures, where objects of 'Variable'
// and 'Constant' form the leafs of the tree. The implementation of this class can, but need not
// be based on a tree structure.
//
public class ModifiableSum implements Expression {

    private final HashMap<Variable, Constant> varMap = new HashMap<>();
    private Constant constant = new Constant(0);


    // Initializes 'this' with the two operands of the sum. If 'e1' and 'e2' contain at least two
    // variables with the same name but different identities, a 'DuplicateNameException' is thrown.
    // Precondition: 'e1' and 'e2' are not null.
    public ModifiableSum(Expression e1, Expression e2) throws DuplicateNameException {
        VariableSet set1=e1.getSetView();
        VariableSet set2=e2.getSetView();
        for(Variable v1 : set1){
            for(Variable v2 : set2){
                if(v1.getName().equals(v2.getName()) && v1!=v2){
                    throw new DuplicateNameException(v1.getName());
                }
            }
        }
        this.add(e1);
        this.add(e2);
    }


    // This method adds 'expression' to 'this'.
    // If 'expression' contains a variable with the same name but different identity than
    // a variable in 'this', a 'DuplicateNameException' is thrown.
    // Precondition: other != null.
    public void add(Expression e) throws DuplicateNameException {
        VariableSet setE=e.getSetView();

        for(Variable v1 : varMap.keySet()){
            for(Variable v2 : setE){
                if(v1.getName().equals(v2.getName()) && v1!=v2){
                    throw new DuplicateNameException(v1.getName());
                }
            }
        }

//        if(e instanceof Constant x){
//            constant= new Constant(constant.getConstant().intValue()+x.intValue());
//        }
        for(Variable v : setE) {
            Constant coeff = e.coefficientOf(v);
            if(varMap.containsKey(v)){
                Constant newCoeff = varMap.get(v).sumWith(coeff);
                if(newCoeff.equals(new Constant(0))){
                    varMap.remove(v);
                }else{
                    varMap.put(v, newCoeff);
                }
            }else{
                varMap.put(v, coeff);
            }
        }
        constant = constant.sumWith(e.getConstant());

//        for(Variable v1 : varMap.keySet()){
//            if(v1.getName().equals(e) && v1!=e){
//                throw new DuplicateNameException(v1.getName());
//            }
//        }
    }

    @Override
    // Evaluates this expression using the provided variable-value mapping. For example,
    // if 'map' associates variable x with constant 2 and variable y with constant 3, the
    // expression x + y is evaluated to the expression 2 + 3. If 'map' contains the mapping
    // for y, but no mapping for x, then x + y is evaluated to x + 3. If there is neither
    // a mapping for x nor for y, then x + y is evaluated to x + y.
    // Precondition: map != null.
    public Expression evaluate(HashMap<Variable, Constant> map) {
//        HashMap<Variable, Constant> evalMap = new HashMap<>();
//        for(Variable v1 : map.keySet()){
//            int coeffVal=coefficientOf(v1).intValue();
//            if(coeffVal>1){
//                map.put(new Variable(coefficientOf(v1).toString()),new Constant(1));
//                map.remove(v1);
//            }
//        }
//        // TODO
//        return (Expression) map;

        ModifiableSum result = new ModifiableSum(new Constant(0), new Constant(0));

        for (Variable var : varMap.keySet()) {
            Constant coeff = varMap.get(var);

            // a paraméterként kapott 'map' is lehet több elemű!
            if (map.containsKey(var)) {
                Constant value = map.get(var);

                for (int i = 0; i < coeff.intValue(); i++) {
                    result.constant = result.constant.sumWith(value);
                }

            } else {
                result.varMap.put(var, coeff);
            }
        }
        result.constant = result.constant.sumWith(constant);

        return result;
    }

    @Override
    // Returns the coefficient of the specified variable in the expression. For example,
    // in the expression x + y + x + 3 the variable 'x' has a coefficient of 2, while 'y'
    // has the coefficient 1 (and variables that are not occurring in the expression have a
    // coefficient of 0).
    // Precondition: variable != null.
    public Constant coefficientOf(Variable variable) {
        // TODO
        if(varMap.containsKey(variable)){
            return varMap.get(variable);
        }
        return new Constant(0);
    }

    @Override
    // Returns the sum of all constants in the expression. For example,
    // for the expression x + y + x + 3 the method returns 3. For the expression 3 + x + 4
    // the method returns 7.
    public Constant getConstant() {
        // TODO
        if (constant == null)
            return new Constant(0);
        return constant;
    }

    @Override
    // Returns a map that associates each variable in this expression with its coefficient.
    // For example, for the expression x + y + x + 3 the map has two mappings, associating variable
    // 'x' with constant 2 and variable 'y' with constant 1.
    public Map<Variable, Constant> asMap() {
        // TODO
        return this.varMap;
    }

    // Returns a string representation of 'this' where each variable occurs at most once and there
    // is at most one constant. For example, a sum of 2, x, y, x  and -4 is represented by
    // "2x + y + -2" or "-2 + 2x + y". (The order of the terms is not specified. Coefficients of 1
    // are omitted in the representation.)
    @Override
    public String toString() {
        StringBuilder toReturn=new StringBuilder();
        if (!constant.equals(new Constant(0))){
            toReturn.append(constant);
        }
        for (Variable v1 : varMap.keySet()) {
            toReturn.append(" + ");
            if(coefficientOf(v1).intValue()>1){
                toReturn.append(coefficientOf(v1).intValue());
            }
            toReturn.append(v1.getName());
        }
        return toReturn.toString();
    }

    @Override
    // Returns a 'VariableSet' view of 'this'.
    public VariableSet getSetView() {
        // TODO
        return new VariableSet() {
            @Override
            public boolean contains(Variable variable) {
                return varMap.containsKey(variable);
            }

            @Override
            public VariableIterator iterator() {
                return new VariableIterator() {
                    int index=0;

                    @Override
                    public boolean hasNext() {
                        return index<varMap.size();
                    }

                    @Override
                    public Variable next() {
                        if(!hasNext()){
                            throw new NoSuchElementException("no more variables!");
                        }
                        return (Variable) varMap.keySet().toArray()[index++];
                    }
                };
            }
        };
    }
}

//TODO: define additional classes as needed, either here or in a separate file.