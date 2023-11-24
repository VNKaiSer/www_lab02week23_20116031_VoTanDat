package com.example.lab02.backend.repositories;


import com.example.lab02.backend.repositories.instance.DBInstance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;


public class ParentRepository<T> implements IFRepository<T>{
    protected final EntityManager entityManager;
    protected final EntityTransaction transaction;
    protected final Logger logger =
            LoggerFactory.getLogger(this.getClass().getName());

    public ParentRepository(){
        entityManager = DBInstance.getInstance().getEntityManager();
        transaction = entityManager.getTransaction();
    }
    @Override
    public boolean insert(Object obj) {
        try {
            transaction.begin();
            entityManager.persist(obj);
            transaction.commit();
            return true;
        } catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Object obj) {
        try {
            transaction.begin();
            entityManager.merge(obj);
            transaction.commit();
            return true;
        } catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Object obj) {
        try {
            transaction.begin();
            entityManager.remove(obj);
            transaction.commit();
            return true;
        } catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<T> get(Object id, Class<T> clazz) {
            T obj = entityManager.find(clazz, id);
            return obj == null ? Optional.empty() : Optional.of(obj);
    }

    @Override
    public List<T> getAll(Class<T> clazz) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        query.from(clazz);
        TypedQuery<T> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

}
