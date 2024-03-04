package com.example.graphqlmutation;

import com.example.graphqlmutation.entity.Book;
import com.example.graphqlmutation.entity.Review;
import com.example.graphqlmutation.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@RequiredArgsConstructor
public class GraphqlMutationApplication {

    private final BookRepository bookRepository;

    @Bean
    @Transactional
    @Profile("test")
    public ApplicationRunner runner() {
        var book1 = new Book("Spring",345,"Josh Long");
        var book2 = new Book("The Stranger",666,"Alex");

        var review1 = new Review("Spring","Good to read...");
        var review2 = new Review("The Stranger", "So Good to read...!!!");
        var review3 = new Review("Novel", "Fantastic ...");
        var review4 = new Review("Novel", "Two Thumbs up...");

        book1.addReview(review1);
        book2.addReview(review2);
        book2.addReview(review3);
        book2.addReview(review4);
        return r -> {
            bookRepository.save(book1);
            bookRepository.save(book2);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(GraphqlMutationApplication.class, args);
    }

}
