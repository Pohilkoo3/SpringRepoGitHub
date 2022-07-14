package com.example.MyBookShoppApp.model.user;

import com.example.MyBookShoppApp.model.book.file.FileDownloadEntity;
import com.example.MyBookShoppApp.model.book.links.Book2UserEntity;
import com.example.MyBookShoppApp.model.book.review.BookReviewEntity;
import com.example.MyBookShoppApp.model.book.review.BookReviewLikeEntity;
import com.example.MyBookShoppApp.model.book.review.MessageEntity;
import com.example.MyBookShoppApp.model.oldEntity.Book;
import com.example.MyBookShoppApp.model.payments.BalanceTransactionEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String hash;

    @Column(columnDefinition = "date NOT NULL")
    private LocalDateTime regTime;

    @Column(columnDefinition = "INT NOT NULL")
    private int balance;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private UserContactEntity userContact;

    @OneToMany(mappedBy = "pk.user", cascade = CascadeType.ALL)
    private Set<Book2UserEntity> book2UserEntitySet = new HashSet<>(0);

    @OneToMany(mappedBy = "pk.user", cascade = CascadeType.ALL)
    private Set<FileDownloadEntity> fileDownloadEntitySet = new HashSet<>(0);

    @OneToMany(mappedBy = "pk.user", cascade = CascadeType.ALL)
    private Set<BalanceTransactionEntity> balanceTransactionEntities = new HashSet<>(0);

    @OneToMany(mappedBy = "pk.user", cascade = CascadeType.ALL)
    private Set<BookReviewEntity> bookReviewEntitySet = new HashSet<>(0);

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<MessageEntity> messagesSet = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<BookReviewLikeEntity> bookReviewLikeEntitySet = new HashSet<>();


}
