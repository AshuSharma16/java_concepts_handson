package com.jdk.handson.question.answer;

import com.jdk.handson.db.util.EmployeeDBUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayWithReduceAndAggregation {
    public static void main(String[] args) {

        List<Integer> numericList = Arrays.asList(12, 34, 22, 54, 67, 43, 34, 54);
        String strArr[]= {"java8", "Kafka", "Docker", "K8", "Azur with Mocroservice"};
        String lonestString = Arrays.stream(strArr).reduce((a,b) -> a.length() > b.length() ? a : b).get();
        System.out.println(lonestString);


        List<Integer> al = Arrays.asList(11,22,1,2,33,44);
        // find the sum of in element
        // 1st approach
        Integer reduce = al.stream().reduce(0,(a,b) -> a.intValue() + b.intValue());
        System.out.println(reduce);

        System.out.println("------------------------------");
        // 2nd approach
        Optional<Integer> reduce1 = al.stream().map(i -> i.intValue()).reduce((a,b) -> a + b);
        Integer i = reduce1.get();
        System.out.println(i);


        System.out.println("------------------------------");
        // 3rd  approach
        //int sum = al.stream().mapToInt(value -> value.intValue()).sum();
        IntStream intStream = al.stream().mapToInt(value -> value.intValue());
        int sum = intStream.sum();

        System.out.println(sum);

        // skip
        System.out.print("-------------skip-----------");
        IntStream.range(1,10).skip(2).forEach(System.out::print);

        // limit
        System.out.println("-------------limit-----------");
        IntStream.range(1,20).limit(15).forEach(System.out::print);

        //skip with limit
        System.out.print("-------------skip with limit-----------");
        IntStream.range(1,10).skip(2).limit(5).forEach(System.out::print);

        List<Integer> al1 = Arrays.asList(11,2,3,4,5,6,78,55,67,22);
        final List<Integer> collect = al1.stream().skip(1)
                .limit(8)
                .collect(Collectors.toList());
        System.out.println(collect);

        // whitout use of sum method
        final int reduce3 = IntStream.range(0, 100).filter(x -> x % 2 == 0).reduce(0, (x, y) -> (x + y));
        System.out.println(reduce3);

        // with the help of sum method
        final int sum1 = IntStream.range(0, 100).filter(x -> x % 2 == 0).sum();
        System.out.println(sum1);

        // with the help of sum method
        final int reduce2 = IntStream.range(0, 100).filter(x -> x % 2 == 0).reduce(0, Integer::sum);
        System.out.println(reduce2);


        // skip
        System.out.print("-------------skip-----------");
        IntStream.range(1, 10).skip(2).forEach( System.out::print);

        // limit
        System.out.println("-------------limit-----------");
        IntStream.range(1, 20).limit(15).forEach(System.out::print);

        //skip with limit
        System.out.print("-------------skip with limit-----------");
        IntStream.range(1, 10).skip(2).limit(5).forEach(System.out::print);

        // find sum of numbers
        //1st approach to get sum of all number
        List<Integer> numberList = Arrays.asList(11,2,3,4,21,44,55);
        Integer sumOfNum = numberList.stream().reduce(0, Integer::sum);
        System.out.println(sumOfNum);

        //2nd approach to get sum of all number
        Integer sumOfNum2 = numberList.stream().reduce(0, (a, b)-> a+b);
        System.out.println(sumOfNum2);

        //3rd approach to get sum of all number
        Integer sumOfNum3 = numberList.stream().mapToInt(i2 -> i2).sum();
        System.out.println(sumOfNum3);


        // find max number in a list

        Optional<Integer> maxNum = numberList.stream().reduce((a, b) -> a> b ?a : b);
        System.out.println(maxNum.get());

        Optional<Integer> maxNum2 = numberList.stream().reduce(Integer ::max);
        System.out.println(maxNum2.get());

        OptionalInt maxNum3 = numberList.stream().mapToInt(i1 -> i1).max();
        System.out.println(maxNum3.getAsInt());
            IntStream.range(0, 11).forEach(System.out::println);


        List<Integer> listOfElemet = Arrays.asList(10, 34, 23, 55, 66, 123, 42);
        Optional<Integer> maxElement = listOfElemet.stream().max((a, b) -> a.compareTo(b));
        if (maxElement.isPresent()) {
            System.out.println(maxElement.get());
        }

        final OptionalDouble average = EmployeeDBUtils.getEmployees().stream().mapToDouble(x -> x.getSalary()).average();
        if (average.isPresent()) {
            System.out.println(average.getAsDouble());
        }

        // calculate the sum of all integer elements
        System.out.println("calculate the sum of all integer elements ::::");
        // using reduce method custom impl
        Integer totalSum = numericList.stream().reduce(0, (i1, i2) -> i1 + i2);
        System.out.println("totalSum >>>>>>>>" + totalSum);
        //using inbuilt aggregation method
        Optional<Integer> aggregateSum = numericList.stream().reduce(Integer::sum);
        if (aggregateSum.isPresent()) {
            Integer sumOfInt = aggregateSum.orElseGet(() -> 100);
            Integer sum2 = aggregateSum.get();
            System.out.println("sumOfInt >>>>>>>>" + sumOfInt);
            System.out.println("sum2 >>>>>>>>" + sum2);
        }
    }

}
