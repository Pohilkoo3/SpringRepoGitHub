package com.example.MyBookShoppApp.interfaces;

import com.example.MyBookShoppApp.model.oldEntity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceBookRepo extends JpaRepository<Book, Integer> {
}
