package com.example.lesson;

import com.example.exceptions.StudentNotFoundException;

public class CustomExceptionExample {
    public static void main(String[] args) throws StudentNotFoundException {

        String[] students = new String[]{
                "Firdavs", "Abdujalil", "Farangiz", "Akmal"
        };

        boolean topildi = false;

        for (String student : students) {
            if (student.equals("Abdushukur")) {
                topildi = true;
            }
        }


        if (topildi) {
            System.out.println("Qidirilgan o'quvchi bor!");
        } else {
            throw new StudentNotFoundException("Student not found with name ");
        }


        System.out.println("Dastur ishini tugatdi!");

    }
}
