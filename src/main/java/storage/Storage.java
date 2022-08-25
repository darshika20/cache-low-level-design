package storage;

import exception.NotFoundException;

public interface Storage<Key, Value> {

    void add(Key key, Value value);

    Value get(Key key) throws NotFoundException;

    void remove(Key key);

}
