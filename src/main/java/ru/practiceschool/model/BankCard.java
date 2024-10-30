package ru.practiceschool.model;

import java.util.List;

public abstract class BankCard {
    protected double balance;

    public BankCard(double balance) {
        if (balance > 0) {
            this.balance = balance;
        }
    }

    public String getBalance() {
        return "Баланс по карте: " + String.format("%.2f", balance);
    }

    public abstract boolean pay(double amount);

}
