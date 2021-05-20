package com.example.ecommerce.Controllers;

import java.util.List;

import com.example.ecommerce.Repository.CategoryRepository;
import com.example.ecommerce.domain.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository repo;

    @GetMapping("/categories")
    public String listOfCategories(Model model){
        List<Category> listCategories = repo.findAll();
        model.addAttribute("listCategories", listCategories);
        return "categories";
    }

    @GetMapping("/categories/new")
    public String showCategoryNewForm(Model model){
        model.addAttribute("category", new Category());
        return "categoryForm";
    }

    @PostMapping("/categories/save")
    public String saveCategory(Category category){
        repo.save(category);
        return "redirect:/categories";
    }

}
