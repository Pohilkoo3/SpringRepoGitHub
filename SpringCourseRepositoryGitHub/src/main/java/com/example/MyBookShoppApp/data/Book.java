package com.example.MyBookShoppApp.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class Book {
    private Integer id;

    private String author;
    private String title;
    private String priceOld;
    private String price;


}
