package storage;

import exception.NotFoundException;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<Key, Value> implements Storage<Key, Value>{

    Map<Key, Value> keyValueMap;

    public HashMapStorage() {
        keyValueMap = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) {
        keyValueMap.put(key, value);
        System.out.println("Cache status -> " + keyValueMap);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if (!keyValueMap.containsKey(key)) {
            throw new NotFoundException("This key is not present in storage");
        }
        System.out.println("Cache status -> " + keyValueMap);
        return keyValueMap.get(key);
    }

    @Override
    public void remove(Key key) {
        keyValueMap.remove(key);
        System.out.println("Cache status -> " + keyValueMap);
    }
}
