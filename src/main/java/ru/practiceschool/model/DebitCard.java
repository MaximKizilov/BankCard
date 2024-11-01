package ru.practiceschool.model;

public class DebitCard extends BankCard {

    public DebitCard(double balance) {
        super(balance);
    }

    @Override
    public boolean pay(double amount) {
        if (amount > balance || amount <= 0) {
            return false;
        } else balance -= amount;
        return true;
    }

    public boolean topUp(double amount) {
        if (amount <= 0) {
            return false;
        } else balance += amount;
        return true;

    }
}
