package com.example.MyBookShoppApp.data;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class Author {

    private Integer id;
    private String firstName;
    private String lastName;
}
