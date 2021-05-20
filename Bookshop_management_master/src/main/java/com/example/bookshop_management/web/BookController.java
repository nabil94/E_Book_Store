package com.example.bookshop_management.web;

import java.util.List;

import com.example.bookshop_management.Model.Book;
import com.example.bookshop_management.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    
    @Autowired
    private BookRepository repo;

    @GetMapping("/Admin/new")
    public String showBookForm(Model model){
        model.addAttribute("book", new Book());
        return "BookForm";
    }

    @GetMapping("/Admin/list")
    public String showBookList(Model model){
        List<Book> bookList = repo.findAll();
        model.addAttribute("bookList",bookList);
        return "BookList";
    }

    @PostMapping("/Admin/save")
    public String saveCategory(Book book){
        repo.save(book);
        return "redirect:/Admin";
    }


}
