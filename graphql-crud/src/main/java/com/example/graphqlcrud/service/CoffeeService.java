package com.example.graphqlcrud.service;

import com.example.graphqlcrud.dto.CoffeeRequest;
import com.example.graphqlcrud.dto.CoffeeResponse;
import com.example.graphqlcrud.entity.Coffee;
import com.example.graphqlcrud.entity.Size;
import com.example.graphqlcrud.repo.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public List<CoffeeResponse> getCoffeeResponses() {
        return coffeeRepository.findAll()
                .stream()
                .map(c -> toDto(c))//map(this::toDto) is the same
                .collect(Collectors.toList());
    }

    public CoffeeResponse findOne(Integer id){
        return toDto( coffeeRepository.findById(id).get());
    }

    private Coffee toEntity(CoffeeRequest coffeeRequest){
        return new Coffee(coffeeRequest.name(),coffeeRequest.size());
    }

    //  Create
    public CoffeeResponse createCoffee(CoffeeRequest coffeeRequest) {
        var coffee = new Coffee(coffeeRequest.name(),coffeeRequest.size());
        coffeeRepository.save(coffee);
        return toDto(coffee);
    }

    // DeletebyId
    public Boolean deleteCoffeeById(Integer id){
        coffeeRepository.deleteById(id);
        return true;
    }

    //Update
    public CoffeeResponse changeCoffeeSize(Integer id, Size size){
        var coffeeResponse = findOne(id);
        coffeeRepository.saveAndFlush(new Coffee(coffeeResponse.name(),size));
        return new CoffeeResponse(id,coffeeResponse.name(),size);
    }


    public CoffeeResponse toDto(Coffee coffee) {
        return new CoffeeResponse(coffee.getId(),coffee.getName(),coffee.getSize());
    }
}
