import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Singly linked list with elements of type {@link Vector2D}.
 *
 * <p>The list is implemented as a recursive data structure with one node
 * for each element in the list.</p>
 */
public class Vector2DSinglyLinkedList {

    private Vector2DNode root;
    private int size;

    /**
     * Creates an empty list.
     */
    public Vector2DSinglyLinkedList() {

    }

    /**
     * Creates a new list that is a copy of the specified list. Later changes of
     * {@code this} (like adding or removing elements) will not affect {@code list} and
     * vice versa.
     *
     * <p>The new list contains the same elements and in the same order
     * as {@code list}.</p>
     *
     * @param list the list to copy; {@code list != null}
     */
    public Vector2DSinglyLinkedList(Vector2DSinglyLinkedList list) {
        this.root = new Vector2DNode(list.root.getValue(), null);

        Vector2DNode currentNew = this.root;
        Vector2DNode currentOld = list.root.getNext();

        while (currentOld != null) {
            Vector2DNode newNode = new Vector2DNode(currentOld.getValue(), null);
            currentNew.setNext(newNode);

            currentNew = newNode;
            currentOld = currentOld.getNext();
        }

        this.size = list.size;
    }

    /**
     * Adds an element at the head of the list.
     *
     * @param v the element to add
     */
    public void addFirst(Vector2D v) {
        root = new Vector2DNode(v, root);
        size++;
    }

    /**
     * Adds an element at the end of the list.
     *
     * @param v the element to add
     */
    public void addLast(Vector2D v) {
        if (root == null) {
            addFirst(v);
            return;
        }

        Vector2DNode current = root;
        while (current != null) {
            if (current.getNext() == null) {
                current.setNext(new Vector2DNode(v));
                size++;
                break;
            }
            current = current.getNext();
        }
    }

    /**
     * Adds an element at the specified position in the list.
     *
     * <p>If {@code index == 0}, the element is inserted at the head of the list.
     * If {@code index == size()}, the element is inserted at the end of the list.
     * All elements currently stored at positions greater than or equal to
     * {@code index} are shifted by one position toward the end of the list.</p>
     *
     * @param index the position at which the element is to be inserted;
     *              {@code 0 <= index <= size()}
     * @param v     the element to add
     */
    public void add(int index, Vector2D v) {
        if (index == 0) {
            addFirst(v);
            return;
        }
        if (index == size()) {
            addLast(v);
            return;
        }

        Vector2DNode node = root;
        for (int i = 0; i < index-1; i++) {
            node = node.getNext();
        }
        node.setNext(new Vector2DNode(v, node.getNext()));
        size++;
    }

    /**
     * Removes and returns the head element of the list.
     *
     * <p>This method removes the first element of the list.</p>
     *
     * @return the first element in the list, or {@code null} if {@code size() == 0}
     */
    public Vector2D pollFirst() {
        if (size() == 0) {
            return null;
        }
        Vector2D value = root.getValue();

        root = root.getNext();
        size--;

        return value;
    }

    /**
     * Removes and returns the last element of the list.
     *
     * <p>This method removes the last element of the list.</p>
     *
     * @return the last element in the list, or {@code null} if {@code size() == 0}
     */
    public Vector2D pollLast() {
        if (size() == 0) {
            return null;
        }

        Vector2D value;

        if (root.getNext() == null) {
            value = root.getValue();
            root = null;
            size--;
            return value;
        }

        Vector2DNode node = root.getNext();
        Vector2DNode previous = root;

        do {
            value = node.getValue();
            if (node.getNext() == null) {
                break;
            }
            previous = node;
            node = node.getNext();
        } while (node != null);

        if (previous != null) {
            previous.setNext(null);
        }

        size--;
        return value;
    }

    /**
     * Returns the head element of the list without removing it.
     *
     * <p>The list remains unchanged after this operation.</p>
     *
     * @return the first element in the list, or {@code null} if {@code size() == 0}
     */
    public Vector2D peekFirst() {
        if (size() == 0) {
            return null;
        }
        return root.getValue();
    }

    /**
     * Returns the last element of the list without removing it.
     *
     * <p>The list remains unchanged after this operation.</p>
     *
     * @return the last element in the list, or {@code null} if {@code size() == 0}
     */
    public Vector2D peekLast() {
        if (size() == 0) {
            return null;
        }

        Vector2DNode node = root;

        while (node.getNext() != null) {
            node = node.getNext();
        }

        return node.getValue();
    }

    /**
     * Returns whether this list contains an element equal to the specified element.
     *
     * <p>The list is searched from head to tail. Equality is determined
     * using {@code equals}.</p>
     *
     * @param v the element to search for
     * @return {@code true} if this list contains an element equal to {@code v},
     * {@code false} otherwise
     */
    public boolean contains(Vector2D v) {
        if (root.getValue() == v) {
            return true;
        }

        Vector2DNode node = root;

        while (node.getNext() != null) {
            node = node.getNext();
            if (node.getValue() == v) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the element at the specified position in the list.
     *
     * <p>The first element has index {@code 0}.</p>
     *
     * @param index the index of the element to return;
     *              {@code 0 <= index < size()}
     * @return the element at the specified position
     */
    public Vector2D get(int index) {
        Vector2DNode node = root;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node.getValue();
    }

    /**
     * Removes and returns the element at the specified position in the list.
     *
     * <p>All elements following the removed element are shifted by one position
     * toward the head of the list.</p>
     *
     * @param index the index of the element to remove;
     *              {@code 0 <= index < size()}
     * @return the removed element
     */
    public Vector2D remove(int index) {
        if (index == 0) {
            Vector2D value = root.getValue();
            root = null;
            size--;
            return value;
        }

        Vector2DNode node = root.getNext();
        Vector2DNode previous = root;
        for (int i = 1; i < index; i++) {
            previous = node;
            node = node.getNext();
        }

        Vector2D value = node.getValue();
        previous.setNext(node.getNext());
        size--;
        return value;
    }

    /**
     * Returns whether this list contains no elements.
     *
     * @return {@code true} if {@code size() == 0}, {@code false} otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements currently stored in the list.
     *
     * @return the current size of the list
     */
    public int size() {
        return size;
    }


}

