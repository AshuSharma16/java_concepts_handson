package com.jdk.handson.design.patterns.solidprinciple.dip.problem;

public class ShopingMall {

    /*
    so here if you wants to do payment using debit card . have to create debit card object . if you wants to do payment by
    credit card then creditCard class object needs to create . so its tightly coupled. As per Dependency Inversion principle , it should not.
    please refer org.solid.principle.dip.solution package for solution.
     */
    DebitCard debitCard;

    public ShopingMall(DebitCard debitCard) {
        this.debitCard = debitCard;
    }

    public void doTransaction(long amt) {
        debitCard.doShoping(amt);
    }
    public static void main(String[] args) {
        DebitCard debitCard1 = new DebitCard();
        ShopingMall shopingMall  = new ShopingMall(debitCard1);
        shopingMall.doTransaction(5000);
    }
}
