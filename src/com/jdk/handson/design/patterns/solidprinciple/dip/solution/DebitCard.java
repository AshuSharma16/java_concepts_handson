package com.jdk.handson.design.patterns.solidprinciple.dip.solution;


public class DebitCard implements CardService {
    public void doShoping(long amt){
        System.out.println("making payment using debit card");
    }
}
