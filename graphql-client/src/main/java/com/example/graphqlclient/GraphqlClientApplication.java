package com.example.graphqlclient;

import com.example.graphqlclient.ds.Country;
import com.example.graphqlclient.repo.CountryRepository;
import com.example.graphqlclient.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
public class GraphqlClientApplication {

    @Bean
    public CommandLineRunner commandLineRunner(CountryService service, CountryRepository repository) {
        return r ->{
            Mono<List<Country>> countries = service.getCountries();
            countries.subscribe(repository::saveAll);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(GraphqlClientApplication.class, args);
    }

}
