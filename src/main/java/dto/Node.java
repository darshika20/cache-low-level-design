package dto;


public class Node<Key> {

    private Key key;
    private Node<Key> next;
    private Node<Key> prev;

    public Node(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
