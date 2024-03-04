package com.example.graphqlmutation.repository;

import com.example.graphqlmutation.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Integer> {
}
