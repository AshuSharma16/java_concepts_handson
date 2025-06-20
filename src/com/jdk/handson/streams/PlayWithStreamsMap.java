package com.jdk.handson.streams;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.dto.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public class PlayWithStreamsMap{

    public static void main(String[] args){
        final List<Employee> employees =EmployeeDBUtils.getEmployees();

        // find total salary of employees
        final Double salary = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(salary);

        // find Employee with max salary
        final Optional<Employee> max = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(max.get());

    }
}
