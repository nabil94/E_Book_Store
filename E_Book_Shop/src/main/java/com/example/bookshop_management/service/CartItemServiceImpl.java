package com.example.bookshop_management.service;

import java.util.List;

import com.example.bookshop_management.Model.Book;
import com.example.bookshop_management.Model.BookToCartItem;
import com.example.bookshop_management.Model.CartItem;
import com.example.bookshop_management.Model.ShoppingCart;
import com.example.bookshop_management.Model.User;
import com.example.bookshop_management.repository.BookToCartItemRepository;
import com.example.bookshop_management.repository.CartItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService{
    
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private BookToCartItemRepository bookToCartItemRepository;

    @Override
    public CartItem addBook(Book book, User user, int qty) {
        CartItem cartItem = new CartItem();
        cartItem.setShoppingCart(user.getShoppingCart());
        cartItem.setBook(book);
        cartItem.setQty(qty);
        cartItem.setSubtotal(book.getPrice()*qty);
        cartItem = cartItemRepository.save(cartItem);

        BookToCartItem bookToCartItem = new BookToCartItem();
        bookToCartItem.setBook(book);
        bookToCartItem.setCartItem(cartItem);
        bookToCartItemRepository.save(bookToCartItem);

        //cartItemRepository.

        return cartItem;
    }

    @Override
    public CartItem findById(Integer id) {
        CartItem c = cartItemRepository.findById(id).get();
        return c;
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }

    @Override
    public void save(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItem> findByShoppingCart(ShoppingCart sc) {
        List<CartItem> c = cartItemRepository.findByShoppingCart(sc);
        return c;
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        double cost = cartItem.getBook().getPrice()*cartItem.getQty();
        cartItem.setSubtotal(cost);
        cartItemRepository.save(cartItem);
        return cartItem;
    }//
    
}
