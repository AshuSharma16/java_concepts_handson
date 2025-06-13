package com.jdk.handson.db.util;

import com.jdk.handson.dto.Employee;

import java.util.*;

public class EmployeeDBUtils {
    public static List<Employee> getEmployees() {
     return Utils.createEmployeeList();
    }

    public static Map<Employee, String> getEmployeeStringMap() {
        Map<Employee, String> employeeMap = new HashMap<>();
        final List<Employee> employees = EmployeeDBUtils.getEmployees();
        employees.forEach(employee -> employeeMap.put(employee ,employee.getEmpName()));
        return employeeMap;
    }

    public static Map<Integer, Employee> getIntegerEmployeeMap() {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        final List<Employee> employees = EmployeeDBUtils.getEmployees();
        employees.forEach(employee -> employeeMap.put(employee.getEmpId() ,employee));
        return employeeMap;
    }

    public static Map<Employee, Integer> getEmployeeIntegerMap() {
        Map<Employee, Integer> empMap = new HashMap<>();
        List<Employee> empList = getEmployees();
        empMap.put(empList.get(0), 111);
        empMap.put(empList.get(1), 222);
        empMap.put(empList.get(2), 333);
        empMap.put(empList.get(3), 444);
        empMap.put(empList.get(4), 555);
        return empMap;
    }

    public static Map<String, Integer> getStringIntegerMap() {
        Map<String, Integer> empMap = new WeakHashMap<>();
        empMap.put("Rajesh", 1001);
        empMap.put("Kamal", 1002);
        empMap.put("Suraj", 1004);
        empMap.put("Anjana", 1003);
        empMap.put("Charu", 1005);
        return empMap;

    }

    public static Map<Integer, String> getIntegerStringMap() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(111,"Rajat");
        map.put(101,"Karan");
        map.put(222,"pawan");
        map.put(444,"Sumer");
        map.put(333,"Sandhya");
        return  map;
    }
    public static List<Employee> createEmployeeInbulk() {
        List<Employee> employeObj = new ArrayList<>();
        for (int i = 0; 1 < 1000; i++) {
            employeObj.add(new Employee(Integer.valueOf(i),"Employee" + i,Double.valueOf(new Random(100 * 100).nextInt())));
        }
    }
}
