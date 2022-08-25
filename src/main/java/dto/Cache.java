package dto;

import exception.NotFoundException;
import exception.StorageFullException;
import storage.Storage;
import strategy.EvictionStrategy;

public class Cache<Key, Value> {

    public Storage<Key, Value> getStorage() {
        return storage;
    }

    private final Storage<Key, Value> storage;

    private final EvictionStrategy<Key> evictionStrategy;

    public Cache(EvictionStrategy<Key> strategy, Storage<Key, Value> storage) {
        this.storage = storage;
        this.evictionStrategy = strategy;
    }

    public Value getElementFromCache(Key key) throws StorageFullException {
        //get element from storage
        Value value = null;
        try {
            value = storage.get(key);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        //pass element from storage to eviction strategy to modify key order
        evictionStrategy.modifyKeyOrder(key);
        return value;
    }

    public void setElementInCache(Key key, Value value) {
        try {
            //put element in storage
            storage.add(key, value);
            //pass element from storage to eviction strategy to modify key order
            evictionStrategy.modifyKeyOrder(key);
        } catch (StorageFullException storageFullException) {
            Key evictedKey = evictionStrategy.evictKey();
            storage.remove(evictedKey);
            setElementInCache(key, value);
        }
    }

}
