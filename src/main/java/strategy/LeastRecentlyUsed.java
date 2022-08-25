package strategy;

import dto.DoublyLinkedList;
import dto.Node;
import exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsed<Key> implements EvictionStrategy<Key>{

    private final Map<Key, Node> mapper;
    private final DoublyLinkedList<Key> doublyLinkedList;
    private final int capacity;


    public LeastRecentlyUsed(int capacity, Key key) {
        mapper = new HashMap<>();
        doublyLinkedList = new DoublyLinkedList<>(key);
        this.capacity = capacity;
    }

    /**
     * Find Key in mapper
     * If key exists, then delete the node from list and add it at first
     * Else, check if storage is full , then throw storage full exception
     * Else, create a new node and add it at first in list and add it to mapper
     * */
    @Override
    public void modifyKeyOrder(Key key) throws StorageFullException {

        if (mapper.containsKey(key)) {
            Node<Key> node = mapper.get(key);
            doublyLinkedList.removeNode(node);
            doublyLinkedList.addFirst(node);
        } else {
            if (capacity == mapper.size()) {
                throw new StorageFullException("Cache storage is full! Eviction of key is needed!");
            } else {
                Node<Key> node = new Node<>(key);
                doublyLinkedList.addFirst(node);
                mapper.put(key, node);
            }
        }
    }

    /**
     * Remove last node from list and mapper
     * */
    @Override
    public Key evictKey() {
        Node<Key> node = doublyLinkedList.removeLast();
        mapper.remove(node.getKey());
        return node.getKey();
    }
}
