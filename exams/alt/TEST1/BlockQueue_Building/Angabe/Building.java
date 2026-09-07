/**
 * A building that is constructed by connecting multiple simpler buildings. The simplest
 * building from which more complex buildings can be constructed is made of one single block.
 * 'Building' uses a queue for storing its blocks.
 */
//
// TODO: Complete the methods in 'Building'.
//       You can define further classes and methods if needed.
//       Do NOT use the Java-Collection framework in 'Building' or any other class.
//
public class Building {


    /**
     * Initializes this building with a single block.
     *
     * @param block the block that is wrapped as a 'Building' object, block != null.
     */
    public Building(Block block) {
    }


    /**
     * Returns a new building that consists of blocks of 'this' and 'building'. If there is a
     * block in 'building' that can be assembled with a block in 'this' (that is, 'assemble' in
     * 'Block' returns a corresponding block), this pair of blocks is assembled to become one
     * block in the new building. If there are multiple such pairs, each pair is assembled.
     * Consequently, every building has at most one block of a particular width.
     * The Building 'this' and 'building' should not be changed by this method.
     *
     * @param building the building to be assembled with 'this' to form a new building,
     *                 building != null.
     */
    public Building connectWith(Building building) {
        //TODO: implement method.
        return null;
    }

    /**
     * Returns a new queue with all blocks of this building. There is no specified order.
     * Changes in the returned queue will not affect 'this' and vice versa.
     *
     * @return a new queue with all blocks of this building.
     */
    public BlockQueue getQueue() {
        //TODO: implement method.
        return null;
    }

    /**
     * Returns a string representation of this building with all its blocks, enclosed in square
     * brackets ("[]"). Adjacent elements are separated by ','.
     * Example: "[[3x4],[2x5],[5x5]]"
     * The order in which the blocks appear in the representation is not specified.
     *
     * @return the string representation of this building.
     */
    public String toString() {
        //TODO: implement method.
        return null;
    }
}

// TODO: define further classes, if needed (either here or in a separate file).
