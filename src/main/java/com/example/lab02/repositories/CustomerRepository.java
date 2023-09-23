package com.example.lab02.repositories;

import com.example.lab02.enums.CustomerStatus;
import com.example.lab02.models.Customer;

import java.util.List;

public class CustomerRepository extends ParentRepository<Customer>{

    public boolean deleteCustomer(long id){
        try {
            transaction.begin();
            entityManager.createNamedQuery("Customer.deleteCustomer")
                    .setParameter("id", id)
                    .executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    public List<Customer> getCustomersActive(){
        return (List<Customer>) entityManager.createNamedQuery("Customer.getCustomersActive").setParameter("status", CustomerStatus.ACTIVE).getResultList();
    }


}
