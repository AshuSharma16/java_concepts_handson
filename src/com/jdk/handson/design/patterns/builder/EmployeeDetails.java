package com.jdk.handson.design.patterns.builder;

public class EmployeeDetails {
    private Integer empid;
    private String empname;
    private Double salary;
    private String city;
    private String state;
    private String pin;
    private String orgName;

    private EmployeeDetails(EmployeeBuilder employeeBuilder) {
    this.empid = employeeBuilder.empid;
    this.empname = employeeBuilder.empname;
    this.salary = employeeBuilder.salary;
    }


    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                ", salary=" + salary +
                '}';
    }

    static class EmployeeBuilder {
        private Integer empid;
        private String empname;
        private Double salary;

        public EmployeeBuilder(){
            System.out.println("EmployeeBuilder constructor calling....");
        }

        public EmployeeBuilder setEmpid(Integer empid) {
            this.empid = empid;
            return  this;
        }

        public EmployeeBuilder setEmpname(String empname) {
            this.empname = empname;
            return  this;
        }

        public EmployeeBuilder setSalary(Double salary) {
            this.salary = salary;
            return  this;
        }

        public EmployeeDetails build() {
            System.out.println("EmployeeBuilder build calling....");
            EmployeeDetails employeeDetails = new EmployeeDetails(this);
            return  employeeDetails;
        }
    }
}
