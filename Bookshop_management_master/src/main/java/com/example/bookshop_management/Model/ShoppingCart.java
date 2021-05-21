package com.example.bookshop_management.Model;


import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ShoppingCart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private double TotalCash;

    @OneToMany(mappedBy = "shoppingCart")
    private List<CartItem> cartItemList;

    @OneToOne
    private User user;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public double getTotalCash(){
        return TotalCash;
    }

    public void setTotalCash(double TotalCash){
        this.TotalCash = TotalCash;
    }

    public List<CartItem> getCartItemList(){
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList){
        this.cartItemList = cartItemList;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }
}
