package com.jdk.handson.design.patterns.solidprinciple.isp.solution;

public class GooglePayService implements UPIPaymentService, CashBackManager {
    @Override
    public void doPayment(long amount) {

    }

    @Override
    public void getScratchCard() {

    }

    @Override
    public void getCashBackAsCredit() {

    }
}
