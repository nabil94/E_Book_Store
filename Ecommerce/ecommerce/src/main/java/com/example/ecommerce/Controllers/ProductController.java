package com.example.ecommerce.Controllers;

import java.util.List;

import com.example.ecommerce.Repository.CategoryRepository;
import com.example.ecommerce.Repository.ProductRepository;
import com.example.ecommerce.domain.Category;
import com.example.ecommerce.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    
    @Autowired
    private ProductRepository repo;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/products/new")
    public String showNewProductForm(Model model){
        List<Category> listCategories = categoryRepository.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("listCategories", listCategories);
        return "productForm";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product){
        repo.save(product);
        return "redirect:/";
    }

    @GetMapping("/products")
    public String listProducts(Model model){
        List<Product> listProducts = repo.findAll();
        model.addAttribute("listProducts", listProducts);
        return "products";
    }

    @GetMapping("products/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model){
        Product product = repo.findById(id).get();
        model.addAttribute("product",product);
        List<Category> listCategories = categoryRepository.findAll();
        //model.addAttribute("product", new Product());
        model.addAttribute("listCategories", listCategories);
        return "productForm";
    }

    @GetMapping("products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id, Model model){
        repo.deleteById(id);
        return "redirect:/products";
    }
}
