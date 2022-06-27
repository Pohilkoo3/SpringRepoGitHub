package com.example.MyBookShoppApp.controllers;

import com.example.MyBookShoppApp.model.oldEntity.Book;
import com.example.MyBookShoppApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController
{

    private BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("booksData")
    public List<Book> getBooks(){
        return bookService.getBooksData();
    }

    @GetMapping("/recent")
    public String getRecent(){
        return "books/recent.html";
    }

    @GetMapping("/popular")
    public String getPopular(){
        return "books/popular.html";
    }

}
