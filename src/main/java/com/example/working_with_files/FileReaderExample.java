package com.example.working_with_files;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.FileWriter;

public class FileReaderExample {

    @SneakyThrows
    public static void main(String[] args) {

        FileReader fileReader = new FileReader("file_example.txt");

        int byteBelgi = fileReader.read();
        while (byteBelgi != -1){
            System.out.print((char) byteBelgi);
            byteBelgi = fileReader.read();
        }

        fileReader.close();
        System.out.println();
        System.out.println("Filedagi malumot oqildi!");

    }
}
