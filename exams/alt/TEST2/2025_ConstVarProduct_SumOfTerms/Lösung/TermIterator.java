import java.util.Iterator;

/**
 * An iterator over elements of type {@code SquareFreeTerm}.
 */
public interface TermIterator extends Iterator<SquareFreeTerm> {

    /**
     * Returns {@code true} if the iteration has more elements.
     */
    @Override
    boolean hasNext();

    /**
     * Returns the next element of the iteration.
     * @return the next element of the iteration.
     * @throws java.util.NoSuchElementException if the iteration has no more element. There is no
     * specified detail message.
     */
    @Override
    SquareFreeTerm next();
}
