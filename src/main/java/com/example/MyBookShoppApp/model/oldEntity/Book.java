package com.example.MyBookShoppApp.model.oldEntity;

import com.example.MyBookShoppApp.model.book.file.FileDownloadEntity;
import com.example.MyBookShoppApp.model.book.links.Book2AuthorEntity;
import com.example.MyBookShoppApp.model.book.links.Book2GenreEntity;
import com.example.MyBookShoppApp.model.book.links.Book2UserEntity;
import com.example.MyBookShoppApp.model.book.review.BookReviewEntity;
import com.example.MyBookShoppApp.model.genre.GenreEntity;
import com.example.MyBookShoppApp.model.oldEntity.Author;
import com.example.MyBookShoppApp.model.payments.BalanceTransactionEntity;
import com.example.MyBookShoppApp.model.tags.Tag;
import com.example.MyBookShoppApp.model.user.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "book")
@NoArgsConstructor
@ApiModel(description = "data model of book's entity")
public class Book implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id generated bi db")
    private Long id;

    @Column(name = "pub_date", columnDefinition = "date")
    @ApiModelProperty(value = "date of publication", example = "2002,12,24")
    private Date pubDate;

    @Column(name = "is_bestseller", columnDefinition = "smallint")
    @ApiModelProperty(value = "is bestseller? 0 or 1. 0- isn't bestseller")
    private Integer isBestseller;

    @Column(columnDefinition = "character varying(255)")
    private String slug;

    @Column(columnDefinition = "character varying(255)")
    private String title;

    @Column(columnDefinition = "character varying(255)")
    private String image;

    @Column(columnDefinition = "text")
    private String description;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false, columnDefinition = "smallint")
    @ColumnDefault("0")
    private Integer discount;

    @Transient
    private String authors;

    @OneToMany(mappedBy = "pk.book", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Book2AuthorEntity> book2AuthorEntitySet = new HashSet<>(0);

    @OneToMany(mappedBy = "pk.book", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Book2GenreEntity> book2GenreEntitySet = new HashSet<>(0);

    @OneToMany(mappedBy = "pk.book")
    @JsonIgnore
    private Set<Book2UserEntity> book2UserEntitySet = new HashSet<>(0);

    @OneToMany(mappedBy = "pk.book", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<FileDownloadEntity> fileDownloadEntitySet = new HashSet<>(0);

    @OneToMany(mappedBy = "pk.book")
    @JsonIgnore
    private Set<BalanceTransactionEntity> balanceTransactionEntities = new HashSet<>(0);

    @OneToMany(mappedBy = "pk.book")
    @JsonIgnore
    private Set<BookReviewEntity> bookReviewEntitySet = new HashSet<>(0);

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "book2tag",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tagSet = new HashSet<>(0);
}
