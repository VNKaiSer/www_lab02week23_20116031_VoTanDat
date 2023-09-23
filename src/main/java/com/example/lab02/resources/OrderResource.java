package com.example.lab02.resources;

import com.example.lab02.models.Order;
import com.example.lab02.services.OrderDetailService;
import com.example.lab02.services.OrderService;
import com.example.lab02.services.impl.OrderDetailServiceImpl;
import com.example.lab02.services.impl.OrderServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("orders")
public class OrderResource {
    private final OrderService service;
    private final OrderDetailService orderDetailService;
    private
    OrderResource(){
        service = new OrderServiceImpl();
        orderDetailService = new OrderDetailServiceImpl();
    }
    @GET
    @Produces("application/json")
    public Response getAllOrder(){
        return Response.ok(service.getAll(Order.class)).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getEmpById(@PathParam("id") long eid){
        return Response.ok(service.get(eid, Order.class)).build();
    }

    @POST
    @Produces("application/json")
    public Response insert(Order order){
        service.insert(order);
        return Response.ok(order).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(Order order){
        service.update(order);
        return Response.ok(order).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}/detail")
    public Response getOrderDetail(@PathParam("id") long id){
        return Response.ok(orderDetailService.getListOrderDetailByOrder(id)).build();
    }
}
