package com.example.graphqlcrud;

import com.example.graphqlcrud.entity.Coffee;
import com.example.graphqlcrud.entity.Size;
import com.example.graphqlcrud.repo.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@RequiredArgsConstructor
public class GraphqlCrudApplication {

    private final CoffeeRepository coffeeRepository;

    @Bean
    @Profile("test")
    public ApplicationRunner runner() {

        return r -> {
            Coffee coffee1 = new Coffee("Latte", Size.LARGE);
            Coffee coffee2 = new Coffee("Cappuccino", Size.LARGE);

            coffeeRepository.save(coffee1);
            coffeeRepository.save(coffee2);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(GraphqlCrudApplication.class, args);
    }

}
