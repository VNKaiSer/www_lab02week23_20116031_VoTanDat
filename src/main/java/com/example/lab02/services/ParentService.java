package com.example.lab02.services;

import java.util.List;
import java.util.Optional;

public interface ParentService<T> {
    List<T> getAll(Class<T> clazz);
    Optional<T> get(Object id, Class<T> clazz);
    boolean insert(T obj);
    boolean update(T obj);

}
