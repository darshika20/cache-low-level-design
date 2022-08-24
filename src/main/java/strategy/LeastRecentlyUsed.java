package strategy;

import dto.Cache;
import dto.DoublyLinkedList;
import dto.Node;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsed implements EvictionStrategy{

    private Map<String, Node> keyVsNode;
    private DoublyLinkedList doublyLinkedList;


    public LeastRecentlyUsed() {
        keyVsNode = new HashMap<>();
        doublyLinkedList = new DoublyLinkedList();
    }

    @Override
    public void modifyCache(String key, String value, Cache cache) {
        if (cache.getCacheMap().containsKey(key)) {
            //update the value of the element in the double linked list
            keyVsNode.get(key).setValue(value);
            //delete that node from double linked list
            doublyLinkedList.removeNode(keyVsNode.get(key));
            //add this node to the start of linked list
            doublyLinkedList.addFirst(keyVsNode.get(key));
            return;
            //return
        } else if (cache.getCacheMap().size() == cache.getCapacity()) {
            //delete the last element from double linked list
            Node node = doublyLinkedList.removeLast();
            //delete the last key from keyVsNode map
            keyVsNode.remove(node.getKey());
            //delete thr element from cache
            cache.getCacheMap().remove(node.getKey());
        }
        //insert the new element at the head of the linked list
        Node node = new Node();
        node.setKey(key);
        node.setValue(value);
        doublyLinkedList.addFirst(node);
        //insert the new key in keyVsNode map
        keyVsNode.put(key, node);
    }
}
