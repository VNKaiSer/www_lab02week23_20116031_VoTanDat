<header class="bg-blue-500 p-4">
    <div class="container mx-auto flex items-center justify-between">
        <!-- Logo/Home Link -->
        <a href="#" class="text-white text-2xl font-bold">KaiserShop</a>

        <!-- Navigation Links -->
        <nav class="space-x-4">
            <a href="#" class="text-white">Home</a>
            <a href="#" class="text-white">Products</a>
            <a href="#" class="text-white">About</a>
        </nav>

        <!-- Cart Icon -->
        <div class="flex items-center">
            <a href="/cart"><img src="../img/shopping-cart-outline-svgrepo-com.svg" style="width: 24px; height: 24px;"></a>
            <span class="text-white"><%= session.getAttribute("cartSize") == null ? 0 : session.getAttribute("cartSize") %></span>
        </div>
    </div>
</header>