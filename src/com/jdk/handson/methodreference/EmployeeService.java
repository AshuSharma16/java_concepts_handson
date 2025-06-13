package com.jdk.handson.methodreference;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeService {

    public List<Employee> fetchEmpListFromDB() {

        List<Employee> empList = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Employee(i, "EmpName" + i, new Random().nextDouble())).collect(Collectors.toList());
        return empList;
    }

}