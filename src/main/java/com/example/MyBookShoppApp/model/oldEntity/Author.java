package com.example.MyBookShoppApp.model.oldEntity;


import com.example.MyBookShoppApp.model.book.links.Book2AuthorEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "data model of author entity")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "author id generated by db", position = 1)
    private Integer id;

    @Column(columnDefinition = "character varying(255)")
    @ApiModelProperty(value = "author's photo", example = "http://www.linkPhoto's.com", position = 3)
    private String photo;
    @Column(columnDefinition = "character varying(255)")
    @ApiModelProperty(value = "slug", position = 4)
    private String slug;
    @Column(nullable = false, columnDefinition = "character varying(255)")
    @ApiModelProperty(value = "author's name", example = "Fedor Dostoevskiy", position = 2)
    private String name;

    @Column(columnDefinition = "text")
    @ApiModelProperty(value = "description author's biography", position = 5)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "pk.author")
    private Set<Book2AuthorEntity> book2AuthorEntitySet = new HashSet<>();

    @Override
    public String toString() {
        return name;
    }

}


