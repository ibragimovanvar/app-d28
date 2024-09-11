package com.example.working_with_files;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;

public class BufferedFileReaderExample {

    @SneakyThrows
    public static void main(String[] args) {

        FileReader fileReader = new FileReader("file_example.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine();
        while (line != null){
            System.out.print(line);
            line = bufferedReader.readLine();
        }

        System.out.println();
        System.out.println("Filedagi malumot buferga olib oqildi!");
    }
}
