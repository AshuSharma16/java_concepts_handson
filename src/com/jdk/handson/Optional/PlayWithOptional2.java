package com.jdk.handson.Optional;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.dto.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlayWithOptional2{
    public static void main(String[] args){
        final List<Employee> employees = EmployeeDBUtils.getEmployees();

        //find find emails of employe having salary graeter than 50K

        final Optional<List<String>> listofEmail = Optional.ofNullable(employees.stream()
                                                                           .filter(employee -> employee.getSalary() > 50000)
                                                                           .map(Employee::getEmail).collect(Collectors.toList()));
        System.out.println(listofEmail.get());


        final Optional<Employee> employee = Optional.ofNullable(employees.stream().
                                                                        collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get());
        System.out.println(employee.get());

        final Double v = employees.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)))
                .map(Employee::getSalary).get();
        System.out.println(v);


    }
}
