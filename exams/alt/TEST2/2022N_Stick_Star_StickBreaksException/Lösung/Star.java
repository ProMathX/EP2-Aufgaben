import java.util.NoSuchElementException;

/**
 * Leaf node of a mobile. The actual decoration of a mobile.
 * A {@code Star} has a specified weight, that can not be changed after
 * initialisation. {@code Star} implements {@link Decoration}.
 */
//
// TODO: Complete the methods in 'Star'.
//       You can define further classes and methods for the implementation.
//       You may use the Java-Collection framework.
//
public class Star implements Decoration // TODO: uncomment clause.
{

    //TODO: define missing parts of the class.
    private final int weight;
    /**
     * Initializes {@code this} with its weight.
     *
     * @param weight the weight of this star, {@code weight > 0}.
     */
    public Star(int weight) {
        this.weight=weight;
        // TODO: implement constructor.
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    /**
     * Returns a readable representation of {@code this} with the
     * symbol '*' followed by the weight of this star.
     *
     * @return a readable representation of {@code this}.
     */
    @Override
    public String toString() {

        // TODO: implement method.
        return "*"+this.weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // if (obj instanceof Star o) {    // ez nem kell, mert a Decoration-ben már meg van határozva, hogy csak akkor egyenlő két díszítés, ha ugyanaz a példány
        //     return weight == o.weight;
        // }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(weight);
    }

    @Override
    public StickSet getStickSetView() {
        return new StickSet() {


            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean contains(Stick element) {
                return false;
            }
        };
    }

    @Override
    public StarIterator iterator() {
        return new StarIterator() {
            private boolean hasnext=true;

            @Override
            public boolean hasNext() {
                return hasnext;
            }

            @Override
            public Star next() {
                if(!hasnext){
                    throw new NoSuchElementException("no star element!");
                }
                hasnext=false;
                return Star.this;
            }
        };
    }
}

// TODO: define additional classes if needed (either here or in a separate file).
