package com.example.graphqlmutation.controller;

import com.example.graphqlmutation.ds.BookInput;
import com.example.graphqlmutation.entity.Book;
import com.example.graphqlmutation.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @QueryMapping
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @MutationMapping
    public List<Book> batchCreate(@Argument List<BookInput> books) {
        return books.stream()
                .map( bi -> new Book(bi.title(),
                        bi.pages(),bi.author()))
                .map(bookRepository::save)
                .collect(Collectors.toList());
    }

    @MutationMapping
    public Book addBook(@Argument BookInput bookInput) {
        var book = new Book(bookInput.title(),bookInput.pages(),bookInput.author());
        return book;
    }

    @MutationMapping
    public Book createBook(@Argument String title,
                           @Argument Integer pages,
                           @Argument String author
                           ) {
        var book1 = new Book(title,pages,author);
        return bookRepository.save(book1);
    }
}
