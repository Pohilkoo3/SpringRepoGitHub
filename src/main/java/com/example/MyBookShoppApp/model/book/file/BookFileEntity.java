package com.example.MyBookShoppApp.model.book.file;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "book_file")
public class BookFileEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String hash;

    @Column(name = "type_id", nullable = false)
    private Integer typeId;

    @Column(nullable = false)
    private String path;


}
