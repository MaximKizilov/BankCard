package ru.practiceschool.model;


public class DebitCard extends BankCard {

    public DebitCard(double balance) {
        super(balance);
    }

    // дефолтный метод
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

    public boolean pay(double v, double v1) {
        return false;
    }
}
