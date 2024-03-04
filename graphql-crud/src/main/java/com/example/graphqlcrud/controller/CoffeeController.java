package com.example.graphqlcrud.controller;

import com.example.graphqlcrud.dto.CoffeeRequest;
import com.example.graphqlcrud.dto.CoffeeResponse;
import com.example.graphqlcrud.entity.Size;
import com.example.graphqlcrud.repo.CoffeeRepository;
import com.example.graphqlcrud.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CoffeeController {

    public final CoffeeService coffeeService;

    @QueryMapping
    public List<CoffeeResponse> findAllCoffee() {
        return coffeeService.getCoffeeResponses();
    }

    @QueryMapping
    public CoffeeResponse findOneCoffee(@Argument Integer id) {
        return coffeeService.findOne(id);
    }

    @MutationMapping
    public CoffeeResponse create(@Argument CoffeeRequest coffeeRequest){
        return coffeeService.createCoffee(coffeeRequest);
   }

   @MutationMapping
   public CoffeeResponse update(@Argument Integer id ,
                                @Argument Size size){

        return coffeeService.changeCoffeeSize(id, size);

   }

   @MutationMapping
   public Boolean delete(@Argument Integer id){
        return coffeeService.deleteCoffeeById(id);
   }

}
