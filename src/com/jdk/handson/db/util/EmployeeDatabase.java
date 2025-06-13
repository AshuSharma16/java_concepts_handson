package com.jdk.handson.db.util;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdk.handson.completablefeature.Employee;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabase {

    public static List<Employee> getEmployeeFromDB() {
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employees = new ArrayList<>();
        try {
            employees = mapper.readValue(new File("employees.json"), new TypeReference<List<Employee>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
}
