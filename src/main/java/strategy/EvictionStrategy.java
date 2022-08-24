package strategy;

import dto.Cache;

public interface EvictionStrategy {

    void modifyCache(String key, String value, Cache cache);
}
