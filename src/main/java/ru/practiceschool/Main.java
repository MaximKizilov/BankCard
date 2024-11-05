package ru.practiceschool;

import ru.practiceschool.model.CreditCard;
import ru.practiceschool.model.DebitCard;
import ru.practiceschool.specification.DebitCardBonus;

public class Main {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard(1000, 5000);
        creditCard.topUp(200);
        creditCard.pay(6500);
        creditCard.topUp(400);


        DebitCard debitCard = new DebitCardBonus(1000.00, 100.00);
        debitCard.topUp(5000);
        debitCard.pay(100);
        debitCard.pay(5000, 100);
        System.out.println(debitCard.getAvailableCapital());
    }
}