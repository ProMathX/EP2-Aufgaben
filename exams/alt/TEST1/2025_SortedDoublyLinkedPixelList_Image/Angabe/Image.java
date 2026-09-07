/**
 * This class represents an image constructed as a grid of grey levels. The top-left of the image
 * has position (0, 0), with x increasing to the right and y increasing downward.
 * The image is represented by a {@link SortedDoublyLinkedPixelList} object holding only those pixels with
 * grey levels different from 0.
 * The region of the image is given by the upper left coordinates (0, 0) and lower right
 * coordinates (width - 1, height - 1).
 * All positions inside the image region with no mapping in {@link SortedDoublyLinkedPixelList} implicitly
 * have the lowest grey level of 0.
 */
//
// TODO: Complete the methods in 'Image'.
//       You can define further classes and methods if needed.
//       Do NOT use the Java-Collection framework in 'Image' or in any other class.
//
public class Image {



    //TODO: additional variables, constructors and methods must be private.

    /**
     * Constructs an Image from an array of strings.
     * Each string represents a row in the image. For every character in a row that is a valid grey
     * level, the constructor creates and stores the pixel with corresponding position and grey
     * level. The height and width of this image corresponds to the number of strings respectively
     * the length of the strings (each string must be of equal length).
     * Positions with a grey level of 0 are not stored in the list.
     *
     * @param rows an array of strings representing the image rows;
     *        {@code rows != null && rows.length > 0 && rows[0] != null} and all {@code rows[i]}
     *        are of equal length > 0.
     */
    public Image(String[] rows) {

        //TODO: implement constructor.
    }

    /**
     * Returns the width of the image.
     *
     * @return the width of the image.
     */
    public int width() {
        //TODO: implement method.
        return 0;
    }

    /**
     * Returns the height of the image.
     *
     * @return the height of the image.
     */
    public int height() {

        //TODO: implement method.
        return 0;
    }

    /**
     * Deletes all image columns to the left of the specified column index {@code x}.
     *
     * This method removes all pixels with positions in columns from 0 up to
     * (but not including) {@code x}. The remaining pixels are shifted leftward by
     * {@code x} columns so that the new leftmost column has index 0. The width of this image
     * will be reduced by the number of removed columns.
     *
     * @param x index of the first column that remains after deleting all columns with
     *          lower indexes.
     */
    public void deleteColumnsLeftOf(int x) {
        //TODO: implement method.
    }

    /**
     * Returns the image as an array of strings, where each string represents one row in the image.
     * Each position of one row is represented by the corresponding grey level character if
     * present, or a space character ' ' if no grey level is stored
     * (space corresponds to grey level 0).
     *
     * If width and height of this image are both zero, an empty array is returned (no rows).
     *
     * @return a string representing the image (as specified in the constructor of this class).
     */
    public String[] asArray() {
        return null;
    }
}

// TODO: define further classes, if needed (either here or in a separate file).
