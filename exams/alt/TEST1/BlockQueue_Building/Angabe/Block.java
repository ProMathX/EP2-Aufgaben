/**
 * This class represents a building block (for simplicity it has only two dimensions).
 * PLEASE DO NOT CHANGE THIS FILE.
 */
public class Block {

    private final int width, height;

    /**
     * Initializes this block with its width and height.
     *
     * @param width  the width of this block, width >= 0.
     * @param height the height of this block, height >= 0.
     */
    public Block(int width, int height) {

        this.width = width;
        this.height = height;
    }

    /**
     * Returns a new block resulting from assembling 'this' and 'b'.
     * The new block has the same width as 'this' and its height
     * equals the sum of the heights of 'this' and of 'b'.
     * Blocks can only be assembled if they share the same width.
     * If the width of this block differs from the width of 'b' the
     * method returns 'null'.
     *
     * @param b another block, b != null.
     * @return a new block resulting from assembling 'this' and 'b' or 'null'
     * if 'this' and 'b' can not be assembled.
     */
    public Block assemble(Block b) {

        if (b.width == width) {
            return new Block(width, height + b.height);
        }
        return null;
    }

    /**
     * Returns a string representation of this block in the form [widthxheight],
     * for example "[5x7]".
     *
     * @return a string representation of this block.
     */
    @Override
    public String toString() {
        return "[" + width + "x" + height + "]";
    }
}
