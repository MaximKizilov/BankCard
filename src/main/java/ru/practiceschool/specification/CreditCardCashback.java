package ru.practiceschool.specification;

import ru.practiceschool.model.CreditCard;


public class CreditCardCashback extends CreditCard {
    private static final double CASHBACK = 0.05;
    public CreditCardCashback(double balance, double creditLimit) {
        super(balance, creditLimit);
    }

    @Override
    public boolean pay(double amount) {
            if (amount <= 0) {
                return false;
            } else if (amount > getCreditBalance() + getBalance()) {
                return false;
            } else if (getBalance() < amount) {
                double difference = amount -  getBalance();
                if (getBalance() >= 5000.00) {
                    setBalance(getBalance() * CASHBACK);
                } else {
                    setBalance(0);
                }
                   setCreditBalance(getCreditBalance() - difference);
                    return true;
                } else {
                setBalance(amount>=5000.00? getBalance() - (amount * (1.00 - CASHBACK)):getBalance()-amount);
            return true;
            }
        }
    }

