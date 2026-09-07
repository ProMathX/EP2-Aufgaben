import java.util.Objects;

/**
 * This class represents a free variable which can take on integer values.
 * PLEASE DO NOT CHANGE THIS FILE.
 */
public class IntVar {
    private final String name;

    /**
     * Initializes this variable with a specified name.
     * @param name, the name of this variable, {@code name != null}.
     */
    public IntVar(String name) {

        this.name = name;
    }

    /**
     * Returns the name of this variable.
     * @return the name of this variable.
     */
    public String getName() {

        return name;
    }

    /**
     * Returns a readable representation of {@code this}, which is the name of this variable.
     * @return a readable representation of {@code this}.
     */
    public String toString() {

        return name;
    }

    /**
     * Compares {@code this} and {@code o} for equality.
     *
     * @param o the object to compare with
     * @return {@code true} if {@code o} has the same name (via {@code getName()});
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntVar intVar)) return false;
        return Objects.equals(name, intVar.name);
    }

    /**
     * Returns the hash code of {@code this}.
     *
     * @return the hash code of {@code this}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
