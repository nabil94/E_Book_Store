package com.example.bookshop_management.repository;

import com.example.bookshop_management.Model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer>{
    
}
