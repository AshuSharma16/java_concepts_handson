package com.jdk.handson.question.answer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class findVowel{
    public static void main(String[] args){

        String str = "helloworld";
        final List<String> collect = str.chars().filter(ch -> "AIUOUaeiou".contains(String.valueOf((char) ch))).
                mapToObj(ch -> String.valueOf((char) ch)).
                collect(Collectors.toList());

        System.out.println(collect);

    }
}
