import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Represents the element 'Helium' with the symbol `He`.
 */
public class Helium implements Element, SingleEntityFormula //TODO: uncomment clause.
{
    @Override


    public HashMap<Element, Integer> getMap() {
        return Helium.He.getMap();
    }

    @Override
    public String toString() {
        return "He";
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj != null && obj.getClass() == Helium.class);
    }

    @Override
    public int hashCode() {
        return "He".hashCode();
    }

    @Override
    public ElementSet getElementSetView() {
        return new ElementSet() {
            @Override
            public boolean contains(Element e) {
                return e.equals("He");
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
