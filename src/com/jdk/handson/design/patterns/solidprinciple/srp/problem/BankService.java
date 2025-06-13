package com.jdk.handson.design.patterns.solidprinciple.srp.problem;

public class BankService {

    /*
     if you see here we have defined all feature in one class . which is not a right way to design the
     software as per SOLID.As per SOLID principle , one class should have only one responsibility.
     So to overcome , we have to define separate class for each functionality.
     for more , refer "org.solid.principle.srp.solution" package
     */
    public void widthdrawAmount(long amount, String acctNum) {

    }

    public void depositAmount(long amount , String acctNum) {

    }

    public void printPassBook() {

    }

    public void sendOTP(String medium) {
        if (medium.equalsIgnoreCase("mobile")) {

        }

        if (medium.equalsIgnoreCase("email")) {

        }

    }

    public void getLoanInterestRateInfo(String loanType) {
        if (loanType.equalsIgnoreCase("Home Loan")) {

        }
        if (loanType.equalsIgnoreCase("Personal Loan")) {

        }
        if (loanType.equalsIgnoreCase("Car Loan")) {

        }
    }
}
