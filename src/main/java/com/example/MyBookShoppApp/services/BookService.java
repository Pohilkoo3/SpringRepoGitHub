package com.example.MyBookShoppApp.services;

import com.example.MyBookShoppApp.dao.BooksDao;
import com.example.MyBookShoppApp.model.oldEntity.Book;
import com.example.MyBookShoppApp.responseEntity.PagingBooksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.net.ContentHandler;
import java.util.Date;
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

    /** Book's DAO for APIBook'sController**/

    public List<Book> getBooksDataByAuthor(String authorsName)
    {
        return booksDao.getBooksDataByAuthor(authorsName);
    }

    public List<Book> getBooksDataByTitle(String title){
        return  booksDao.getBooksDataByTitle(title);
    }

    public List<Book> getBooksDataByPriceBetween(int min, int max){
        return  booksDao.getBooksDataByPriceBetween(min, max);
    }

    public List<Book> getBooksDataByPriceIs(int price){
        return  booksDao.getBooksDataByPriceIs(price);
    }

    public List<Book> getBestsellers(){
        return  booksDao.getBestsellers();
    }

    public List<Book> getBooksMaxDiscount(){
        return  booksDao.getBooksMaxDiscount();
    }

    public Page<Book> getPageOfRecommendedBooks(Integer offset, Integer limit){
       return booksDao.getBooksPaging(offset, limit);
    }

    public Page<Book> getPageOfSearchResult(String search, Integer offset, Integer limit)
    {
        return booksDao.getPageOfSearchResult(search, offset, limit);
    }

    public Page<Book> getNewBooks(Date dateFrom, Date dateTo, Integer offset, Integer limit){
        return booksDao.getNewBooks(dateFrom, dateTo, offset, limit);
    }

    public Page<Book> getPopularBooks(Integer offset, Integer limit) {
        return booksDao.getPopularBooks(offset, limit);
    }

    public Page<Book> getBooksByGenreId(Integer id, Integer offset, Integer limit)
    {
        return booksDao.getBooksByGenreId(id, offset, limit);
    }

    public Page<Book> getBooksByTagsId(Integer tagsId, Integer offset, Integer limit){
       return booksDao.getBooksByTagsId(tagsId, offset, limit);
    }

    public Page getPagePopularBook(int offset, int limit) {
    return booksDao.getPagePopularBooks(offset, limit);
    }

    public Page<Book> getBooksDataByAuthorId(Integer idAuthor, int offset, int limit)
    {
       return booksDao.getBooksByAuthorId(idAuthor, offset, limit);
    }


}
