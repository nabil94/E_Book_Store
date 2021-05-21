package com.example.bookshop_management.repository;

import com.example.bookshop_management.Model.BookToCartItem;
import com.example.bookshop_management.Model.CartItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookToCartItemRepository extends JpaRepository<BookToCartItem, Integer>{
    void deleteByCartItem(CartItem crtItem);
}
