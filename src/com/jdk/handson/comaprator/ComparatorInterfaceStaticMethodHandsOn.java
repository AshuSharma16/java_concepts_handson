package com.jdk.handson.comaprator;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.db.util.EmployeeListUtils;
import com.jdk.handson.dto.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class ComparatorInterfaceStaticMethodHandsOn {

    public static void main(String[] args) {

        // 1. comparing & sort list of emp with there names
        List<Employee> listOfEmp = EmployeeDBUtils.getEmployees();
        Comparator<Employee> byName = Comparator.comparing(Employee::getEmpName);
        Collections.sort(listOfEmp, byName);
        listOfEmp.forEach(System.out::println);


        // 2. comparing and thenComparing & sort list of emp with there names and salary
        System.out.println("===========================");
        List<Employee> listOfEmp1 = EmployeeListUtils.getListOfDuplicateNameEmp();
        Comparator<Employee> byNameAndSal = Comparator.comparing(Employee::getEmpName)
                .thenComparing(Employee::getSalary);
        Collections.sort(listOfEmp1, byNameAndSal);
        listOfEmp1.forEach(System.out::println);


        // 3. nullFirst and nullFirst & sort list of emp with nullFirst
        System.out.println("===========================");
        List<Employee> listOfEmp2 = EmployeeListUtils.getListOfNullNameEmp();
        Comparator<Employee> nullsFirst = Comparator.comparing(Employee::getEmpName,Comparator.nullsFirst(String::compareTo));
        Collections.sort(listOfEmp2, nullsFirst);
        listOfEmp2.forEach(System.out::println);


        // 4. nullFirst and nullLast & sort list of emp with nullLast
        System.out.println("===========================");
        List<Employee> listOfEmp3 = EmployeeListUtils.getListOfNullNameEmp();
        Comparator<Employee> nullLast = Comparator.comparing(Employee::getEmpName,
                                                             Comparator.nullsLast(String::compareTo));
        Collections.sort(listOfEmp3, nullLast);
        listOfEmp3.forEach(System.out::println);

        // 5. natural and reversed oreder.
        System.out.println("===========================");
        List<Employee> listOfNullNameEmp = EmployeeListUtils.getListOfNullNameEmp();
        List<String> collect = listOfNullNameEmp.stream().filter(ob -> ob.getEmpName() != null)
                .map(Employee::getEmpName).collect(Collectors.toList());
        collect.sort(Comparator.reverseOrder());
        collect.forEach(System.out::println);


        // 6. natural and natual oreder.
        System.out.println("===========================");
        List<String> collect2 = listOfNullNameEmp.stream().filter(ob -> ob.getEmpName() != null)
                .map(Employee::getEmpName).collect(Collectors.toList());
        collect2.sort(Comparator.naturalOrder());
        collect2.forEach(System.out::println);
    }

}