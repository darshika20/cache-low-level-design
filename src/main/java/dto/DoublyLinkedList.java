package dto;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int capacity;

    public DoublyLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        head.setNext(tail);
        tail.setPrev(head);
        capacity = 0;
    }

    public void addFirst(Node node) {
        Node temp = head.getNext();
        node.setNext(temp);
        temp.setPrev(node);
        head.setNext(node);
        node.setPrev(head);
        capacity++;
    }

    public Node removeLast() {
        if (capacity == 0) {
            throw new RuntimeException("List is empty");
        }
        Node node = tail.getPrev();
        tail.setPrev(node.getPrev());
        node.getPrev().setNext(tail);
        return node;
    }

    public void removeNode(Node node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }
}
