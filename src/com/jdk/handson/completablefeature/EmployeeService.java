package com.jdk.handson.completablefeature;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public static List<Employee> getEmployee() {

        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employees = new ArrayList<>();
        try {
            employees = mapper.readValue(new File("employees.json"), new TypeReference<List<Employee>>() {
            });
            System.out.println("Total Employee : "+ employees.size());
            System.out.println("Thread name : "+ Thread.currentThread().getName());

        } catch (IOException e) {
            System.out.println("exception occur while parshing json file : "+ e);
        }

        return employees;
    }
}
