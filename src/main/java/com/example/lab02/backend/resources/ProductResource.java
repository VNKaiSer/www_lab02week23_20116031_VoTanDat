package com.example.lab02.backend.resources;

import com.example.lab02.backend.models.Order;
import com.example.lab02.backend.models.Product;
import com.example.lab02.backend.serializes.OrderSerializer;
import com.example.lab02.backend.serializes.ProductSerializer;
import com.example.lab02.backend.services.ParentService;
import com.example.lab02.backend.services.ProductService;
import com.example.lab02.backend.services.impl.ParentServiceImpl;
import com.example.lab02.backend.services.impl.ProductServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/products")
public class ProductResource {
    private final ProductService service;
    private ObjectMapper mapper = new ObjectMapper();
    ProductResource(){
        service = new ProductServiceImpl();
        SimpleModule module = new SimpleModule("ProductSerializer", new Version(1, 0, 0, null, null, null));
        module.addSerializer(Product.class, new ProductSerializer());
        mapper.registerModule(module);
    }

    @GET
    @Produces("application/json")
    public Response getAll() throws JsonProcessingException {
        List<Product> products = service.getAll(Product.class);
        if (products.isEmpty()) return Response.status(Response.Status.BAD_REQUEST).build();
        List<String> jsonProduct = new ArrayList<>();
        for (Product p:
             products) {
            jsonProduct.add(mapper.writeValueAsString(p));
        }
        return Response.ok(jsonProduct.toString()).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Product product) {
        service.insert(product);
        return Response.ok(product).build();
    }

    @DELETE
    @Produces("application/json")
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") long id){
        service.deleteProduct(id);
        return Response.ok().build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getProductById(@PathParam("id") long id){
        Optional<Product> product = service.get(id, Product.class);
        if (product.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(product.get()).build();
    }

    @GET
    @Produces("application/json")
    @Path("/active")
    public Response getProductsActive(){
        return Response.ok(service.getProductsActive()).build();
    }
}
