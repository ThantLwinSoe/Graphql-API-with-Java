package com.example.authorgraphql.repository;

import com.example.authorgraphql.model.Book;
import com.example.authorgraphql.model.Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final AuthorRepository authorRepository;

    private List<Book> books=new ArrayList<>();

    public List<Book> findAll(){
        return books;
    }
    public Book findOne(Integer id){
        return books.stream()
                .filter(b -> b.id() == id)
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Book not found!"));
    }
    @PostConstruct
    private void init(){
        books.add(new Book(
                1,
                "Reactive Spring",
                485,
                Rating.FIVE_STARS,
                authorRepository.findByName("Josh Long")
        ));
        books.add(
                new Book(
                        2,
                        "Spring Boot Up",
                        328,
                        Rating.FIVE_STARS,
                        authorRepository.findByName("Mark Heckler")
                )
        );
        books.add(
                new Book(
                        3,
                        "Hacking with Spring Boot 2.3",
                        392,
                        Rating.FIVE_STARS,
                        authorRepository.findByName("Greg Turnquist")
                )
        );
    }

}













