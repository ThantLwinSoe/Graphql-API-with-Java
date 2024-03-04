package com.example.graphaldemo.control;

import com.example.graphaldemo.model.Pet;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PetsController {

    @QueryMapping
    public List<Pet> pets() {
        return List.of(
                new Pet("Luna","Golden"),
                new Pet("Alex","Pink")
        );
    }
}
