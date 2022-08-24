import dto.Cache;
import strategy.LeastRecentlyUsed;

public class CacheApplication {

    public static void main(String[] args) {

        Cache cache = Cache.getInstance(new LeastRecentlyUsed(), 5);
        cache.setElementInCache("key1","value1");
        cache.setElementInCache("key2","value2");
        cache.setElementInCache("key3","value3");
        cache.setElementInCache("key4","value4");
        cache.setElementInCache("key5","value5");
        cache.getElementFromCache("key1");
        cache.setElementInCache("key2", "value2");
        cache.setElementInCache("key6","value6");
        System.out.println("Cache -> " + cache.getCacheMap());
    }
}
