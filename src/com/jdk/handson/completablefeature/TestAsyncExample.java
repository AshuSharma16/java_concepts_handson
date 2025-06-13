package com.jdk.handson.completablefeature;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TestAsyncExample {
    public static void main(String[] args) {

        CompletableFuture completableFuture = new CompletableFuture();
        completableFuture.thenRunAsync(() -> {
            List<Employee> employee = EmployeeService.getEmployee();
            System.out.println("Total Employee : "+ employee.size());
        });

        System.out.println("Done!!!");



    }
}
