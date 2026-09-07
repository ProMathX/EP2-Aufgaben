import java.util.NoSuchElementException;

/**
 * An iterator implementation that returns only one specified element.
 * This file may be changed (if needed).
 */
class SingleTermIterator implements TermIterator {

    private SquareFreeTerm t;
    private boolean consumed = false;

    /**
     * Constructs this iterator with the specified single element.
     *
     * @param t the only element of this iterator.
     */
    public SingleTermIterator(SquareFreeTerm t) {
        this.t = t;
    }

    @Override
    public boolean hasNext() {
        return !consumed;
    }

    @Override
    public SquareFreeTerm next() {
        if (consumed) throw new NoSuchElementException();
        consumed = true;
        return t;
    }
}