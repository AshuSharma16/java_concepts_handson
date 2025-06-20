package com.jdk.handson.question.answer;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.dto.Employee;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindDepartmnetWiseTotalSalary{
    public static void main(String[] args){
        final List<Employee> employees = EmployeeDBUtils.getEmployees();

               Map<String, DoubleSummaryStatistics> summarizingDouble = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment,
                                 Collectors.summarizingDouble(Employee::getSalary)));
        System.out.println(summarizingDouble);

        final Map<String, Double> summingDouble = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                                               Collectors.summingDouble(Employee::getSalary)));
        System.out.println(summingDouble);

        final Optional<Map<String, Double>> reducing = Optional.ofNullable(employees.stream()
                                                                                  .collect(Collectors.groupingBy(Employee::getDepartment,
                                                                                                                 Collectors.reducing(0.0,Employee::getSalary,Double::sum))));
        System.out.println(reducing.get());

    }
}
