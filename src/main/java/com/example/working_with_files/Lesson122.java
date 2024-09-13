package com.example.working_with_files;

import java.io.File;

public class Lesson122 {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\techn\\OneDrive\\Desktop\\Very important things");

        File[] dirFiles = file.listFiles();
        if (dirFiles != null) {
            for (File dirFile : dirFiles) {
                deleteFile(dirFile);
            }
        }

        getDirectoriesAndFiles();

    }

    public static void deleteFile(File file){
        if(file.delete()){
            System.out.println("File named " + file.getName() + " deleted successfully !");
        }else {
            System.out.println("File named " + file.getName() +" not found!");
        }
    }

    public static void getDirectoriesAndFiles() {
        String directoryPath = "C:\\Users\\techn\\OneDrive\\Desktop";
        File cDirectory = new File(directoryPath);

        File[] cDirFiles = cDirectory.listFiles();

        if (cDirFiles != null) {
            for (File file : cDirFiles) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Papka: " + file.getName());
                }
            }
        }
    }
}
