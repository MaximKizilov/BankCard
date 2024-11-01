package ru.practiceschool.model;


import java.text.NumberFormat;
import java.util.Locale;

public abstract class BankCard {
    protected double balance;

    public BankCard(double balance) {
        if (balance > 0) {
            this.balance = balance;
        }
    }

    public String getBalance() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
        return "Баланс по карте: " + nf.format(String.format("%.2f", balance)) ;
    }

    public abstract boolean pay(double amount);

}
