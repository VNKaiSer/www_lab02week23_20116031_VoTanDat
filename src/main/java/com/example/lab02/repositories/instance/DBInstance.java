package com.example.lab02.repositories.instance;

import com.example.lab02.models.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class DBInstance {
    private static DBInstance instance;
    private EntityManager em;
    private DBInstance(){
        em =     Persistence
                .createEntityManagerFactory("default")
                .createEntityManager();
    }

    public static DBInstance getInstance(){
        if(instance == null){
            instance = new DBInstance();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public static void main(String[] args) {
        EntityManager em = DBInstance.getInstance().getEntityManager();
//        em.getTransaction().begin();
//        em.persist(new Customer("1", "Nguyen Van A", new LocalDateTime(), "a@a.com", "0123456789", "Ha Noi"));
//        em.getTransaction().commit();
    }
}
