import dto.Cache;
import exception.NotFoundException;
import exception.StorageFullException;
import factory.CacheFactory;

public class CacheApplication {

    public static void main(String[] args) {

        Cache<String, String> cache = CacheFactory.getInstance().getDefaultCache();
        cache.setElementInCache("Key1", "Value1");
        System.out.println("****************Added Key1 in cache*************");
        cache.setElementInCache("Key2", "Value2");
        System.out.println("****************Added Key2 in cache*************");
        cache.setElementInCache("Key3", "Value3");
        System.out.println("****************Added Key3 in cache*************");
        cache.setElementInCache("Key4", "Value4");
        System.out.println("****************Added Key4 in cache*************");
        cache.setElementInCache("Key5", "Value5");
        System.out.println("****************Added Key5 in cache*************");
        cache.setElementInCache("Key6", "Value6");
        System.out.println("****************Added Key6 in cache*************");
        //System.out.println("Cache -> " + cache.getStorage());
        try {
            cache.getElementFromCache("Key1");
        } catch (StorageFullException e) {
            e.printStackTrace();
            System.out.println("****************Did not fetch Key1 in cache*************");
        }
        try {
            System.out.println("Value : " + cache.getElementFromCache("Key2"));
        } catch (StorageFullException e) {
            e.printStackTrace();
            System.out.println("****************Did not fetch Key2 in cache*************");

        }
        //System.out.println("Cache -> " + cache.getStorage());
        cache.setElementInCache("Key6", "Value7");
        System.out.println("****************Updated Key6 in cache*************");
        //System.out.println("Cache -> " + cache.getStorage());

    }
}
