package com.example.bookshop_management.repository;

import java.util.List;

import com.example.bookshop_management.Model.CartItem;
import com.example.bookshop_management.Model.ShoppingCart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer>{
    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
}
