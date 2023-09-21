package com.example.lab02.resources;

import com.example.lab02.models.Product;
import com.example.lab02.services.ParentService;
import com.example.lab02.services.impl.ParentServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/products")
public class ProductResource {
    private final ParentService<Product> parentService;
    ProductResource(){
        parentService = new ParentServiceImpl<>();
    }

    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Product> products = parentService.getAll(Product.class);
        for (Product product : products){
            System.out.println(product);
        }
        return Response.ok(products).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Product product) {
        parentService.insert(product);
        return Response.ok(product).build();
    }

}
