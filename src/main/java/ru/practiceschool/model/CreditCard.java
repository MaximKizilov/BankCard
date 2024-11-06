package ru.practiceschool.model;


import java.text.NumberFormat;
import java.util.Locale;

public class CreditCard extends BankCard {
    private final double creditLimit;
    private double creditBalance;

    public CreditCard(double balance, double creditLimit) {
        super(balance);
        this.creditLimit = creditLimit;
        this.creditBalance = creditLimit;
    }


    @Override
    public boolean pay(double amount) {
        if (amount > creditBalance + getBalance() || amount <= 0) {
            return false;
        } else if (getBalance() < amount) {
            double difference = amount - getBalance();
            setBalance(0);
            creditBalance -= difference;
            return true;
        } setBalance(getBalance() - amount);
        return true;
    }

    public boolean topUp(double amount) {
        if (amount <= 0) {
            return false;
        }
        double difference = creditLimit - creditBalance;
        if (difference >= amount) {
            creditBalance += amount;
            return true;
        } else if (difference != 0.0) {
            creditBalance += difference;
            setBalance(getBalance() + (amount - difference));
            return true;
        } else setBalance(getBalance() + amount);
        return true;
    }

    @Override
    public String getAvailableCapital() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
        return "Собственные средства: " + nf.format(getBalance()) + "\n" +
                "Кредитные средства: " + nf.format(creditBalance);
    }

    public double getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(double creditBalance) {
        this.creditBalance = creditBalance;
    }
}
