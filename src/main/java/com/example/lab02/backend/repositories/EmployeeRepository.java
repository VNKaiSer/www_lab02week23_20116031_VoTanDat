package com.example.lab02.backend.repositories;

import com.example.lab02.backend.models.Employee;

import java.util.List;


public class EmployeeRepository extends ParentRepository<Employee> {

    public EmployeeRepository() {
        super();
    }

    public void deleteEmp(long id) {
        try {
            transaction.begin();
            entityManager.createNamedQuery("employee.deleteEmp")
                    .setParameter("id", id)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public List<Employee> getEmpActive(){
        return (List<Employee>) entityManager.createNamedQuery("Employee.getEmpActive").getResultList();
    }
}
