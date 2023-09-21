package com.example.lab02.resources;

import com.example.lab02.models.Employee;
import com.example.lab02.services.ParentService;
import com.example.lab02.services.impl.ParentServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("employee")
public class EmployeeResource {
    private final ParentService<Employee> parentService;

    public EmployeeResource(){
        parentService = new ParentServiceImpl<>();
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Employee> employees = parentService.getAll(Employee.class);
        for (Employee employee : employees){
            System.out.println(employee);
        }
        return Response.ok(employees).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getEmpById(@PathParam("id") long eid){
        Optional<Employee> employee = parentService.get(eid, Employee.class);
        if (employee.isEmpty())
            return Response.status(Response.Status.BAD_REQUEST).build();
        return Response.ok(employee.get()).build();
    }

}
