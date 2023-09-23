package com.example.lab02.repositories;

import com.example.lab02.models.Employee;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Employee.deleteEmp", query = "UPDATE employees e SET e.status = 'IN_ACTIVE' WHERE e.id = :id"),
        @NamedQuery(name = "Employee.getEmpActive", query = "SELECT e FROM employees e WHERE e.status = 'ACTIVE'")
})
public class EmployeeRepository extends ParentRepository<Employee> {

    public EmployeeRepository() {
        super();
    }

    public void deleteEmp(long id) {
        try {
            transaction.begin();
            entityManager.createNamedQuery("Employee.deleteEmp")
                    .setParameter("id", id)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public List<Employee> getEmpActive(){
        return entityManager.createNamedQuery("Employee.getEmpActive").getResultList();
    }
}
