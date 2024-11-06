package ru.practiceschool.model;


import java.text.NumberFormat;
import java.util.Locale;

abstract class BankCard {
    private double balance;

    public BankCard(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Баланс должен быть положительным.");
        }
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAvailableCapital() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
        return "Баланс по карте: " + nf.format(getBalance());
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    protected abstract boolean pay(double amount);

}
