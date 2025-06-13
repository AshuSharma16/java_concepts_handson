package com.jdk.handson.design.patterns.solidprinciple.ocp.problem;

public class NotoficationService {
/*
Here today let suppose Bank is supported to send OTP on email and mobile as text . But in future
lets bank started send otp on whatsApp , then in this case , as per Open close principle , we should not modify
 this existing class. To overcome , we have defined interface model and provide implementation class for each medium.
 please refer "org.solid.principle.ocp.solution" package.

 */
    public void sendOTP(String medium) {
        if (medium.equalsIgnoreCase("mobile")) {

        }

        if (medium.equalsIgnoreCase("email")) {

        }

    }
}
