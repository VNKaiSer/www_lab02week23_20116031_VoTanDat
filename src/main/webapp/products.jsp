<%@ page import="com.example.lab02.frontend.api.ProductAPI" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lab02.frontend.model.ProductModel" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%
    ProductAPI productAPI = new ProductAPI();
    List<ProductModel> productsList = productAPI.getProducts();
    ObjectMapper mapper = new ObjectMapper();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Page</title>
    <!-- Add your other stylesheets or CDN links here -->
</head>
<body class="bg-gray-100">

<div class="container mx-auto p-8">
    <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-8">
        <% for (ProductModel product : productsList) { %>
        <div class="bg-white p-4 rounded-lg shadow-md">
            <img src="<%= product.getProductImage() %>" class="w-full h-32 object-cover mb-4" alt="Product Image"/>
            <div class="font-bold text-xl mb-2"><%= product.getName() %></div>
            <p class="text-gray-700 text-base mb-4"><%= product.getDescription() %></p>
            <div class="text-orange-500 font-bold">$<%= product.getPrice() %></div>
            <a href="/cart?action=addToCart&productId=<%= product.getId() %>" >
                <button type="submit" class="bg-blue-500 text-white px-4 py-2 mt-4 rounded">Add to Cart</button>
            </a>
        </div>
        <% } %>
    </div>
</div>
<script>
    // function addToCart(product) {
    //     let cart = localStorage.getItem("cart") || [];
    //     cart.push(product);
    //    localStorage.setItem("product", cart);
    //    console.log(cart);
    // }
</script>
</body>
</html>
