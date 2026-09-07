/**
 * Iterable wrapper node used for pre-order traversal of a
 * {@link PhysicalPhysicalTreeMap}.
 *
 * <p>This class wraps a {@link PhysicalPhysicalTreeMapNode} so that it can
 * be processed by a {@link PhysicalTreeIterator}.</p>
 *
 * <p>The traversal visits the wrapped node first, then the left subtree,
 * and finally the right subtree.</p>
 *
 * <p>The traversal is performed lazily. No additional data structure
 * containing all keys is created in advance.</p>
 */
public class PhysicalPhysicalTreeMapPreOrderIterableNode
        implements PhysicalIterableTreeNode {

    //TODO: all variables are private.
    private PhysicalPhysicalTreeMapNode node;

    /**
     * Creates a new iterable wrapper for the specified tree map node.
     *
     * @param node the wrapped tree map node; {@code node != null}
     */
    public PhysicalPhysicalTreeMapPreOrderIterableNode(PhysicalPhysicalTreeMapNode node) {
        this.node = node;
    }

    /**
     * Updates the traversal state at this node and may return the next
     * key stored in the traversal.
     *
     * <p>If {@code next == false}, the wrapped node is scheduled to
     * return its key immediately and the remaining traversal state
     * is inserted into the iterator.</p>
     *
     * <p>If {@code next == true}, the key of the wrapped node is
     * returned.</p>
     *
     * @param iterator the iterator whose traversal state may be extended;
     *                 {@code iterator != null}
     * @param next indicates whether this is a continuation step
     *             of a previously scheduled node
     * @return the next key in pre-order traversal,
     *         or {@code null} if this call only updates the traversal state
     */
    @Override
    public Physical iter(PhysicalTreeIterator iterator, boolean next) {
        if (!next) {

            if (node.getRight() != null) {
                new PhysicalPhysicalTreeMapPreOrderIterableNode(node.getRight()).iter(iterator, false);
            }

            if (node.getLeft() != null) {
                new PhysicalPhysicalTreeMapPreOrderIterableNode(node.getLeft()).iter(iterator, false);
            }

            new PhysicalTreeIterator(this, iterator);

            return iter(iterator, true);
        } else {
            return node.getKey();
        }

    }

}