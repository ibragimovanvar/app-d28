package com.example.homework;

public class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        ProgramStarterInterface starterInterface = () -> System.out.println("Dastur ishga tushdi!");
        starterInterface.start();

        long endTime = System.currentTimeMillis();

        ProgramEndInterface endInterface = (st, et) -> et - st;
        long duration = endInterface.end(startTime, endTime);

        endInterface.prettyPrint();
        ProgramEndInterface.printInfo();

        System.out.println(duration);

    }
}
