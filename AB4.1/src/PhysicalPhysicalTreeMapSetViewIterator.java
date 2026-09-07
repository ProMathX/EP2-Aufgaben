import java.util.Stack;

/**
 * Iterator over the keys of a {@link PhysicalPhysicalTreeMapSetView}.
 *
 * <p>This iterator traverses the underlying binary search tree in
 * in-order, producing the keys in ascending order according to the
 * comparator used by the backing tree map.</p>
 *
 * <p>The iterator uses an explicit {@link java.util.Stack} to store the
 * traversal state. No independent copy of all keys is created.</p>
 *
 * <p>The iterator is fail-fast. If the backing map is structurally modified
 * after this iterator has been created, {@code #next()} throws a
 * {@link ConcurrentModificationException}.</p>
 */
public class PhysicalPhysicalTreeMapSetViewIterator implements PhysicalIterator {

    private Stack<PhysicalPhysicalTreeMapNode> stack;
    private int[] modCounterBox;
    private int expectedModCount;

    /**
     * Creates a new iterator over the specified tree.
     *
     * <p>The iterator starts before the first key according to in-order traversal.
     * If {@code root} is an empty node, the iterator has no elements.</p>
     *
     * @param root the root node of the tree to traverse; {@code root != null}
     * @param modCounterBox shared modification counter of the backing map;
     *                      {@code modCounterBox != null}
     *                      and {@code modCounterBox.length >= 1}
     */
    public PhysicalPhysicalTreeMapSetViewIterator(
            PhysicalPhysicalTreeMapNode root,
            int[] modCounterBox) {

        this.stack = new Stack<>();
        this.modCounterBox = modCounterBox;
        this.expectedModCount = modCounterBox[0];

        pushLeftPath(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Physical next() {
        if (modCounterBox[0] != expectedModCount) {
            throw new ConcurrentModificationException(modCounterBox[0] - expectedModCount);
        }

        if (stack.isEmpty()) {
            return null;
        }

        PhysicalPhysicalTreeMapNode node = stack.pop();
        Physical result = node.getKey();

        pushLeftPath(node.getRight());
        return result;
    }

    private void pushLeftPath(PhysicalPhysicalTreeMapNode node) {
        while (!node.equals(PhysicalPhysicalTreeMapNodeEmpty.EMPTY)) {
            stack.push(node);
            node = node.getLeft();
        }
    }
}