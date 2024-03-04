package com.example.graphqlcrud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Size size;

    public Coffee(){

    }

    public Coffee(String name,Size size){
        this.name = name;
        this.size = size;
    }
}
