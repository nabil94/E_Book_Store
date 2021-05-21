package com.example.bookshop_management.repository;

import com.example.bookshop_management.Model.ShoppingCart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{
    
}
