package com.example.MyBookShoppApp.dao;

import com.example.MyBookShoppApp.model.oldEntity.Book;
import com.example.MyBookShoppApp.interfaces.InterfaceBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksDao
{
    @Autowired
    private InterfaceBookRepo bookRepo;
    public List<Book> getAllBooks() {
       return bookRepo.findAll();
    }
}
