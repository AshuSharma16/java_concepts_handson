package com.jdk.handson.methodreference;

public class Employee {

    private int empId;
    private String empname;
    private Double salary;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee(int empId, String empname, Double salary) {
        super();
        this.empId = empId;
        this.empname = empname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", empname=" + empname + ", salary=" + salary + "]";
    }

}