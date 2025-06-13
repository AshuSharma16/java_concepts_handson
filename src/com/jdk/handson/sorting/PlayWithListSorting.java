package com.jdk.handson.sorting;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.dto.Employee;
import java.util.*;
import java.util.stream.Collectors;

public class PlayWithListSorting {
    public static void main (String[] args) {

        final List<Employee> employees = EmployeeDBUtils.getEmployees();
        Map<Integer, String> map = EmployeeDBUtils.getIntegerStringMap();

        //1. using Collctions class with list as param.
        Collections.sort(employees,Comparator.comparing(Employee::getSalary));
        System.out.println(employees);

        //2. sort a list of employee based on name using stream,
        final List<Employee> collect1 = employees.stream()
                .sorted(Comparator.comparing(Employee::getEmpName))
                .collect(Collectors.toList());
        System.out.println(collect1);

        //3. sort a list of employee based on name using stream and Lambda with Comparotor
        List<Employee> listOfDuplicateNameEmp = EmployeeDBUtils.getEmployees();
        Employee employee = listOfDuplicateNameEmp.stream()
                .sorted((a, b) -> a.getSalary().compareTo(b.getSalary()))
                .collect(Collectors.toList()).get(1);
        System.out.println(employee);


        //4. sort a list of employee based on name and in reversed order using stream
        final List<Employee> collect = employees.stream().
                sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        System.out.println(collect);

        //5.  sorting a list of emp using Comparator and Collections class
        Comparator<Employee> comp = Comparator.comparing(Employee::getSalary);
        Collections.sort(employees,comp);
        employees.forEach(System.out::println);

        //6.sorting a list of emp using Comparator and Collections class without case sensitive.......
        System.out.println("Employee object after sorting without case sensitive.......");
        Comparator<Employee> comparing = Comparator.comparing(Employee::getEmpName,String.CASE_INSENSITIVE_ORDER);
        Collections.sort(employees,comparing);
        employees.forEach(System.out::println);


    }
}
