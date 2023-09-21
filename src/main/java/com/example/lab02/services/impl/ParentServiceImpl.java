package com.example.lab02.services.impl;

import com.example.lab02.repositories.ParentRepository;
import com.example.lab02.services.ParentService;

import java.util.List;
import java.util.Optional;

public class ParentServiceImpl<T> implements ParentService<T> {
    private final ParentRepository<T> parentRepository;
    public ParentServiceImpl(){

        parentRepository = new ParentRepository<T>() {
            @Override
            public boolean insert(Object obj) {
                return super.insert(obj);
            }

            @Override
            public boolean update(Object obj) {
                return super.update(obj);
            }

            @Override
            public boolean delete(Object obj) {
                return super.delete(obj);
            }

            @Override
            public Optional<T> get(Object id, Class<T> clazz) {
                return super.get(id, clazz);
            }

            @Override
            public List<T> getAll(Class<T> clazz) {
                return super.getAll(clazz);
            }
        };
    }
    @Override
    public List<T> getAll(Class<T> clazz) {
        return parentRepository.getAll(clazz);
    }

    @Override
    public Optional<T> get(Object id, Class<T> clazz) {
        return parentRepository.get(id, clazz);
    }

    @Override
    public boolean insert(T obj) {
        return parentRepository.insert(obj);
    }

    @Override
    public boolean update(T obj) {
        return parentRepository.update(obj);
    }
}
