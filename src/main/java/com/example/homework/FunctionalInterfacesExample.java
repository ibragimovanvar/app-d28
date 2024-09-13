package com.example.homework;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesExample {
    public static void main(String[] args) {

        Supplier<Person> personSupplier = () -> new Programmer(15, "Orifjon");
        Consumer<Person> personConsumer = (p) -> System.out.println(p);

        System.out.println(personSupplier.get());

        personConsumer.accept(new Programmer(12, "Abdujalil"));

        Predicate<Integer> integerPredicate = (integer) -> integer > 15;
        System.out.println(integerPredicate.test(13));


        Function<Integer, Programmer> function = (i) -> {
            Programmer programmer = new Programmer(i, "");
            programmer.setAge(i);
            programmer.setName("Firdavs");
            return programmer;
        };
        System.out.println(function.apply(17));
    }
}
