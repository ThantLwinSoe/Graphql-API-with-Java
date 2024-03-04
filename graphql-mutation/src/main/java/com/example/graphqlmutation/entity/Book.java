package com.example.graphqlmutation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer pages;
    private String author;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    public Book(String title,Integer pages,String author) {
            this.title = title;
            this.pages = pages;
            this.author = author;
    }

    public void addReview(Review review) {
        review.setBook(this);
        this.reviews.add(review);
    }

}
