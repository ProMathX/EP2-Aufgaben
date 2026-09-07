/**
 * Represents the element 'Hydrogenium' with the symbol `H`.
 */
public class Hydrogenium implements Element {

    public String toString() {
        return "H";
    }

    @Override
    public int hashCode() {
        return "H".hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj != null && obj.getClass() == Hydrogenium.class);
    }
}
