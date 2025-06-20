package com.jdk.handson.question.answer;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.dto.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.maxBy;

public class FindMaxSalaryFromEachDepartment{
    public static void main(String[] args){
        final List<Employee> employees = EmployeeDBUtils.getEmployees();

        // approach -1
        final Map<String, Optional<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.reducing(BinaryOperator.maxBy(
                        Comparator.comparingDouble(Employee::getSalary)))));
        System.out.println(collect);

        // approach -2

        final Map<String, Employee> collect1 = employees
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        collectingAndThen(maxBy(Comparator.comparingDouble(Employee::getSalary)),Optional::get)
                ));

        System.out.println(collect1);

    }
}
