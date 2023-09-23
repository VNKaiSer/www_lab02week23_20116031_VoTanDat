package com.example.lab02.resources;

import com.example.lab02.models.Employee;
import com.example.lab02.services.EmployeeService;
import com.example.lab02.services.ParentService;
import com.example.lab02.services.impl.EmployeeServiceImpl;
import com.example.lab02.services.impl.ParentServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("employees")
public class EmployeeResource {
    private final EmployeeService service;

    public EmployeeResource(){
        service = new EmployeeServiceImpl();
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Employee> employees = service.getAll(Employee.class);
        for (Employee employee : employees){
            System.out.println(employee);
        }
        return Response.ok(employees).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getEmpById(@PathParam("id") long eid){
        Optional<Employee> employee = service.get(eid, Employee.class);
        if (employee.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(employee.get()).build();
    }

    @DELETE
    @Produces("application/json")
    @Path("/{id}")
    public Response deleteEmp(@PathParam("id") long eid){
        service.deleteEmp(eid);
        return Response.ok().build();
    }

}
