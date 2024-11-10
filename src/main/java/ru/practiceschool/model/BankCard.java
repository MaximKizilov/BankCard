package ru.practiceschool.model;


import java.text.NumberFormat;
import java.util.Locale;

abstract class BankCard {
    public NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
    private double balance;

    protected BankCard(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Баланс должен быть положительным.");
        }
        this.balance = balance;
    }

    protected double getBalance() {
        return balance;
    }

    public String getAvailableCapital() {
        return "Собственные средства: " + nf.format(getBalance());
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected abstract boolean pay(double amount);

}
