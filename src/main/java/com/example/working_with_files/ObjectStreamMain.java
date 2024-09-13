package com.example.working_with_files;

import com.example.model.User;
import com.example.model.enums.Role;
import lombok.SneakyThrows;

import java.io.*;

public class ObjectStreamMain {

    @SneakyThrows
    public static void main(String[] args) {

        User user = new User("Abdujalil",
                "+998 99 099 99 99",
                "Admin_123",
                Role.DEVELOPER);

        FileOutputStream fos = new FileOutputStream("users.txt");
        ObjectOutputStream ous = new ObjectOutputStream(fos);

        ous.writeObject(user);
        System.out.println("Foydalanuvchi malumoti object sifatida faylga yozildi!");

        FileInputStream fis = new FileInputStream("users.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        User inputUser = (User) ois.readObject();
        System.out.println(inputUser.getFullName() + " | " + inputUser.getPhoneNumber());
    }
}
