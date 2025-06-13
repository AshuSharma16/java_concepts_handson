package com.jdk.handson.question.answer;

import com.jdk.handson.db.util.EmployeeDBUtils;
import com.jdk.handson.dto.Employee;

import java.util.List;
import java.util.stream.IntStream;
public class PlayWithStreamAndParrallelStream {
    public static void main (String[] args) {

        long startTime = 0;
        long endTime = 0;

            startTime = System.currentTimeMillis();
            IntStream.range(1,100).forEach(System.out::println);
            endTime = System.currentTimeMillis();
            System.out.println("Time taken by Normal / Seq Stream : " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            IntStream.range(1, 100).parallel().forEach(System.out::println);
            endTime = System.currentTimeMillis();
            System.out.println("Time taken by Parallel Stream : " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            IntStream.range(1, 10).forEach( x -> System.out.println("Thread name : "+ Thread.currentThread().getName() + x));
            endTime = System.currentTimeMillis();

            startTime = System.currentTimeMillis();
            IntStream.range(1, 10).parallel().forEach( x -> System.out.println("Thread name : "+ Thread.currentThread().getName() + x));
            endTime = System.currentTimeMillis();


            List<Employee> employeeList = EmployeeDBUtils.createEmployeeInbulk();

            //use Normal Stream and find the average Salary of employee
            //  optionalDouble average = employeeList.stream().map(Employee::getSalary).mapToDouble(i -> i).average();
            // employeeList.stream().map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();
            startTime = System.currentTimeMillis();
            double averageSalary = employeeList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
            endTime = System.currentTimeMillis();
            System.out.println("Total time taken by Stream : "+ (endTime-startTime) + " :  Average Sal : "+ averageSalary);

            System.out.println("==============================");
            startTime = System.currentTimeMillis();
            double averageSalaryWithPS = employeeList.parallelStream().mapToDouble(Employee::getSalary).average().getAsDouble();
            endTime = System.currentTimeMillis();
            System.out.println("Total time taken by Parallel Stream : "+ (endTime-startTime) + " :  Average Sal : "+ averageSalaryWithPS);



    }
}
