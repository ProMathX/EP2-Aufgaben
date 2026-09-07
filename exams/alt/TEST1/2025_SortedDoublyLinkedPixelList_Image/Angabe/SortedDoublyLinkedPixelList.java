/**
 * This doubly linked list stores pixels as elements. The elements in this list are ordered
 * according to the pixel's position, i.e., by the natural order defined in the {@code Position} class
 * via its {@code compareTo} method. For any two pixels in this list with positions p1 and p2,
 * it holds that: p1.compareTo(p2) != 0.
 * There is no limit on the number of elements stored in this list.
 */
//
// TODO: Complete the methods in 'SortedDoublyLinkedPixelList'.
//       You can define further classes and methods for the implementation of the
//       binary search tree if needed.
//       Do NOT use the Java-Collection framework in 'SortedDoublyLinkedPixelList' or in any other
//       class.
//
public class SortedDoublyLinkedPixelList {
    //TODO: additional variables, constructors and methods must be private.

    /**
     * Initializes this instance as an empty list.
     */
    public SortedDoublyLinkedPixelList() {
        //TODO: implement method.
    }

    /**
     * Initializes this list as a copy of the specified {@code list}. This list has the
     * same entries as {@code list}. Subsequent modifications to either list will
     * not affect the other.
     * (Pixels themselves need not be duplicated due to their immutability.)
     *
     * @param list the list from which entries are copied to this new list, list != null.
     */
    public SortedDoublyLinkedPixelList(SortedDoublyLinkedPixelList list) {
        //TODO: implement method.

    }


    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list.
     */
    public int size() {
        //TODO: implement method.
        return 0;
    }

    /**
     * Inserts a new pixel into this list in its sorted position. If a pixel with the same position
     * already exists in this list, its grey level is replaced by the new pixel's grey level and
     * the old grey level is returned.
     * Otherwise, the new pixel is inserted and {@code null} is returned.
     *
     * @param pixel the pixel to be inserted into this list; {@code pixel != null}.
     * @return the old grey level if a pixel with the same position already existed in the list,
     * or {@code null} otherwise.
     */
    public GreyLevel insert(Pixel pixel) {
        //TODO: implement method.
        return null;
    }

    /**
     * Removes and returns the first pixel of the list
     * (the one with the "smallest" position).
     *
     * @return the first {@code Pixel} in the list, or {@code null} if the list is empty.
     */
    public Pixel removeFirst() {
        //TODO: implement method.
        return null;

    }

    /**
     * Returns the grey level of the pixel with the specified position.
     *
     * Since the list is sorted by position, this method only traverses as far as needed
     * and stops early if it determines the target cannot be further down the list.
     *
     * @param position the position of the desired pixel; {@code position != null}.
     * @return the grey level of the pixel with the specified position, or {@code null}
     *      if no such pixel exists in this list.
     */
    public GreyLevel getGreyLevel(Position position) {
        return null;
        //TODO: implement method.
    }
}

// TODO: define further classes, if needed (either here or in a separate file).
