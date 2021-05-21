package com.example.bookshop_management.service;

import com.example.bookshop_management.Model.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);
    void clearShoppingCart(ShoppingCart shoppingCart);
}
