package ru.practiceschool.specification;

import ru.practiceschool.model.CreditCard;
import ru.practiceschool.model.DebitCard;

public class CreditCardCashback extends CreditCard {
    public CreditCardCashback(double balance, double creditLimit) {
        super(balance, creditLimit);
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
    }

