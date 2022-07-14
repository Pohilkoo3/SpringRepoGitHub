package com.example.MyBookShoppApp.model.book.review;

import com.example.MyBookShoppApp.keys.BookUserId;
import com.example.MyBookShoppApp.model.oldEntity.Book;
import com.example.MyBookShoppApp.model.user.UserEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "book_review")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class BookReviewEntity implements Serializable {

    @EmbeddedId
    private BookUserId pk;

    @Column(columnDefinition = "date NOT NULL")
    private LocalDateTime time;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String text;

    public Book getBook() {
        return getPk().getBook();
    }

    public UserEntity getUserEntity() {
        return getPk().getUser();
    }

    public void setBook(Book book){
        getPk().setBook(book);
    }

    public void setUser(UserEntity user){
        getPk().setUser(user);
    }
}
