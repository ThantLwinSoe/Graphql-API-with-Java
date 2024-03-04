package com.example.graphqlmutation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String comment;
    @ManyToOne
    private Book book;

    public  Review() {}

    public Review(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }
}
