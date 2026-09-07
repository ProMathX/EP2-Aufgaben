import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Represents the element 'Carboneum' with the symbol `C`.
 */
public class Carboneum implements Element, SingleEntityFormula
{


    @Override
    public HashMap<Element, Integer> getMap() {
        return Carboneum.C.getMap();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj != null && obj.getClass() == Carboneum.class);
    }

    @Override
    public int hashCode() {
        return "C".hashCode();
    }

    @Override
    public String toString() {
        return "C";
    }

    @Override
    public ElementSet getElementSetView() {
        return new ElementSet() {
            @Override
            public boolean contains(Element e) {
                return e.equals("C");
            }

            @Override
            public ElementIterator iterator() {
                return new ElementIterator() {

                    boolean hasnext=true;

                    @Override
                    public boolean hasNext() {
                        return hasnext;
                    }

                    @Override
                    public Element next() {
                        if(!hasnext){
                            throw new NoSuchElementException();
                        }
                        hasnext=false;
                        return this.next();
                    }
                };
            }
        };
    }

    //TODO: implement missing parts of this class.
}
