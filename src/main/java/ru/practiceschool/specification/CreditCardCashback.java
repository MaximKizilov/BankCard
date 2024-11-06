package ru.practiceschool.specification;

import ru.practiceschool.model.CreditCard;


public class CreditCardCashback extends CreditCard {
    public CreditCardCashback(double balance, double creditLimit) {
        super(balance, creditLimit);
    }

    @Override
    public boolean pay(double amount) {
            if (amount <= 0) {
                return false;
            } else if (amount > creditBalance + balance) {
                return false;
            } else if (balance < amount) {
                double difference = amount - balance;
                if (balance >= 5000.00) {
                    balance = balance * 0.05;
                } else {
                    balance = 0;
                }
                    creditBalance -= difference;
                    return true;
                } else {
                balance = amount>=5000.00? balance - (amount * 0.95) :balance-amount;
            return true;
            }
        }
    }

