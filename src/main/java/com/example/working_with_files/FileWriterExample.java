package com.example.working_with_files;

import com.google.gson.Gson;
import lombok.SneakyThrows;

import java.io.FileWriter;

public class FileWriterExample {

    @SneakyThrows
    public static void main(String[] args) {

        FileWriter fileWriter = new FileWriter("file_example.txt");

        fileWriter.write("Hello World");
        fileWriter.close();

        System.out.println("Filega yozildi!");

    }
}
