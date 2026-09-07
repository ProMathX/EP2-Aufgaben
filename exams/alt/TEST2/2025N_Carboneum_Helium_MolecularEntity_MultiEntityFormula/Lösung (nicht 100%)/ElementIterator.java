import java.util.Iterator;

/**
 * An iterator over elements of type {@code Element}.
 * PLEASE DO NOT CHANGE THIS FILE!
 */
public interface ElementIterator extends Iterator<Element> {

    @Override
    /**
     * Returns {@code true} if the iteration has more elements.
     */
    boolean hasNext();

    @Override
    /**
     * Returns the next element of the iteration.
     * @return the next element of the iteration.
     * @throws java.util.NoSuchElementException if the iteration has no more element. There is no
     * specified detail message.
     */
    Element next();
}