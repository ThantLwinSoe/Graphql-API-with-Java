package com.example.graphqlcrud.repo;

import com.example.graphqlcrud.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CoffeeRepository extends JpaRepository<Coffee,Integer> {
}
