package strategy;

import dto.Cache;
import exception.StorageFullException;

public interface EvictionStrategy<Key> {

    void modifyKeyOrder(Key key) throws StorageFullException;

    Key evictKey();
}
