package com.example.MyBookShoppApp.dao;

import com.example.MyBookShoppApp.model.oldEntity.Book;
import com.example.MyBookShoppApp.interfaces.InterfaceBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BooksDao
{
    @Autowired
    private InterfaceBookRepo bookRepo;
    public List<Book> getAllBooks() {
       return bookRepo.findAll();
    }
        /** Book's DAO for APIBook'sController**/
   public List<Book> getBooksDataByAuthor(String authorsName)
    {
        return bookRepo.findBookByAuthorName(authorsName);
    }

    public List<Book> getBooksDataByTitle(String title){
       return  bookRepo.findBooksByTitleContaining(title);
    }

    public List<Book> getBooksDataByPriceBetween(int min, int max){
        return  bookRepo.findBooksByPriceBetween(min, max);
    }

    public List<Book> getBooksDataByPriceIs(int price){
        return  bookRepo.findBooksByPriceIs(price);
    }


    public List<Book> getBestsellers(){
        return  bookRepo.findBestsellers();
    }

    public List<Book> getBooksMaxDiscount(){
        return  bookRepo.getBooksMaxDiscount();
    }

    public Page<Book> getBooksPaging(Integer offset, Integer limit)
    {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepo.findAll(nextPage);
    }

    public Page<Book> getPageOfSearchResult(String search, Integer offset, Integer limit)
    {
       Pageable nextPage = PageRequest.of(offset, limit);
       return bookRepo.findBooksByTitleContaining(search, nextPage);
    }

    public Page<Book> getNewBooks(Date dateFrom, Date dateTo, Integer offset, Integer limit)
    {
        Pageable nextPage = PageRequest.of(offset, limit, Sort.by("pubDate").descending());
        return bookRepo.findBooksByPubDateBetween(dateFrom, dateTo, nextPage);
    }

    public Page<Book> getPopularBooks(Integer offset, Integer limit)
    {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepo.findAll(nextPage);
    }

    public Page<Book> getBooksByGenreId(Integer id, Integer offset, Integer limit)
    {
        Pageable nextPage = PageRequest.of(offset, limit);
        Page<Book> bookPage = bookRepo.findBookByGenreBuId(id, nextPage);
        return bookPage;
    }

    public Page<Book> getBooksByTagsId(Integer tagsId, Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        Page<Book> bookPage = bookRepo.findBooksByTags(tagsId, nextPage);
        return bookPage;
    }

    public Page getPagePopularBooks(int offset, int limit) {
       Pageable nextPage = PageRequest.of(offset, limit);
       return bookRepo.findBooksPageIsBestseller(nextPage);
   }

    public Page<Book> getBooksByAuthorId(Integer idAuthor, int offset, int limit)
    {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepo.findBooksByAuthorId(idAuthor, nextPage);
    }
}
