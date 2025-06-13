package com.jdk.handson.sorting;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.dto.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class SortMapBasedOnKey {
    public static void main (String[] args) {
        Map<Integer, String> map = EmployeeDBUtils.getIntegerStringMap();
        Map<Employee, String> empMap = EmployeeDBUtils.getEmployeeStringMap();
        Map<Integer, String> customMap = EmployeeDBUtils.getIntegerStringMap();
        Map<Integer, Employee> integerEmployeeMap = EmployeeDBUtils.getIntegerEmployeeMap();

        //1. Sorting map by key using java 8 stream
        LinkedHashMap<Employee, String> sortedMapByKey = empMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getEmpName))).collect(Collectors.toMap(
                        Map.Entry::getKey,Map.Entry::getValue,(oldValue,newValue) -> oldValue,LinkedHashMap::new));
        System.out.println(sortedMapByKey);

        //2. another way Sorting and print map by key but did not store data back into map
        System.out.println("--------------");
        empMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getEmpName)))
                .forEach(System.out::print);

        //3. Sorting map by key using java5
        System.out.println("=======************=======");
        Set<Map.Entry<Employee, String>> entrySet = empMap.entrySet();
        List<Map.Entry<Employee, Integer>> list1 = new ArrayList(entrySet);
        Collections.sort(list1, (ob1, ob2) -> ob1.getKey().getEmpName().compareTo(ob2.getKey().getEmpName()));
        list1.forEach(a -> System.out.println("key :" + a.getKey() + "  value :" + a.getValue()));

        // 4. Sorting map by key by java 5
        System.out.println("======************=========");
        Set<Map.Entry<Integer, String>> entrySet1 = customMap.entrySet();
        List<Map.Entry<Integer, String>> list = new ArrayList(entrySet1);
        Collections.sort(list, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        list.forEach(a -> System.out.println("key :" + a.getKey() + "  value :" + a.getValue()));

        //5.  another way Sorting and print map by value but did not store data back into map
        System.out.println("-----*********---------");
        integerEmployeeMap.entrySet().stream().sorted(
                Map.Entry.comparingByValue(Comparator.comparing(Employee::getSalary))).forEach(System.out::print);

    }
}
