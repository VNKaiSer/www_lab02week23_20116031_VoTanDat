package com.example.lab02.resources;

import com.example.lab02.models.Product;
import com.example.lab02.services.ParentService;
import com.example.lab02.services.ProductService;
import com.example.lab02.services.impl.ParentServiceImpl;
import com.example.lab02.services.impl.ProductServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/products")
public class ProductResource {
    private final ProductService service;
    ProductResource(){
        service = new ProductServiceImpl();
    }

    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Product> products = service.getAll(Product.class);
        for (Product product : products){
            System.out.println(product);
        }
        return Response.ok(products).build();
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
