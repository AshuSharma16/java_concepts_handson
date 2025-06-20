package com.jdk.handson.question.answer;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.dto.Employee;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class FindDepartmnetWiseMaxSalary{
    public static void main(String[] args){
        final List<Employee> employees = EmployeeDBUtils.getEmployees();
        final Map<String, DoubleSummaryStatistics> collect = employees.stream().
                collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summarizingDouble(Employee::getSalary)));
        System.out.println(collect);

        
    }
}
