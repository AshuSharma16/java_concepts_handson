package com.jdk.handson.design.patterns.solidprinciple.isp.problem;

public interface UPIPaymentService {
/*
  As per Interface Segregation Principle , We should not force client to override and implement the service which is not in its scope.
  for example : PayTM and Phone pay is having service like doPayment and getScratchCard but not having a service like
    getCashBackAsCredit. In same way Googlepay is provided  all three service  doPayment and getCashBackAsCredit and getScratchCard.
    So basically here we should not force Paytm and Phone pay to override and implement getCashBackAsCredit functionality .
    To overcome or to provide solution , Interface Segregation Principle says , keep your interface smaller.
    so more details please check org.solid.principle.isp.solution package.
 */
    public void doPayment(long amount);

    public void getScratchCard();

    public void getCashBackAsCredit();

}
