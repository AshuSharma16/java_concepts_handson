package com.jdk.handson.collectors;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.db.util.PersonDBUtils;
import com.jdk.handson.dto.Employee;
import com.jdk.handson.dto.Person;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlayWithCollectors {
    public static void main (String[] args) {

        final List<Person> personList = PersonDBUtils.getPersonList();

        // groupingBy comes with three overloaded method
        System.out.println("---------------Grouping by function or Single params-------------");
        //1.  groping based on one parameter
        Map<String, List<Person>> groupingByPname = personList.stream()
                .collect(Collectors.groupingBy(person -> person.getpCourse()));
        groupingByPname.forEach((k , v) -> System.out.println( "Key : "+ k + "  " + "Value : "+ v));

        //2. groping based on multiple parameters
        System.out.println("---------------Grouping by function and collectors or Two params-------------");
        Map<String, Map<String, List<Person>>> groupingByResult = personList.stream()
                .collect(Collectors.groupingBy(person -> person.getpCourse() ,
                                               Collectors.groupingBy(person -> person.getpGender())));
        groupingByResult.forEach((k , v) -> System.out.println( "Key : "+ k + "  " + "Value : "+ v));

        //3. Grouping by function and collectors with set or Two params
        System.out.println("---------------Grouping by function and collectors with set  or Two params -------------");
        Map<String, Set<Person>> groupingByFunctionAndCollectors = personList.stream()
                .collect(Collectors.groupingBy(person -> person.getpCourse() , Collectors.toSet()));

        groupingByFunctionAndCollectors.forEach((k , v) -> System.out.println( "Key : "+ k + "  " + "Value : "+ v));

  //4. Grouping by function and collectors with List or Two para
        System.out.println("---------------Grouping by function and collectors with set  or Two params -------------");
        Map<String, List<String>> groupingByFunctionAndCollectors1 = personList.stream()
                .collect(Collectors.groupingBy(person -> person.getpCourse()
                        ,Collectors.mapping(Person::getpName, Collectors.toList()) ));

        groupingByFunctionAndCollectors1.forEach((k , v) -> System.out.println( "Key : "+ k + "  " + "Value : "+ v));

        String str = "ilovejavatechie";

        String[] strArray = str.split("");
        System.out.println(Arrays.toString(strArray)); // print array with actual data instead of hashcode

        /*
         * Map<String, List<String>> grpByElement =
         * Arrays.stream(strArray).collect(Collectors.groupingBy(s ->s));
         *
         * System.out.println(grpByElement);
         */

        Map<String, Long> map = Arrays.stream(strArray).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        //map.forEach((k, v ) -> System.out.println("key : "+ k + "  and Values : "+ v));

        System.out.println(map);


        List<Employee> empList = EmployeeDBUtils.getEmployees();

        Comparator<Employee> EmpSal = Comparator.comparing(Employee::getSalary);

        Map<String, Optional<Employee>> EmpMap = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.reducing(BinaryOperator.maxBy(EmpSal))));

        System.out.println(EmpMap);

        List<Employee> listOfDuplicateNameEmp = EmployeeDBUtils.getEmployees();
        Map<String, List<Employee>> grpbyGrade = listOfDuplicateNameEmp.stream()
                .collect(Collectors.groupingBy(Employee::getRatings));
        grpbyGrade.forEach((k, v) -> System.out.println("key : " + k + "and value is :" + v));



        // find the name of employee from each department
        final Map<String, List<String>> collect = EmployeeDBUtils.getEmployees()
                                    .stream()
                                    .collect(
                                            Collectors.groupingBy(
                                                    Employee::getDepartment,Collectors.mapping(
                                                            Employee::getEmpName,Collectors.toList())));
        System.out.println("collect all employee from each deparment : -" +collect);

    }
}
