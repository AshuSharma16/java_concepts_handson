package com.jdk.handson.db.util;

import com.jdk.handson.dto.Employee;

import java.util.List;

public class EmployeeListUtils {

    public static List<Employee> getListOfDuplicateNameEmp() {
         List<Employee> employeeList = Utils.createEmployeeList();
         employeeList.get(1).setEmpName("Karan");
         employeeList.get(3).setEmpName("Karan");
        return  employeeList;
    }

    public static List<Employee> getListOfNullNameEmp() {
        List<Employee> employeeList = Utils.createEmployeeList();
        employeeList.get(1).setEmpName(null);
        employeeList.get(4).setEmpName(null);
        return  employeeList;
    }


}
