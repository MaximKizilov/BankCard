package ru.practiceschool;

import ru.practiceschool.model.CreditCard;
import ru.practiceschool.model.DebitCard;
import ru.practiceschool.specification.CreditCardCashback;
import ru.practiceschool.specification.DebitCardAccumulate;
import ru.practiceschool.specification.DebitCardBonus;

public class Main {
    public static void main(String[] args) {

        DebitCard debitCard = new DebitCardBonus(1000.00, 100.00);
        debitCard.topUp(5000);
        debitCard.pay(100);
        debitCard.pay(5000.00, 100.00);
        System.out.println(debitCard.getAvailableCapital());

        CreditCard creditCard = new CreditCardCashback(5000.00, 7000.00);
        creditCard.pay(5000.00);
        creditCard.topUp(2000.00);
        creditCard.pay(5000.00);




        DebitCard debitCard2 = new DebitCardAccumulate(100.00);
        debitCard2.topUp(1000.00);
        System.out.println(debitCard2.getBalance());

    }
}