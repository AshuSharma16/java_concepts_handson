package com.jdk.handson.db.util;


import com.jdk.handson.dto.Employee;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class Utils {

    public static List<Employee> createEmployeeList() {
        Employee e1 = Employee.builder()
                .empId(111)
                .empName("Karan")
                .ratings("X")
                .department("DEV")
                .city("Bangalore")
                .email("karamn@gmail.com").phones(asList("987456123", "789321456"))
                .salary(Double.valueOf(76767))
                .build();

        Employee e2 = Employee.builder()
                .empId(222)
                .empName("Suman")
                .email("Suman@gmail.com")
                .department("QA")
                .ratings("X")
                .city("Bangalore")
                .phones(asList("987489123", "789671456"))
                .salary(Double.valueOf(96767))
                .build();

        Employee e3 = Employee.builder()
                .empId(333)
                .empName("Puran")
                .email("puran@gmail.com")
                .city("Pune")
                .ratings("L")
                .department("DEV")
                .phones(asList("987458823", "999321456"))
                .salary(Double.valueOf(7767))
                .build();

        Employee e4 = Employee.builder()
                .empId(444)
                .empName("Krishan")
                .email("krishan@gmail.com")
                .department("DEV")
                .city("Bangalore")
                .ratings("L")
                .phones(asList("971456123", "889321456"))
                .salary(Double.valueOf(78000))
                .build();

        Employee e5 = Employee.builder()
                .empId(666)
                .empName("Chandan")
                .email("chandhann@gmail.com")
                .ratings("C")
                .department("QA")
                .city("Pune")
                .phones(asList("771156123", "789378956"))
                .salary(Double.valueOf(45267))
                .build();

        Employee e6 = Employee.builder()
                .empId(555)
                .empName("Dharam")
                .email("Dharam@gmail.com")
                .phones(asList("987748596"))
                .department("DEV")
                .ratings("C")
                .city("Bangalore")
                .salary(Double.valueOf(85767))
                .build();

        return Arrays.asList(e1, e2, e3, e4, e5, e6);
    }


}
