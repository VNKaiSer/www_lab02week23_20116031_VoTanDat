package com.example.lab02.backend.resources;

import com.example.lab02.backend.models.Customer;
import com.example.lab02.backend.services.CustomerService;
import com.example.lab02.backend.services.impl.CustomerServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@Path("/customers")
public class CustomerResource {
    private final CustomerService service;
    public CustomerResource(){
        service = new CustomerServiceImpl();
    }
    @GET
    @Produces("application/json")
    public Response getCustomers(){
        return Response.ok(service.getAll(Customer.class)).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getCustomerById(@PathParam("id") long id){
        Optional<Customer> customer = service.get(id, Customer.class);
        if (customer.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(customer.get()).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insertCustomer(Customer customer){
        service.insert(customer);
        return Response.ok(customer).build();
    }

    @DELETE
    @Produces("application/json")
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") long id){
        service.deleteCustomer(id);
        return Response.ok().build();
    }

    @GET
    @Produces("application/json")
    @Path("/active")
    public Response getCustomersActive(){
        return Response.ok(service.getCustomersActive()).build();
    }

//    @POST
//    @Produces("application/json")
//    @Consumes("application/json")
//    @Path("/{id}")
//    public Response updateCustomer(Customer customer){
//        service.update(customer);
//        return Response.ok(customer).build();
//    }




}