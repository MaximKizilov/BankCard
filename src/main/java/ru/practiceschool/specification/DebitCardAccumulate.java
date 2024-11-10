package ru.practiceschool.specification;

import ru.practiceschool.model.DebitCard;

public class DebitCardAccumulate extends DebitCard {
    private static final double ACCUMFACTOR = 0.00005;
    public DebitCardAccumulate(double balance) {
        super(balance);
    }

    @Override
    public boolean topUp(double amount) {
        return super.topUp(amount + Math.round(amount*ACCUMFACTOR));
    }
}
