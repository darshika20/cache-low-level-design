package factory;

import dto.Cache;
import storage.HashMapStorage;
import strategy.LeastRecentlyUsed;

public class CacheFactory {

    static CacheFactory cacheFactory;

    public Cache<String, String> getDefaultCache() {

        return new Cache<String, String>(new LeastRecentlyUsed<>(5, "key"),
                new HashMapStorage<String, String>());
    }

    public static CacheFactory getInstance(){
        if (cacheFactory == null) {
            System.out.println("Creating new instance");
            cacheFactory = new CacheFactory();
        }
        return cacheFactory;
    }
}
