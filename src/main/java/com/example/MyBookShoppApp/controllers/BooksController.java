package com.example.MyBookShoppApp.controllers;

import com.example.MyBookShoppApp.model.oldEntity.Book;
import com.example.MyBookShoppApp.responseEntity.PagingBooksResponse;
import com.example.MyBookShoppApp.services.BookService;
import com.example.MyBookShoppApp.util_object.SearchIdForGenre;
import com.example.MyBookShoppApp.util_object.SearchWordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class BooksController {

    private BookService bookService;
    private SearchIdForGenre searchIdForGenre;

    @Autowired
    public BooksController(BookService bookService, SearchIdForGenre searchIdForGenre) {
        this.bookService = bookService;
        this.searchIdForGenre = searchIdForGenre;
    }

    @ModelAttribute("newBooks")
    public List<Book> newBooks() {
        Date now = new Date();
        List<Book> bookList = bookService.getNewBooks(new Date(now.getYear(), now.getMonth() - 6, now.getDay()), new Date(), 0, 20).getContent();
        return bookList;
    }


    @GetMapping("/books/recent")
    public String getRecent() {
        return "books/recent.html";
    }

    @GetMapping("/books/popular")
    public String getPopular(Model model) {
        model.addAttribute("dataBooksPopular", bookService.getPagePopularBook(0, 10));
        return "books/popular.html";
    }


    @GetMapping("/books/nextPage/popular")
    @ResponseBody
    public PagingBooksResponse getNextPagePopular( @RequestParam("offset") Integer offset,
                                                   @RequestParam("limit") Integer limit){
        return new PagingBooksResponse(bookService.getPopularBooks(offset, limit).getContent());
    }


    @GetMapping("/books/date/recent")
    @ResponseBody
    public PagingBooksResponse getBooksByDate(@RequestParam(value = "from") @DateTimeFormat(pattern = "dd.MM.yyyy") Date dateFrom,
                                              @RequestParam(value = "to") @DateTimeFormat(pattern = "dd.MM.yyyy") Date dateTo,
                                              @RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        PagingBooksResponse pagingBooksResponse = new PagingBooksResponse(bookService.getNewBooks(dateFrom, dateTo, offset, limit).getContent());
        return pagingBooksResponse;
    }

    @GetMapping("/books/genre/{genreId}")
    @ResponseBody
    public PagingBooksResponse getBookByGenre(@PathVariable(value = "genreId", required = false) String searchIdForGenre,
                                              @RequestParam("offset") Integer offset,
                                              @RequestParam("limit") Integer limit) {
        Integer searchId = Integer.valueOf(searchIdForGenre);
        return new PagingBooksResponse(bookService.getBooksByGenreId(searchId, offset, limit).getContent());
    }

}
