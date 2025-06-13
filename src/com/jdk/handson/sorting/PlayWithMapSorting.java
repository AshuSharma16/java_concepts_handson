package com.jdk.handson.sorting;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.dto.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class PlayWithMapSorting {
    public static void main (String[] args) {

        Map<Integer, String> map = EmployeeDBUtils.getIntegerStringMap();

        // approach -  sortMap based on custom data type like user/Employee as key
        System.out.println("sortMap based on custom data type like user/Employee as key ----->");
        Map<Employee, Integer> employeeasKeyMap = EmployeeDBUtils.getEmployeeIntegerMap();
        employeeasKeyMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparingLong(Employee::getEmpId))).forEach(System.out::println);
        System.out.println("sort Map Basedon EmployeeName----->");
        employeeasKeyMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getEmpName))).forEach(System.out::println);

        System.out.println("sort Map Basedon EmployeeName----->");
        LinkedHashMap<Employee, Integer> employeeNameMap = employeeasKeyMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getEmpName))).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldvalue,newValue) -> oldvalue,LinkedHashMap::new));
        System.out.println("<<<<<<<< sort Map Basedon employeeName as Key >>>>" + employeeNameMap);

        // sortMap based on predefined data type like string as value
        final LinkedHashMap<Employee, Integer> sortMapBasedonValue = employeeasKeyMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue,newValue) -> oldValue,LinkedHashMap::new));

        System.out.println("sort Map Based-on pre-defined as Value>>>>" + sortMapBasedonValue);

        // find the average salary of employee
        double asDouble = employeeasKeyMap.keySet().stream().map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();
        System.out.println("Average Salary of Employee : " + asDouble);
        //flatMap
        List<String> phones = employeeasKeyMap.keySet().stream().flatMap(e1 -> e1.getPhones().stream()).collect(Collectors.toList());
        System.out.println("List of phones ::::" + phones);

        // another way Sorting and print map by key using Java8 stream
        System.out.println("--------------");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);


    }
}
