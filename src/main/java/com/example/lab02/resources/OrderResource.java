package com.example.lab02.resources;

import com.example.lab02.models.Order;
import com.example.lab02.services.OrderDetailService;
import com.example.lab02.services.OrderService;
import com.example.lab02.services.impl.OrderDetailServiceImpl;
import com.example.lab02.services.impl.OrderServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.io.IOException;

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
    @Consumes("application/json")
    public Response insert(String jsonOrder) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Order order = objectMapper.readValue(jsonOrder, Order.class);
            service.insert(order);
            return Response.ok(order).build();
        } catch (IOException e) {
            // Xử lý lỗi khi ánh xạ dữ liệu JSON vào đối tượng Order
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/{id}")
    public Response update(@ PathParam("id") long id,Order order){
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
