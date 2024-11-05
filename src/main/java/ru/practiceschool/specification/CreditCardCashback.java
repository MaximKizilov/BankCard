package ru.practiceschool.specification;

import ru.practiceschool.model.CreditCard;
import ru.practiceschool.model.DebitCard;

public class CreditCardCashback extends CreditCard {
    public CreditCardCashback(double balance, double creditLimit) {
        super(balance, creditLimit);
    }
}
