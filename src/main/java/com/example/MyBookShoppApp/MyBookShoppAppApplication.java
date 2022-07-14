package com.example.MyBookShoppApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:spring-frontend/lang/messages_ru.properties")
public class MyBookShoppAppApplication {

	public static void main(String[] args) {
		//Hello
		SpringApplication.run(MyBookShoppAppApplication.class, args);
	}

}
