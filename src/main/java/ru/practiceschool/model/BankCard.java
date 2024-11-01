package ru.practiceschool.model;


import java.text.NumberFormat;
import java.util.Locale;

abstract class BankCard {
    protected double balance;

    protected BankCard(double balance) {
        if (balance > 0) {
            this.balance = balance;
        }
    }

    protected String getBalance() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
        return "Баланс по карте: " + nf.format(String.format("%.2f", balance)) ;
    }

    protected String getAvailableCapital(){
        return getBalance();
    }


    protected abstract boolean pay(double amount);

}
