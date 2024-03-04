package com.example.authorgraphql.model;

public record Book(
        Integer id,
        String title,
        Integer pages,
        Rating rating,
        Author author
) {
}
