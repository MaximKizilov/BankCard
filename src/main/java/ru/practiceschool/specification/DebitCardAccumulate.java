package ru.practiceschool.specification;

import ru.practiceschool.model.CreditCard;
import ru.practiceschool.model.DebitCard;

public class DebitCardAccumulate extends DebitCard {
    public DebitCardAccumulate(double balance) {
        super(balance);
    }

    @Override
    public boolean topUp(double amount) {
        return super.topUp(amount + amount*0.00005);
    }
}
