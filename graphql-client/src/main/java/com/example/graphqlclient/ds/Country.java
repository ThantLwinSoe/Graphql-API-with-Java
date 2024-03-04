package com.example.graphqlclient.ds;


import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class Country {

    @Id
    private Integer id;
    private String name;
    private String emoji;
    private  String currency;
    private  String code;
    private String capital;

}
