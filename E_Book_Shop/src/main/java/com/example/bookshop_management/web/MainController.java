package com.example.bookshop_management.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String showHome(){
        return "index";
    }

    @GetMapping("/Admin")
    public String showAdmin(){
        return "Admin";
    }
}
