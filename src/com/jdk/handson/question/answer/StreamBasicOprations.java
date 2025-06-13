package com.jdk.handson.question.answer;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.dto.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasicOprations {

    public static
    void main (String[] args) {

        List<Employee> listOfEmp = EmployeeDBUtils.getEmployees();
        // 1. Avearge salary
        double averageSal = listOfEmp.stream().filter(emp -> emp.getRatings().equalsIgnoreCase("X"))
                .map(Employee::getSalary)
                .mapToDouble(i -> i).average().getAsDouble();

        System.out.println(averageSal);

        //2. play with flatMap
        List<Integer> list1 = Stream.of(1,2,33,4,55,6).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(11, 2, 33, 4, 23, 43, 55, 6).collect(Collectors.toList());

        BiFunction<List<Integer>, List<Integer>, List<Integer>> b1  =  (list111,list222) -> {
            return Stream.of(list111, list222)
                    .flatMap(List::stream)
                    .distinct()
                    .collect(Collectors.toList());
        };

        Function<List<Integer>, List<Integer>> fun2 =  (integers) -> {
            return integers.stream().sorted().collect(Collectors.toList());
        };

        System.out.println(b1.andThen(integers -> integers.stream().sorted().collect(Collectors.toList()))
                                   .apply(list1,list2));


        List<String> stringList = Arrays.asList("HP","HCL","TechM","MS","HP");

        // sort string by accessing order
        System.out.println("sort string by accessing order");
        stringList.stream().sorted().forEach(System.out::println);

        // sort string by desecnding order
        System.out.println("sort string by desecnding order");
        stringList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // sort and remove duplicate string
        System.out.println("sort and remove duplicate string");
        stringList.stream().sorted().distinct().forEach(System.out::println);

        //sort string based on length
        System.out.println("sort string based on length");
        stringList.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

        // find the length of each string
        System.out.println("find the length of each string");
        stringList.stream().map(String::length).forEach(System.out::println);






    }
}
