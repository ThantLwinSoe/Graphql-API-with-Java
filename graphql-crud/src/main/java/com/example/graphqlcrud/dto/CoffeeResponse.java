package com.example.graphqlcrud.dto;

import com.example.graphqlcrud.entity.Size;


public record CoffeeResponse(
        Integer id,
        String name,
        Size size
) {

}
