package com.example.lab02.frontend.controller;
import com.example.lab02.backend.models.Product;
import com.example.lab02.backend.services.ProductService;
import com.example.lab02.frontend.model.ProductModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private ProductService productService;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, JsonProcessingException {
        long product = Long.parseLong(request.getParameter("product"));
        ObjectMapper objectMapper = new ObjectMapper();
        Optional<Product> productO = productService.get(product, Product.class);
        HttpSession session = request.getSession();
        List<ProductModel>  cartProduct = (List<ProductModel>) session.getAttribute("cartProduct");
        if (cartProduct == null) {
            cartProduct = new ArrayList<>();
        }
        cartProduct.add(objectMapper.convertValue(productO.get(), ProductModel.class));
        session.setAttribute("cartProduct", cartProduct);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
