package com.jdk.handson.design.patterns.builder;

public class TestBuilderDesignPattern {

    public static void main(String[] args) {

        UserDetails userDetails = new UserDetails.UserBuilder().setUserId(101).setUserName("ashu").setEmail("ashu16.sh@gmail.com").build();
        System.out.println(userDetails);
        UserDetails userDetails2 = new UserDetails.UserBuilder().setUserName("ashu").setEmail("ashu16.sh@gmail.com").build();
        System.out.println(userDetails2);

        EmployeeDetails employeeDetails = new EmployeeDetails.EmployeeBuilder().setEmpid(963271).setEmpname("Raj Kumar mani").setSalary(5000000D)
                .build();
        System.out.println(employeeDetails);
    }
}
