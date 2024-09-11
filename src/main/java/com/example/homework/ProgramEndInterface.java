package com.example.homework;

@FunctionalInterface
public interface ProgramEndInterface {

    Integer len = 10;

    long end(long startTime, long endTime);

    default void prettyPrint(){
        System.out.println("Len 1: " + len);
        System.out.println("Len 2: " + len + 10);
        System.out.println("Len 3: " + len + 20);
    }

    static void printInfo(){
        System.out.println("Info:");
    }
}
