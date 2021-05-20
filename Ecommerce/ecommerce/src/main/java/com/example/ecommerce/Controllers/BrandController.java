package com.example.ecommerce.Controllers;

import java.util.List;

import com.example.ecommerce.Repository.BrandRepository;
import com.example.ecommerce.Repository.CategoryRepository;
import com.example.ecommerce.domain.Brand;
import com.example.ecommerce.domain.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BrandController {
    
    @Autowired
    private BrandRepository repo;

    @Autowired
    private CategoryRepository cateRepo;

    @GetMapping("/brands/new")
    public String showCreateNewBrandForm(Model model){
        List<Category> listCategories = cateRepo.findAll();
        model.addAttribute("brand", new Brand());
        model.addAttribute("listCategories", listCategories);
        return "brandForm";
    }

    @PostMapping("/brands/save")
    public String saveBrand(Brand brand){
        repo.save(brand);
        return "redirect:/";
    }
}
