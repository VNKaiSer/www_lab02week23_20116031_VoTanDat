package com.example.lab02.frontend.controller;

import com.example.lab02.frontend.api.ProductAPI;
import com.example.lab02.frontend.model.ProductModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private ProductAPI productAPI;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        productAPI = new ProductAPI();
        HttpSession session = request.getSession();
        Map<ProductModel, Integer> cart = (Map<ProductModel, Integer>) session.getAttribute("cart");
        if(cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }
        if (action == null) {

            response.sendRedirect("cart.jsp");
        } else if (action.equals("addToCart")) {
            String productId = request.getParameter("productId");
            ProductModel product = productAPI.getProductById(Long.parseLong(productId));
            if(cart.containsKey(product)) {
                cart.put(product, cart.get(product) + 1);
            } else {
                cart.put(product, 1);
            }
            session.setAttribute("cart", cart);
            response.sendRedirect("/");
        } else if (action== "removeFromCart") {
            String productId = request.getParameter("productId");
            ProductModel product = productAPI.getProductById(Long.parseLong(productId));
            if(cart.containsKey(product)) {
                if(cart.get(product) == 1) {
                    cart.remove(product);
                } else {
                    cart.put(product, cart.get(product) - 1);
                }
            }
            session.setAttribute("cart", cart);
//            response.sendRedirect("cart.jsp");
        } else if (action.equals("clearCart")) {
            cart.clear();
            session.setAttribute("cart", cart);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
