package ru.practiceschool;

import com.sun.net.httpserver.HttpServer;
import ru.practiceschool.model.CreditCard;

public class Main {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard(1000, 5000);
        creditCard.topUp(200);
        creditCard.pay(6500);
        creditCard.topUp(400);
        System.out.println(creditCard.getBalance());
    }
}