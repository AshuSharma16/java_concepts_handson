package com.jdk.handson.sorting;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.dto.Employee;

import java.util.Collections;
import java.util.List;

public
class SortObjectUsingTraditionalApproach {

    public static void main(String[] args) {
        List<Employee> listOfEmp = EmployeeDBUtils.getEmployees();
        System.out.println("Employee object before sorting .......");
        listOfEmp.forEach(System.out::println);
        System.out.println("Employee object after sorting .......");
        Collections.sort(listOfEmp,new EmpNameComparator());
        listOfEmp.forEach(System.out::println);

    }
}
