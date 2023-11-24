package com.example.lab02.backend.repositories;

import java.util.List;
import java.util.Optional;

public interface IFRepository<T> {
    boolean insert(T obj);
    boolean update(T obj);
    boolean delete(T obj);
    Optional<T> get(Object id, Class<T> clazz);

    List<T> getAll(Class<T> clazz);
}
