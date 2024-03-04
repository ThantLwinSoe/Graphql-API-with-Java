package com.example.graphqlclient.service;

import com.example.graphqlclient.ds.Country;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CountryService {

    private final HttpGraphQlClient httpGraphQlClient;

    public CountryService() {
        WebClient client = WebClient.builder()
                .baseUrl("https://countries.trevorblades.com")
                .build();
        httpGraphQlClient = HttpGraphQlClient.builder(client).build();
    }

    public Mono<List<Country>> getCountries() {
        String document = """
                    query{
                        countries{
                            name
                            emoji
                            currency
                            code
                            capital
                        }
                    }
                """;
        Mono<List<Country>> countries = httpGraphQlClient.document(document)
                .retrieve("countries")
                .toEntityList(Country.class);
        return countries;
    }
}
