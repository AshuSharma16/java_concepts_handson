package com.jdk.handson.design.patterns.solidprinciple.dip.solution;

public class ShopingMall {
    CardService cardService;

    public ShopingMall(CardService cardService) {
        this.cardService = cardService;
    }

    public void doTransaction(long amt) {
        cardService.doShoping(amt);
    }

    public static void main(String[] args) {
        CardService cardService1 = new CreditCard();
        ShopingMall shopingMall = new ShopingMall(cardService1);
        shopingMall.doTransaction(5000);
    }
}
