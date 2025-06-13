package com.jdk.handson.completablefeature;

import com.jdk.handson.db.util.EmployeeDatabase;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SupplyAsyncService {

    public CompletableFuture<List<Employee>> fetchEmployees() {

        CompletableFuture<List<Employee>> listCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread : " + Thread.currentThread().getName());
            return EmployeeDatabase.getEmployeeFromDB();
        });
        return listCompletableFuture;

    }

    public CompletableFuture<List<Employee>> fetchEmployeesUsingCustomThreadPool() {

        Executor  executor= Executors.newFixedThreadPool(10);
        CompletableFuture<List<Employee>> listCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread : " + Thread.currentThread().getName());
            return EmployeeDatabase.getEmployeeFromDB();
        }, executor);
        return listCompletableFuture;

    }
}
