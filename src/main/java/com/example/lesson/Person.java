package com.example.lesson;


import lombok.*;


@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    private int age;

    private long salary;

    private String workspace;

    private String cardNumber;
}
