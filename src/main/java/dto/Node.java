package dto;

public class Node {

    private String key;
    private String value;
    private Node next;
    private Node prev;

    public String getValue() {
        return value;
    }

    public void setValue(String val) {
        this.value = val;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
