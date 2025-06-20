package com.jdk.handson.question.answer;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.dto.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDepartmnetWiseEmployeeNames{
    public static void main(String[] args){
        final List<Employee> employees = EmployeeDBUtils.getEmployees();
        final Map<String, List<String>> mappings = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,Collectors.mapping(
                                Employee::getEmpName,Collectors.toList())));
        System.out.println(mappings);
    }
}
