package com.example.lab02.backend.resources;


import com.example.lab02.backend.models.Order;
import com.example.lab02.backend.serializes.OrderSerializer;
import com.example.lab02.backend.services.OrderDetailService;
import com.example.lab02.backend.services.OrderService;
import com.example.lab02.backend.services.impl.OrderDetailServiceImpl;
import com.example.lab02.backend.services.impl.OrderServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("orders")
public class OrderResource {
    ObjectMapper mapper = new ObjectMapper();

    private final OrderService service;
    private final OrderDetailService orderDetailService;
    private
    OrderResource(){
        service = new OrderServiceImpl();
        orderDetailService = new OrderDetailServiceImpl();
        SimpleModule module = new SimpleModule("OrderSerializer", new Version(1, 0, 0, null, null, null));
        module.addSerializer(Order.class, new OrderSerializer());
        mapper.registerModule(module);
    }
    @GET
    @Produces("application/json")
    public Response getAllOrder() throws JsonProcessingException {
        List<Order> orders = service.getAll(Order.class);
        String orderStr = "[";
        if (orders.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        for (Order order : orders){
            orderStr += mapper.writeValueAsString(order);
        }
        orderStr += "]";
        return Response.ok(orderStr).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getOrderById(@PathParam("id") long oid){

        Optional<Order> order = service.get(oid, Order.class);
        if (order.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        try {
            String orderStr = mapper.writeValueAsString(order.get());
            return Response.ok(orderStr).build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Order order) {
        if (order == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        service.insert(order);
        return Response.ok("Thêm thành công").build();
    }

//    @POST
//    @Produces("application/json")
//    @Consumes("application/json")
//    @Path("/{id}")
//    public Response updateOrder(@ PathParam("id") long id,Order order){
//        service.update(order);
//        return Response.ok(order).build();
//    }

    @GET
    @Produces("application/json")
    @Path("/{id}/detail")
    public Response getOrderDetail(@PathParam("id") long id){
        return Response.ok(orderDetailService.getListOrderDetailByOrder(id)).build();
    }
}
