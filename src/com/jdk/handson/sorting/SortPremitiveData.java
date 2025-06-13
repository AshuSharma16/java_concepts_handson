package com.jdk.handson.sorting;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.db.util.EmployeeListUtils;
import com.jdk.handson.dto.Employee;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class SortPremitiveData {
    public static void main(String[] args) {
        final List<String> list = Arrays.asList("Ashu", "Shyam", "Ram", "Masum");

            // sort based on Collections class
            Collections.sort(list);
            System.out.println("Collections.sort : " + list);
            Collections.reverse(list);
            System.out.println("Collections.reverse : " + list);
            Collections.reverseOrder();
            System.out.println(" Collections.reverseOrder:" + list);

            //sort using streams
            final List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
            System.out.println(sortedList);

            // sort using stream with Comparator
            final List<String> sortedList2 = list.stream()
                    .sorted((ob, ob2) -> ob.compareTo(ob2))
                    .collect(Collectors.toList());
            System.out.println(sortedList2);

        final List<Integer> intList = Arrays.asList(1, 3, 2, 4, 3, 1, 2);
        // 1. removed duplicate element from a list  - 1st approach
        System.out.println("------------1st approach-------------");
        intList.stream().distinct().sorted(Collections.reverseOrder()).collect(Collectors.toList()).forEach(System.out::print);

        // 2. removed duplicate element from a list  - 2nd approach
        System.out.println(" \n ------------2nrd approach------------");
        intList.stream().sorted(Collections.reverseOrder()).distinct().collect(Collectors.toList()).forEach(System.out::print);

        //3.removed duplicate element from a list  - 3rd approach
        System.out.println("\n ------------3rd approach-----------");
        intList.stream()
                .collect(Collectors.toSet())
                .forEach(System.out::print);

        // find second-lowest element
        int elementArr[] = {11,222,32,23,54,44};
        List<Integer> sortedListInDecendingOrder = Arrays.stream(elementArr).boxed().sorted().collect(Collectors.toList());
        System.out.println(sortedListInDecendingOrder);
        Integer secondLowestElement = sortedListInDecendingOrder.stream().skip(1).findFirst().get();
        System.out.println(secondLowestElement);

        // find second-highest element
        int elementArr2[] = {11,222,32,23,54,44};
        List<Integer> sortedList22 = Arrays.stream(elementArr2).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedList22);
        Integer secondHighestElement = sortedList22.stream().skip(1).findFirst().get();
        System.out.println(secondHighestElement);

        //sort a list and convert each element into upper case
        List<String> asList = Arrays.asList("ram","Shyam","Kames","Logesh","Bittoo");
        asList.stream().sorted().forEach(System.out::println);
        asList.stream().map(i -> i.toUpperCase()).sorted().forEach(System.out::println);

        Map<String, Integer> customKeyMap = EmployeeDBUtils.getStringIntegerMap();
        // approach -1  sortMap based on predefined data type like string as key
        LinkedHashMap<String, Integer> sortMapBasedonKey = customKeyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue,newValue) -> oldValue,LinkedHashMap::new));

        System.out.println("sort Map Basedon pre-defined Key>>>>" + sortMapBasedonKey);
        // approach -2 : sortMap based on predefined data type like string as key- TreeMap
        Map<String, Integer> treeMapObj = new TreeMap<>();
        treeMapObj.putAll(customKeyMap);
        System.out.println("Sort Map Based on Tree Map ----> " + treeMapObj);

        List<Integer> numericList = Arrays.asList(12,34,22,54,67,43,34,54);

        // sort integer list in ascending order
        System.out.println("sort integer list in ascending order :::>>>");
        numericList.stream().sorted().forEach(System.out::println);

        // sort integer list in descending order
        System.out.println("sort integer list in descending order :::>>>");
        numericList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // sort integer list in descending order and remove duplicate element
        System.out.println("sort integer list in descending order and remove duplicate element :::>>>");
        numericList.stream().sorted(Comparator.reverseOrder()).distinct().forEach(System.out::println);

        List<Employee> listOfDuplicateNameEmp = EmployeeListUtils.getListOfDuplicateNameEmp();
        Employee employee = listOfDuplicateNameEmp.stream()
                .sorted((a, b) -> a.getSalary().compareTo(b.getSalary()))
                .collect(Collectors.toList()).get(1);
        System.out.println(employee);


        Comparator<Employee> EmpSal = Comparator.comparing(Employee::getSalary);

        Map<String, Optional<Employee>> EmpMap = EmployeeDBUtils.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.reducing(BinaryOperator.maxBy(EmpSal))));
        System.out.println(EmpMap);


    }
}
