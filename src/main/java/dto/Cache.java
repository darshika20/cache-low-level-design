package dto;

import strategy.EvictionStrategy;

import java.util.HashMap;
import java.util.Map;

public class Cache {

    private Map<String, String> cacheMap;

    static Cache cache;

    private EvictionStrategy evictionStrategy;

    private int capacity;

    private Cache(EvictionStrategy strategy, int capacity) {
        this.cacheMap = new HashMap<>();
        this.evictionStrategy = strategy;
        this.capacity = capacity;
    }

    public static Cache getInstance(EvictionStrategy strategy, int capacity) {
        if (cache == null) {
            cache = new Cache(strategy, capacity);
            System.out.println("Created new Cache with eviction strategy " + strategy);
        }
        return cache;
    }

    public static Cache getInstance() {
        return cache;
    }

    public String getElementFromCache(String key) {
        if (cacheMap.containsKey(key)) {
            evictionStrategy.modifyCache(key, cacheMap.get(key), cache);
            return cacheMap.get(key);
        }
        return null;
    }

    public void setElementInCache(String key, String value) {

        evictionStrategy.modifyCache(key, value, cache);
        cacheMap.put(key, value);
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<String, String > getCacheMap() {
        return cacheMap;
    }
}
