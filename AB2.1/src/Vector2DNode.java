/**
 * This class represents a {@link Vector2DSinglyLinkedList} node
 */
public class Vector2DNode {

    private Vector2D value;
    private Vector2DNode next;

    public Vector2DNode(Vector2D value, Vector2DNode next) {
        this.value = value;
        this.next = next;
    }

    public Vector2DNode(Vector2D value) {
        this(value, null);
    }

    public Vector2DNode getNext() {
        return next;
    }

    public void setNext(Vector2DNode next) {
        this.next = next;
    }

    public Vector2D getValue() {
        return value;
    }

}
