package com.jdk.handson.question.answer;

public class ThrowsErrorExample {

    public static void main(String[] args) {

        try{
            System.out.println("A");
            badMethod();
            System.out.println("B");
        }catch (Exception e) {
            System.out.println("C");
        } finally {
            System.out.println("D");
        }
    }

    private static void badMethod()  {
        throw new Error();
    }
}
