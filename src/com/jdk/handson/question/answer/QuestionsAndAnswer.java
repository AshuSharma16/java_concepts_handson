package com.jdk.handson.question.answer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public
class QuestionsAndAnswer {
    public static void main (String[] args) {

        // 1. find the frequency / count of each element ( element -> can be a char , string , int )
        String queryString = "success";
        final Map<Character, Long> collect = queryString.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(collect);

        String str = "success splunk testdata azur azur splunk";
        final Map<String, Long> collect1 = Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(collect1);

        //2. first non repeatable char

        String data = "pprrsstgtcckessf";
        final LinkedHashMap<Character, Long> collect2 = data.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        System.out.println(collect2);

        final List<Character> collect3 = collect2.entrySet().stream().filter(obj -> obj.getValue() == 1).map(ob -> ob.getKey())
                .limit(1).collect(Collectors.toList());
        System.out.println(" first non repeatable char with skip method  : "+ collect3);

        final Optional<Character> first = collect2.entrySet().stream().filter(obj -> obj.getValue() == 1).map(ob -> ob.getKey())
                .findFirst();
        System.out.println(" first non repeatable char with find first method  : "+ first.get());

        //3 find 1st repeatable char
        final Optional<Character> firstMatchFound = collect2.entrySet().stream().filter(obj -> obj.getValue() > 1).map(ob -> ob.getKey()).findFirst();
        final Character c = firstMatchFound.get();
        System.out.println(c);

        //4 . find each duplicate element
        final List<Map.Entry<Character, Long>> allDuplicateElement = collect2.entrySet().stream().filter(obj -> obj.getValue() > 1).collect(Collectors.toList());
        System.out.println("List of all duplicate char" + allDuplicateElement);




    }
}
