package ru.practiceschool.model;


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
        if (amount > creditBalance + balance && amount <= 0) {
            return false;
        } else if (balance - amount <= 0) {
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
        if (difference > amount ) {
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
        return "Собственные средства: " + String.format("%.2f", balance) + "\n" +
                "Кредитные средства: " + String.format("%.2f", creditBalance);
    }
}