package com.example.database;

import com.example.model.Basket;
import com.example.model.Card;
import com.example.model.Product;
import com.example.model.User;
import com.example.model.enums.AppLanguage;
import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DatabaseObjects {
    public static List<User> users = new ArrayList<>();
    public static List<Basket> baskets = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<Card> cards = new ArrayList<>();

    static {
//        loadAllUsers();
    }

    private static void loadAllUsers() {

        User user = null;
        try {
            FileInputStream fis = new FileInputStream("users.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            if (ois.available() != -1){
                user = (User) ois.readObject();
                while (user != null) {
                    users.add(user);
                    user = (User) ois.readObject();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @SneakyThrows
    public static void saveAllUsers() {
        FileOutputStream fos = new FileOutputStream("users.txt");
        ObjectOutputStream ois = new ObjectOutputStream(fos);
        for (User user : users) {
            ois.writeObject(user);
        }
    }


    public static Scanner inNum = new Scanner(System.in);
    public static Scanner inTxt = new Scanner(System.in);


    public static Map<String, String> languageMap = Map.of(
            "ENG_REGISTER", "PLEASE REGISTER OR LOGIN FIRST!\n1. REGISTER \n2. LOGIN\n3. CHOOSE ANOTHER LANGUAGE",
            "RUS_REGISTER", "Пожалуйста регистрируйте или сделайте логин!\n1. РЕГИСТРАТЦИЯ \n2. ЛОГИН\n3. ИЗМЕНИТЬ ЯЗЫК",
            "UZB_REGISTER", "Iltimos registratsiyadan o'ting yoki login qiling!\n1. REGISTRATSIYA \n2. LOGIN\n3. TILNI ALISHTIRISH",
            "ENG_REGISTER_CHOICE", "Enter your fullname:_Enter your phone number:_Enter your password:_Are you developer ? (y/n):",
            "RUS_REGISTER_CHOICE", "Введите ваш имя фамилия:_Введите ваш номер:_Введите ваш пароль:_А вы программисты? (y/n):",
            "UZB_REGISTER_CHOICE", "Toliq ismizni kiriting:_Raqamizni kiriting:_Parolizni kiriting:_Siz dasturchimisiz ? (y/n):",
            "ENG_REGISTER_SUCCESS", "You successfully registered in the system!",
            "RUS_REGISTER_SUCCESS", "Вы успешно регисьрирован нашего сервера!",
            "UZB_REGISTER_SUCCESS", "Foydalanuvchi muvaffaqiyatli ro'yxatdan o'tdi!"
    );
    public static Map<String, String> developerMenu = Map.of(
            "UZB_DEVELOPER_MENU", "1. Maxsulotni sotuvga qo'yish_2. Maxsulotni statusini o'zgartirish_3. Karta balansini tekshirish_4. Tizimdan chiqish",
            "ENG_DEVELOPER_MENU", "1. Add product to the Market_2. Change status of the product_3. Check balance of the credit card_4. Exit system",
            "RUS_DEVELOPER_MENU", "1. Добавить продукт на рынок_2. Изменить статус продукты_3. Проверить баланс карты_4. Выход из системы",
            "UZB_DEVELOPER_MENU_CATEGORY", "Maxsulotni nomini kiriting:_Maxsulotni narxini kiriting:_Maxsulot muvaffaqiyatli qo'shildi!",
            "RUS_DEVELOPER_MENU_CATEGORY", "Введите имя продукт:_Введите цена продукт:_Продукт добавлено без проблем!",
            "ENG_DEVELOPER_MENU_CATEGORY", "Enter the name of the product:_Enter the price of the product:_Product added successfully!"
    );

    public static Map<String, String> logoutMenu = Map.of(
            "UZB_LOGOUT_MENU", "Siz tizimdan muvaffaqiyatli chiqib ketdingiz!",
            "RUS_LOGOUT_MENU", "Вы логгед оут!",
            "ENG_LOGOUT_MENU", "You successfully logget out!"
    );
    public static Map<String, String> userNotFoundMenu = Map.of(
            "UZB_USER_NOT_FOUND_MENU", "Bunday foydalanuvchi topilmadi!",
            "RUS_USER_NOT_FOUND_MENU", "Нет информации такого юзера!",
            "ENG_USER_NOT_FOUND_MENU", "User not found with these details!"
    );

    public static Map<String, String> businessMenu = Map.of(
            "UZB_BUSINESSMAN_MENU", "1. Maxsulotlarni ko'rish_2. Karta balansini tekshirish_3. Tizimdan chiqish",
            "ENG_BUSINESSMAN_MENU", "1. Show the products_2. Check the card balance_3. Exit system",
            "RUS_BUSINESSMAN_MENU", "1. Все продукты из маркет_2. Проверить баланс на карту_3. Выход из системы"
    );

    public static AppLanguage appLanguage = null;


}
