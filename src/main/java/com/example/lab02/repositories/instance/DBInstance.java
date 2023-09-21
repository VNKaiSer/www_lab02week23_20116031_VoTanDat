package com.example.lab02.repositories.instance;

import com.example.lab02.enums.EmployeeStatus;
import com.example.lab02.models.Customer;
import com.example.lab02.models.Employee;
import com.example.lab02.repositories.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;


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
        Employee e = new Employee("Vo Tan Dat", LocalDateTime.now(), "tandatvok16@gmail.com","0329672303","Ho Chi Minh", EmployeeStatus.ACTIVE);
        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.insert(e);
    }
}
