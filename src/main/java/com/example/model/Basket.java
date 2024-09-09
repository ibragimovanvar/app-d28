package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Basket {
    private static long counterId = 1;
    private Long id;
    private List<Product> products;
    private User owner;

    public Basket(List<Product> products, User owner) {
        this.id = counterId++;
        this.products = products;
        this.owner = owner;
    }
}
