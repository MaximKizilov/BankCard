package ru.practiceschool.model;


public class DebitCard extends BankCard {
    protected static final double BONUSRATE = 0.01;
    protected double bonusPoints;

    public DebitCard(double balance) {
        super(balance);
    }
//конструктор для бонусной карты
    public DebitCard(double balance, double bonusPoints) {
        super(balance);
        this.bonusPoints = bonusPoints;
    }
// дефолтный метод
    @Override
    public boolean pay(double amount) {
        if (amount > balance || amount <= 0) {
            return false;
        } else balance -= amount;
        return true;
    }
// перегрузка для бонусной карты
    public boolean pay(double amount, double bonusAmount) {
        if (amount > balance || amount <= 0) {
            return false;
        }else if(bonusAmount > bonusPoints){
            return false;
        } else {
            if (bonusAmount <= amount*0.3) { // Допустим по правилам банка бонусами можно оплачивать до 30% от стоимости включительно
                bonusPoints -= bonusAmount;
                double amountMinusBonus = amount-bonusAmount;
                balance -= amountMinusBonus;
                bonusPoints += amountMinusBonus * BONUSRATE;
                return true;
            }else
                return false;
        }
    }

    public boolean topUp(double amount) {
        if (amount <= 0) {
            return false;
        } else balance += amount;
        return true;
    }

}
