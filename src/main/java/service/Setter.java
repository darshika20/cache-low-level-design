package service;

import dto.Cache;
import strategy.EvictionStrategy;

public class Setter {

    public void setElementInCache(Cache cache, String key, String value, EvictionStrategy strategy) {
        cache.setElementInCache(key, value);
    }
}
