package ru.practiceschool.specification;

import ru.practiceschool.model.DebitCard;

import java.text.NumberFormat;
import java.util.Locale;

public class DebitCardBonus extends DebitCard {
    private static final double BONUSRATE = 0.01;
    private double bonusPoints;

    public DebitCardBonus(double balance) {
        super(balance);
    }

    public DebitCardBonus(double balance, double bonusPoints) {
        super(balance);
        this.bonusPoints = bonusPoints;
    }

    @Override
    public boolean pay(double amount) {
        if (amount > balance || amount <= 0) {
            return false;
        } else balance -= amount;
        bonusPoints += amount*BONUSRATE;
        return true;
    }
    // перегрузка для бонусной карты
    public boolean pay(double amount, double bonusAmount) {
        if (amount > balance || amount <= 0) {
            return false;
        } else if (bonusAmount > bonusPoints) {
            return false;
        } else {
            if (bonusAmount <= amount * 0.3) { // Допустим по правилам банка бонусами можно оплачивать до 30% от стоимости включительно
                bonusPoints -= bonusAmount;
                double amountMinusBonus = amount - bonusAmount;
                balance -= amountMinusBonus;
                bonusPoints += amountMinusBonus * BONUSRATE;
                return true;
            } else
                return false;
        }
    }

    @Override
    public String getAvailableCapital() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
        return "Собственные средства: " + nf.format(balance)  + "\n" +
                "Бонусы на здоровье: " + nf.format(bonusPoints);
    }
}
