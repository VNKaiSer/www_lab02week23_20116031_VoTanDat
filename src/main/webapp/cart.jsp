<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.example.lab02.frontend.model.ProductModel" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map.Entry" %>

<%
    // Lấy danh sách sản phẩm từ Session
    Map<ProductModel, Integer> cartData = (Map<ProductModel, Integer>) session.getAttribute("cart");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>
    <!-- Thêm các bảng mã hoặc liên kết CDN khác của bạn tại đây -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body>
<div class="container mx-auto p-8">
    <h2 class="text-2xl font-bold mb-4">Shopping Cart</h2>

    <% if (cartData != null && !cartData.isEmpty()) { %>
    <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 gap-4">
        <%
            Set<Entry<ProductModel, Integer>> entrySet = cartData.entrySet();
            Iterator<Entry<ProductModel, Integer>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Entry<ProductModel, Integer> entry = iterator.next();
                ProductModel product = entry.getKey();
                Integer quantity = entry.getValue();
        %>
        <div class="bg-white p-4 rounded-lg shadow-md">
            <img src="<%= product.getProductImage() %>" class="w-full h-24 object-cover mb-4" alt="Product Image" />
            <div class="font-bold text-md mb-2"><%= product.getName() %></div>
            <p class="text-gray-700 text-base mb-2">Quantity: <%= quantity %></p>
            <div class="text-orange-500 font-bold">$<%= product.getPrice() * quantity %></div>

            <!-- Thêm form để gửi yêu cầu xoá sản phẩm -->
            <form action="cart" method="get">
                <input type="hidden" name="action" value="removeFromCart">
                <input type="hidden" name="productId" value="<%= product.getId() %>">
                <button type="submit" class="mt-2 bg-red-500 text-white py-1 px-2 rounded">Remove</button>
            </form>
        </div>
        <% } %>
    </div>

    <p class="mt-4">Total Items: <%= cartData.size() %></p>
    <p class="mt-4">Total Price: $<%= cartData.entrySet().stream().mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue()).sum() %></p>
    <% } else { %>
    <p class="text-xl text-gray-600 italic">Your cart is empty. Let's fill it with amazing products!</p>
    <% } %>

    <!-- Thêm nút để quay lại trang sản phẩm -->
    <a href="/" class="mt-4 inline-block bg-blue-500 text-white py-2 px-4 rounded">Back to Products</a>
</div>

<!-- ... (phần script và đóng body) ... -->
</body>
</html>
