package com.jdk.handson.comaprator;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.dto.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public
class PayWithComparator {
    public static void main (String[] args) {

        final List<Employee> employees = EmployeeDBUtils.getEmployees();

        // 1. find the lognest string from a given input - input can be a string or list
        String input = "ram raja restapi dockerservice  kafkaservice microservice azur";

        final List<String> sortedList = Arrays.stream(input.split(" "))
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(1)
                .collect(Collectors.toList());
                System.out.println(sortedList);
        //2. sort an emp having highest salary
        final List<Employee> employeeWithHighSal =
                employees.stream()
                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                        .collect(Collectors.toList());
        System.out.println("Employee in sorted order based on salary : -" + employeeWithHighSal);
        System.out.println("Employee with highest salary : -"+ employeeWithHighSal.stream().findFirst().get());

        //3 . get highest sal for an organization
        final double asDouble = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .mapToDouble(ob -> ob.getSalary()).findFirst().getAsDouble();
        System.out.println(asDouble);

        final Double v = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .map(ob -> ob.getSalary()).findFirst().get();
        System.out.println(v);

        //4. find the phone for all employyee
        final List<String> phones = employees.stream().flatMap(employee -> employee.getPhones().stream()).collect(Collectors.toList());
        System.out.println(phones);

        //5.
        String strArr[]= {"java8", "Kafka", "Docker", "K8", "Azur with Mocroservice"};
        	String lonestString = Arrays.stream(strArr).reduce((a, b) -> a.length() > b.length() ? a : b).get();
        System.out.println(lonestString);

    }
}
