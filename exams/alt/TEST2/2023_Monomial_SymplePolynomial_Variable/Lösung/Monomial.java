import java.util.*;

// This class represents a product of variables, like x*x*y*z. The coefficient of
// a monomial is considered to be 1.
//
public class Monomial implements Polynomial // TODO: activate clause.
{

    // TODO: define missing parts of this class (including getters as needed).
    private Variable[] variables;


    // Initializes 'this' with the specified variables. Variables can occur more often than once
    // in the specified array. (The number of occurrences corresponds to the exponent of the
    // variable.) If variables.length == 0, this monomial corresponds to the constant 1.
    // Precondition: variables != null.
    public Monomial(Variable[] variables) {
        //TODO: implement constructor.
        // 'vars' tömb rendezése a változók nevei szerint
        Arrays.sort(variables, (a, b) -> a.getName().compareTo(b.getName()));
        //Arrays.sort(variables, Comparator.comparing(Variable::getName));

        this.variables=variables;
    }

    // Evaluates this polynomial using the provided 'value' for 'v'. For example,
    // the result of p.evaluate(x, 2) if 'p' is the polynomial x*x*x*y is the polynomial 8*y.
    // (For simplicity, we assume that 'value' is a positive integer.)
    // Precondition: v != null && value > 0.
    @Override
    public Polynomial evaluate(Variable v, int value) {
        int evaluated=0;
        Variable set[]=new Variable[this.variables.length];
        for (int i = 0; i < this.variables.length; i++) {
            if(this.variables[i].equals(v)){
                evaluated++;
            }else{
                set[i-evaluated]=this.variables[i];
            }
        }
        if(evaluated==0){
            return this;
        }
        Variable setfinal[]=new Variable[this.variables.length-evaluated];
        for (int i = 0; i < setfinal.length; i++) {
            setfinal[i]=set[i];
        }
        return new SimplePolynomial(new Monomial(setfinal), (int)Math.pow(value, evaluated));
    }


    @Override
    public VariableSet getVariableSetView() {
        return new VariableSet() {
            @Override
            public boolean contains(Variable variable) {
                for(Variable vari : variables){
                    if(variable.equals(vari)){
                        return true;
                    }
                }
                return false;
            }
        };
    }

    // Returns the coefficient of the specified monomial in this polynomial.
    // Precondition: m != null.
    public int getCoefficientOf(Monomial m) {

        return m.equals(this) ? 1 : 0;
    }

    @Override
    public HashMap<Monomial, Integer> asMap() {
        HashMap<Monomial,Integer> toReturn = new HashMap<>();
        toReturn.put(this,1);
        return toReturn;

//        return new HashMap<Monomial, Integer>() {
//            {
//                put(Monomial.this, 1);
//            }
//        };
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(variables);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Monomial other){
            if(this.variables.length!=other.variables.length) {
                return false;
            }
            for (int i = 0; i < this.variables.length; i++) {
                if(!this.variables[i].equals(other.variables[i])){
                    return false;
                }

            }
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder toReturn=new StringBuilder();
        for(Variable vari : variables){
            if(!toReturn.isEmpty()){
                toReturn.append("*");
            }
            toReturn.append(vari);
        }
        return toReturn.toString();
    }

    // @Override
    // The iterator of this class iterates over only one element.
    // See examples in 'PraxisTest2.java'.
    public MonomialIterator iterator() {

        //TODO: implement method.
        return new MonomialIterator() {

            private boolean next=true;
            @Override
            public boolean hasNext() {
                return next;
            }

            @Override
            public Monomial next() {
                if(!hasNext()){
                    throw new NoSuchElementException("no more monomials!");
                }
                next=false;
                return Monomial.this;
            }
        };
    }

}
