package ru.practiceschool.model;


import java.text.NumberFormat;
import java.util.Locale;

public class CreditCard extends BankCard {
    protected double creditLimit;
    private double creditBalance;

    public CreditCard(double balance, double creditLimit) {
        super(balance);
        this.creditLimit = creditLimit;
        this.creditBalance = creditLimit;
    }


    @Override
    public boolean pay(double amount) {
        if (amount > creditBalance + balance || amount <= 0) {
            return false;
        } else if (balance < amount) {
            double difference = amount - balance;
            balance = 0;
            creditBalance -= difference;
            return true;
        } else balance -= amount;
        return true;
    }

    public boolean topUp(double amount) {
        if (amount <= 0) {
            return false;
        }
        double difference = creditLimit - creditBalance;
        if (difference >= amount ) {
            creditBalance += amount;
            return true;
        } else if (difference !=0.0) {
            creditBalance += difference;
            balance = amount - difference;
            return true;
        }else balance += amount;
        return true;
    }

    @Override
    public String getBalance() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
        return "Собственные средства: " + nf.format(balance)  + "\n" +
                "Кредитные средства: " + nf.format(creditBalance);
    }
}
