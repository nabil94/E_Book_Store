package com.example.bookshop_management.service;

import java.util.List;

//import java.util.List;

import com.example.bookshop_management.Model.Book;
import com.example.bookshop_management.Model.CartItem;
import com.example.bookshop_management.Model.ShoppingCart;
import com.example.bookshop_management.Model.User;

public interface CartItemService {
    CartItem addBook(Book book, User user, int qty);
    CartItem findById(Integer id);
    void removeCartItem(CartItem cartItem);
    void save(CartItem cartItem);
    CartItem updateCartItem(CartItem cartItem);
    List<CartItem> findByShoppingCart(ShoppingCart sc);
    //List<CartItem> findByOrder(Order order);
}
