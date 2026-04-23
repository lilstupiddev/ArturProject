package ua.university;

import java.util.*;

public class Repository<T> {
    private final Map<String, T> data = new HashMap<>();

    public void save(String id, T obj) {
        data.put(id, obj);
    }

    public Optional<T> find(String id) {
        return Optional.ofNullable(data.get(id));
    }

    public List<T> findAll() {
        return new ArrayList<>(data.values());
    }

    public void delete(String id) {
        data.remove(id);
    }
}