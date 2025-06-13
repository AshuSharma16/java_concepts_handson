package com.jdk.handson.Optional;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.dto.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public
class PayWithOptional {

    public static void main (String[] args) {
        final List<Employee> employees = EmployeeDBUtils.getEmployees();
        final Map<Employee, String> employeeMap = EmployeeDBUtils.getEmployeeStringMap();

        // isPresent & get
        final Optional<String> email = Optional.of(employees.get(0).getEmail());
        if(email.isPresent()) {
            final String s = email.get();
            System.out.println(s);
        }


        employees.stream().filter(employee ->  employee.getEmpId().equals(111))
                .forEach(emp -> emp.setEmail(null));

        final Optional<String> emailNull = Optional.ofNullable(employees.get(0).getEmail());
        final String orElseGet = emailNull.orElseGet(() -> "No Email present for that employee");
        System.out.println(orElseGet);
        final String orElseThrow = emailNull.orElseThrow(() -> new RuntimeException("No email Present for thsi Employee"));
        System.out.println(orElseThrow);



    }
}
