package com.example;

import com.example.database.DatabaseObjects;
import com.example.model.Product;
import com.example.model.User;
import com.example.model.enums.Role;

import static com.example.database.DatabaseObjects.*;

public class ProgramRun {
    public static void main(String[] args) {

        while (true) {
            chooseLanguage();

            String langPrefix = appLanguage.toString();
            System.out.println(languageMap.get(langPrefix + "_REGISTER"));
            int registerChoice = inNum.nextInt();

            registerQism:
            switch (registerChoice) {
                case 1 -> {
                    registerUser(langPrefix);
                }
                case 2 -> {
                    loginUserAndShowMenu(langPrefix);
                }
                case 3 -> {
                    appLanguage = null;
                }
                default ->{
                    System.exit(1);
                }
            }
        }

    }

    private static void chooseLanguage() {
        if (appLanguage == null) {
            System.out.println("Qaysi tilni tanlamoqchisiz:");
            for (int i = 0; i < appLanguage.values().length; i++) {
                System.out.println(i + 1 + "." + appLanguage.values()[i]);
            }
            int languageChoice = inNum.nextInt();
            appLanguage = appLanguage.values()[languageChoice - 1];
        }

    }

    private static void loginUserAndShowMenu(String langPrefix) {
        System.out.print(languageMap.get(langPrefix + "_REGISTER_CHOICE").split("_")[1]);
        String phoneNumber = inTxt.nextLine();
        System.out.print(languageMap.get(langPrefix + "_REGISTER_CHOICE").split("_")[2]);
        String password = inTxt.nextLine();
        User loggedUser = null;
        for (User user : DatabaseObjects.users) {
            if (user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password)) {
                loggedUser = user;
            }
        }

        if (loggedUser != null) {
            while (true) {
                switch (loggedUser.getRole()) {
                    case DEVELOPER -> {
                        System.out.println(developerMenu.get(langPrefix + "_DEVELOPER_MENU").split("_")[0]);
                        System.out.println(developerMenu.get(langPrefix + "_DEVELOPER_MENU").split("_")[1]);
                        System.out.println(developerMenu.get(langPrefix + "_DEVELOPER_MENU").split("_")[2]);
                        System.out.println(developerMenu.get(langPrefix + "_DEVELOPER_MENU").split("_")[3]);
                        System.out.print("----------> ");
                        int choice = inNum.nextInt();
                        switch (choice) {
                            case 1 -> {
                                System.out.print(developerMenu.get(langPrefix + "_DEVELOPER_MENU_CATEGORY").split("_")[0]);
                                String productName = inTxt.nextLine();
                                System.out.print(developerMenu.get(langPrefix + "_DEVELOPER_MENU_CATEGORY").split("_")[1]);
                                int productPrice = inNum.nextInt();
                                Product product = new Product(productName, productPrice, loggedUser);
                                DatabaseObjects.products.add(product);
                                System.out.println(developerMenu.get(langPrefix + "_DEVELOPER_MENU_CATEGORY").split("_")[2]);
                            }
                            case 2 -> {

                            }
                            case 4 -> {
                                System.out.println(developerMenu.get(langPrefix + "_LOGOUT_MENU").split("_")[0]);
//                                break registerQism;
                            }
                        }
                    }
                    case BUSINESS_OWNER -> {
                        String[] menuItems = businessMenu.get(langPrefix + "_BUSINESSMAN_MENU").split("_");
                        System.out.println(menuItems[0]);
                        System.out.println(menuItems[1]);
                        System.out.println(menuItems[2]);
                        System.out.print("----------> ");
                        int choice = inNum.nextInt();
                        switch (choice) {
                            case 1 -> {
                                for (Product product : DatabaseObjects.products) {
                                    System.out.print(product.getId() + " | ");
                                    System.out.print(product.getName());
                                    System.out.print(" | " + product.getPrice());
                                    System.out.print(" | " + product.getUserOwner().getFullName());
                                    System.out.print(" | " + product.getUserOwner().getPhoneNumber());
                                    System.out.print(" | " + (product.isActive() ? "✅" : "❌"));
                                }
                                System.out.println();
                            }
                            case 3 -> {
                                System.out.println(logoutMenu.get(langPrefix + "_LOGOUT_MENU"));
//                                break registerQism;
                            }
                        }
                    }
                }

            }
        } else {
            System.out.println(userNotFoundMenu.get(langPrefix + "_USER_NOT_FOUND_MENU"));
        }
    }

    private static void registerUser(String langPrefix){
        System.out.print(languageMap.get(langPrefix + "_REGISTER_CHOICE").split("_")[0]);
        String fullName = inTxt.nextLine();
        System.out.print(languageMap.get(langPrefix + "_REGISTER_CHOICE").split("_")[1]);
        String phoneNumber = inTxt.nextLine();
        System.out.print(languageMap.get(langPrefix + "_REGISTER_CHOICE").split("_")[2]);
        String password = inTxt.nextLine();
        System.out.print(languageMap.get(langPrefix + "_REGISTER_CHOICE").split("_")[3]);
        String role = inTxt.nextLine();
        Role userRole;
        if (role.equals("y")) {
            userRole = Role.DEVELOPER;
        } else {
            userRole = Role.BUSINESS_OWNER;
        }
        User user = new User(fullName, phoneNumber, password, userRole);
        DatabaseObjects.users.add(user);
        System.out.println(languageMap.get(langPrefix + "_REGISTER_SUCCESS"));
    }
}