package com.evernote.persistant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FakeDatabase {

    public static FakeDatabase INSTANCE = new FakeDatabase();

    private Map<Class, Map<Integer, Object>> database = new ConcurrentHashMap<>();
    public FakeDatabase() {
    }
    @SuppressWarnings("unchecked")
    private <C> Map<Integer, C> getClassDatabase(Class<C> clazz) {
        return (Map<Integer, C>) database.computeIfAbsent(clazz, (clazz1) -> new ConcurrentHashMap<>());
    }
    public boolean isEmpty() {
        return database.isEmpty();
    }
    public boolean containsKey(Object key) {
        return database.get(key.getClass()).containsKey(key);
    }
    public <C> C get(Class<C> clazz, Integer key) {
        return this.getClassDatabase(clazz).get(key);
    }
    public <C> C put(Integer key, C value) {
        Map<Integer, C> map = (Map<Integer, C>) this.getClassDatabase(value.getClass());
        return map.put(key, value);
    }
}
