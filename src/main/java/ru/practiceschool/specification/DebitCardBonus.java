package ru.practiceschool.specification;

import ru.practiceschool.model.DebitCard;


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
        if (amount > getBalance() || amount <= 0) {
            return false;
        } else setBalance(getBalance() - amount);
        bonusPoints += amount * BONUSRATE;
        return true;
    }

    @Override
    public boolean pay(double amount, double bonusAmount) {
        if (amount > getBalance() || amount <= 0) {
            return false;
        } else if (bonusAmount > bonusPoints) {
            return false;
        } else {
            if (bonusAmount <= amount * 0.3) { // Допустим по правилам банка бонусами можно оплачивать до 30% от стоимости включительно
                bonusPoints -= bonusAmount;
                double amountMinusBonus = amount - bonusAmount;
                setBalance(getBalance() - amountMinusBonus);
                bonusPoints += amountMinusBonus * BONUSRATE;
                return true;
            } else
                return false;
        }
    }

    @Override
    public String getAvailableCapital() {
        return super.getAvailableCapital() + "\n"
                + "Бонусы на здоровье: " + nf.format(bonusPoints);
    }
}
