package com.jdk.handson.collectors;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public
class Frequency {
    public static void main (String[] args) {
        String str1 = "success";
        // frequencey check

        //final List<Character> collect1 = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        final LinkedHashMap<Character, Long> collect = str1.chars().mapToObj(c -> (char) c).
                collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        System.out.println(collect);

        // find first

        String str = "ilovejavatechie";

        String[] strArray = str.split("");
        System.out.println(Arrays.toString(strArray)); // print array with actual data instead of hashcode


        Map<String, List<String>> grpByElement =
                Arrays.stream(strArray).collect(Collectors.groupingBy(s ->s));
        System.out.println(grpByElement);


        Map<String, Long> map = Arrays.stream(strArray).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //map.forEach((k, v ) -> System.out.println("key : "+ k + "  and Values : "+ v));


    }
}
