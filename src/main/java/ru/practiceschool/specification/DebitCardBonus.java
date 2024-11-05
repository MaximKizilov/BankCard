package ru.practiceschool.specification;

import ru.practiceschool.model.DebitCard;

import java.text.NumberFormat;
import java.util.Locale;

public class DebitCardBonus extends DebitCard {
    public DebitCardBonus(double balance, double bonusPoints) {
        super(balance, bonusPoints);
    }

    @Override
    public boolean pay(double amount) {
        if (amount > balance || amount <= 0) {
            return false;
        } else balance -= amount;
        bonusPoints += amount*BONUSRATE;
        return true;
    }


    @Override
    public String getAvailableCapital() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
        return "Собственные средства: " + nf.format(balance)  + "\n" +
                "Бонусы на здоровье: " + nf.format(bonusPoints);
    }
}
