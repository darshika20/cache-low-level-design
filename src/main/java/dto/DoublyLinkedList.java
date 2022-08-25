package dto;

public class DoublyLinkedList<Key> {

    private Node<Key> head;
    private Node<Key> tail;

    public DoublyLinkedList(Key key) {
        this.head = new Node<>(key);
        this.tail = new Node<>(key);
        head.setNext(tail);
        tail.setPrev(head);
    }

    public void addFirst(Node<Key> node) {
        Node<Key> temp = head.getNext();
        node.setNext(temp);
        temp.setPrev(node);
        head.setNext(node);
        node.setPrev(head);
    }

    public Node<Key> removeLast() {
        if (tail.getPrev() == head) {
            throw new RuntimeException("List is empty");
        }
        Node<Key> node = tail.getPrev();
        tail.setPrev(node.getPrev());
        node.getPrev().setNext(tail);
        return node;
    }

    public void removeNode(Node<Key> node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }
}
