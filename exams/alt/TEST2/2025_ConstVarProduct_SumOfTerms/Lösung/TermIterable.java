/**
 * An object providing an iterator over its {@code SquareFreeTerm} elements.
 */
public interface TermIterable extends Iterable<SquareFreeTerm> {

    /**
     * Returns an iterator over elements of type {@code SquareFreeTerm}.
     * @return an iterator over elements of type {@code SquareFreeTerm}.
     */
    TermIterator iterator();
}
