package com.example.bookshop_management.service;

import java.util.List;

import com.example.bookshop_management.Model.CartItem;
import com.example.bookshop_management.Model.ShoppingCart;
import com.example.bookshop_management.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
        double total = 0.0;

        List<CartItem> cartItem = cartItemService.findByShoppingCart(shoppingCart);

        for(CartItem c: cartItem){
            cartItemService.updateCartItem(c);
            total += c.getSubtotal();
        }

        shoppingCart.setTotalCash(total);
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }

    @Override
    public void clearShoppingCart(ShoppingCart shoppingCart) {
        
        
    }
    
    
}
