package com.example.graphqlclient.repo;

import com.example.graphqlclient.ds.Country;
import org.springframework.data.repository.ListCrudRepository;

public interface CountryRepository extends ListCrudRepository<Country,Integer> {


}
