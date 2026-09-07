/**
 * Represents the element 'Oxygenium' with the symbol `O`.
 */
public class Oxygenium implements Element {

    public String toString() {
        return "O";
    }

    @Override
    public int hashCode() {
        return "O".hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj != null && obj.getClass() == Oxygenium.class);
    }
}
