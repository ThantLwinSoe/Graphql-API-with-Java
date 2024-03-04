package com.example.authorgraphql.controller;

import com.example.authorgraphql.model.Book;
import com.example.authorgraphql.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

   // @SchemaMapping(typeName = "Query",value = "allBooks")
   @QueryMapping
    public List<Book> allBooks(){
        return bookRepository.findAll();
    }
}
