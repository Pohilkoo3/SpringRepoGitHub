package com.example.MyBookShoppApp.controllers;

import com.example.MyBookShoppApp.model.oldEntity.Book;
import com.example.MyBookShoppApp.model.tags.Tag;
import com.example.MyBookShoppApp.responseEntity.PagingBooksResponse;
import com.example.MyBookShoppApp.services.BookService;
import com.example.MyBookShoppApp.services.TagService;
import com.example.MyBookShoppApp.util_object.SearchWordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainPageController {
    private BookService bookService;
    private TagService tagService;

    @Autowired
    public MainPageController(BookService bookService, TagService tagService) {
        this.bookService = bookService;
        this.tagService = tagService;
    }

    @ModelAttribute("recommended")
    public List<Book> recommendedBooks() {
        List<Book> bookList = bookService.getPageOfRecommendedBooks(0, 6).getContent();
        return bookList;
    }
    @ModelAttribute("tags")
    public List<Tag> tags(){
        List<Tag> list = tagService.getAllTags();
        return list;
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDTO() {
        return new SearchWordDto();
    }

    @ModelAttribute("searchResults")
    public List<Book> searchResults() {
        return new ArrayList<>();
    }

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/books/recommended")
    @ResponseBody
    public PagingBooksResponse getBooksPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        PagingBooksResponse pagingBooksResponse = new PagingBooksResponse(bookService.getPageOfRecommendedBooks(offset, limit).getContent());
        return pagingBooksResponse;
    }

    @GetMapping("/books/page/popular")
    @ResponseBody
    public PagingBooksResponse getBooksPopular(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit)
    {
        return new PagingBooksResponse(bookService.getPopularBooks(offset, limit).getContent());
    }

    @ModelAttribute("popular")
    public List<Book> getPopularBooks()
    {
        return bookService.getPopularBooks(0, 6).getContent();
    }


    @GetMapping(value = {"/search", "/search/{searchWord}"})
    public String getSearchResults(@PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto,
                                   Model model) {
        model.addAttribute("searchWordDto", searchWordDto);
        model.addAttribute("searchResults", bookService.getPageOfSearchResult(searchWordDto.getExample(),
                0, 5).getContent());
        return "/search/index";
    }

    @GetMapping("/search/page/{searchWord}")
    @ResponseBody
    public PagingBooksResponse getNextSearchPage(@PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto,
                                                        @RequestParam("offset") Integer offset,
                                                        @RequestParam("limit") Integer limit) {
        PagingBooksResponse pagingBooksResponse = new PagingBooksResponse(bookService.getPageOfSearchResult(searchWordDto.example, offset, limit).getContent());
        return pagingBooksResponse;
    }

    @ModelAttribute("newBooks")
    public List<Book> newBooks()
    {
        Date now = new Date();
        List<Book> bookList = bookService.getNewBooks(new Date(now.getYear(), now.getMonth()-6, now.getDay()) ,new Date(), 0, 6).getContent();
        return bookList;
    }

    @GetMapping("/books/page/recent")
    @ResponseBody
    public PagingBooksResponse getRecentBooks(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit)
    {
        Date now = new Date();
        PagingBooksResponse pagingBooksResponse1 = new PagingBooksResponse(bookService.getNewBooks(new Date(now.getYear(), now.getMonth()-6, now.getDay()),
                new Date(), offset, limit).getContent());
        return pagingBooksResponse1;
    }



}
