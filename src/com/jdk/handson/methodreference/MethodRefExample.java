package com.jdk.handson.methodreference;

public class MethodRefExample {
    public static void main(String[] args) {
        EmployeeService e1 = new EmployeeService();

        e1.fetchEmpListFromDB().forEach(MethodRefExample::print);

        e1.fetchEmpListFromDB().forEach(new MethodRefExample() ::printList);
        e1.fetchEmpListFromDB().forEach(System.out::print);
        e1.fetchEmpListFromDB().forEach(ob -> System.out.println(ob));
    }

    public static void print(Employee emp) {
        System.out.println(emp);
    }

    public  void printList(Employee emp) {
        System.out.println("from instance method ref : "+ emp);
    }


}