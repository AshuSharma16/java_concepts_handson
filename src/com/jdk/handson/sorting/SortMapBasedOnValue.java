package com.jdk.handson.sorting;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.dto.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class SortMapBasedOnValue {
    public static void main (String[] args) {

        Map<Integer, String> map = EmployeeDBUtils.getIntegerStringMap();
        Map<Employee, String> empMap = EmployeeDBUtils.getEmployeeStringMap();
        Map<Integer, String> customMap = EmployeeDBUtils.getIntegerStringMap();
        Map<Integer, Employee> integerEmployeeMap = EmployeeDBUtils.getIntegerEmployeeMap();

        //1. Sorting map by value using java 8 Stream
        LinkedHashMap<Integer, String> sortedMapByValue = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue,newValue) -> oldValue,
                                          LinkedHashMap::new));
        System.out.println(sortedMapByValue);

        //2.  another way Sorting by value and print map by key using Java8 stream
        System.out.println("--------------");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);


        //3. Sort map based on value using java8 stream
        LinkedHashMap<Integer, Employee> sortedMap5 = integerEmployeeMap.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getSalary)))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldvalue,newValue) -> oldvalue ,LinkedHashMap::new));
        System.out.println(sortedMap5);

        //4. Sorting map by value using java5
        System.out.println("=======************=======");
        Set<Map.Entry<Integer, Employee>> entrySet3 = integerEmployeeMap.entrySet();
        List<Map.Entry<Integer, Employee>> list3 = new ArrayList(entrySet3);
        Collections.sort(list3, (o1, o2) -> o1.getValue().getEmpName().compareTo(o2.getValue().getEmpName()));
        list3.forEach(a -> System.out.println("key :" + a.getKey() + "  value :" + a.getValue()));


    }
}
