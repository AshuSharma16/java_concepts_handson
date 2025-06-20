package com.jdk.handson.question.answer;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingAndCounting{
    public static void main(String[] args){
        String input[] = {"dog", "cat", "elephant","ant", "fox","giraf", "rabit","mouse", "pig","zebra", "owl"};

        final Map<Integer, Long> WithMethodRefcollect = Arrays.stream(input)
                .collect(Collectors.groupingBy(String::length,Collectors.counting()));
        System.out.println(WithMethodRefcollect);

        final Map<Integer, Long> WithLambdacollect = Arrays.stream(input)
                .collect(Collectors.groupingBy(element -> element.length(),Collectors.counting()));
        System.out.println(WithLambdacollect);
    }
}
