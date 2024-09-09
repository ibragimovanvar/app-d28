package com.example.model;

import com.example.model.enums.Bank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Card {
    private static long counterId = 1;
    private long id;
    private Bank bank;
    private int pin;
    private long cardNumber;
    public String cardDate;
    public String user;

    public Card(Bank bank, int pin, long cardNumber, String cardDate, String user) {
        this.id = counterId++;
        this.bank = bank;
        this.pin = pin;
        this.cardNumber = cardNumber;
        this.cardDate = cardDate;
        this.user = user;
    }

}
