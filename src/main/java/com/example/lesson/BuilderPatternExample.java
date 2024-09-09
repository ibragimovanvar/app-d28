package com.example.lesson;

public class BuilderPatternExample {

    public static void main(String[] args) {

        Person person1 = Person.builder()
                .age(15)
                .name("Orifjon")
                .workspace("PDP Junior")
                .build();

        Person person2 = Person.builder()
                .cardNumber("12345657898765432")
                .workspace("Workspace 2")
                .salary(1231435678)
                .build();

        System.out.println(person1);
        System.out.println(person2);
    }
}
