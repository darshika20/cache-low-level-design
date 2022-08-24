package service;

import dto.Cache;
import exception.NotFoundException;
import strategy.EvictionStrategy;

public class Getter {

    public String getElementByKey(String key, Cache cache, EvictionStrategy strategy) throws NotFoundException {

        if (cache.getElementFromCache(key) == null) {
            throw  new NotFoundException("Element not found in cache");
        }
        return cache.getElementFromCache(key);
    }
}
