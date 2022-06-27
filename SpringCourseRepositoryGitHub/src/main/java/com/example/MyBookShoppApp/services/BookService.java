package com.example.MyBookShoppApp.services;

import com.example.MyBookShoppApp.dao.BooksDao;
import com.example.MyBookShoppApp.model.oldEntity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BooksDao booksDao;

    @Autowired
    public BookService(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    public List<Book> getBooksData() {
        return booksDao.getAllBooks();
    }

}
