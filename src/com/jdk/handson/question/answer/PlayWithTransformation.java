package com.jdk.handson.question.answer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayWithTransformation {
    public static void main(String[] args) {
        List al = Arrays.asList("Ashu", "Kames", "Sandhya", "Uday", "Soni", "Sumanth", "Mano", "Sasidhar");

        // convert a list into map
        // for example - listToMap ::::{Ashu=Ashu, Soni=Soni, Mano=Mano, Sandhya=Sandhya, Sumanth=Sumanth, Sasidhar=Sasidhar, Kames=Kames, Uday=Uday}
        HashMap listToMap = (HashMap) al.stream().collect(Collectors.toMap(e -> e, Function.identity()));
        System.out.println("listToMap ::::"+ listToMap);

        // convert a list into map where key --> element and value --> element length
        // for example - Map ::{Ashu=4, Soni=4, Mano=4, Sandhya=7, Sumanth=7, Sasidhar=8, Kames=5, Uday=4}
        HashMap listToMap1 = (HashMap) al.stream().collect(Collectors.toMap(e -> e, String::length));

        System.out.println("Map ::"+listToMap1);


        // convert a list into map where key --> element elnth and value --> element  and group by element length
        // for example - Map ::{4=Ashu, Uday, Soni, Mano, 5=Kames, 7=Sandhya, Sumanth, 8=Sasidhar}

        HashMap listToMap2 = (HashMap) al.stream().collect(Collectors.toMap(String::length,e -> e ,  (first , second) -> first + ", " + second));

        System.out.println("Map ::"+listToMap2);

        Map<String,List<String>> hm1 = new HashMap<>();
        hm1.put("505", Arrays.asList("ashu", "505-123"));
        hm1.put("205", Arrays.asList("shyam", "205-123"));
        hm1.put("102", Arrays.asList("gopal", "102-123"));
        hm1.put("1000", Arrays.asList("nandlal", "1000-123"));

       /* Stream<Stream<String>> streamStream = hm1.entrySet().stream().map(e1 -> e1.getValue().stream().map(e2 -> e2.toUpperCase()));
        streamStream.forEach(System.out::println);*/

       // hm1.entrySet().stream().map(stringListEntry -> stringListEntry.getValue().get(0).toUpperCase()).forEach(System.out::println);
        Stream<String> stringStream = hm1.entrySet().stream()
                .map(e1 -> e1.getValue().get(0).toUpperCase());

        /*Map<String, String> collect = hm1.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue().get(0)
                        .toUpperCase()));
        System.out.println(collect);*/


        List<String> asList = Arrays.asList("ram", "Shyam", "Kames", "Logesh", "Bittoo");
        asList.stream().sorted().forEach(System.out::println);
        asList.stream().map(i -> i.toUpperCase()).sorted().forEach(System.out::println);

        Map<String, List<String>> collect = hm1.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()
                        .stream().map(e1 -> e1.toUpperCase())
                        .collect(Collectors.toList())));

        System.out.println(collect);


        Map<String, Integer> empMap = new HashMap<>();
        empMap.put("Vishnu", 10000);
        empMap.put("Karan", 1400);
        empMap.put("Raja", 10000);
        empMap.put("Sachin", 12000);

        empMap.replaceAll((key, value) -> value+5000);
        System.out.println(empMap);

    }
}
