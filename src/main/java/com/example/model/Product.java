package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    private static long counterId = 1;
    private long id;
    private String name;
    private int price;
    private User userOwner;
    private boolean active;


    public Product(String name, int price, User userOwner) {
        this.id = counterId++;
        this.name = name;
        this.price = price;
        this.userOwner = userOwner;
        this.active = true;
    }
}
