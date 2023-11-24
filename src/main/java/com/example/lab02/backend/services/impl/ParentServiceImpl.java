package com.example.lab02.backend.services.impl;

import com.example.lab02.backend.repositories.ParentRepository;
import com.example.lab02.backend.services.ParentService;

import java.util.List;
import java.util.Optional;

public class ParentServiceImpl<T> implements ParentService<T> {
    protected final ParentRepository<T> parentRepository;
    public ParentServiceImpl(){

        parentRepository = new ParentRepository<>();
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
    public void insert(T obj) {
        parentRepository.insert(obj);
    }

    @Override
    public boolean update(T obj) {
        return parentRepository.update(obj);
    }
}
