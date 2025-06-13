package com.jdk.handson.question.answer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfSquareOfEvenNumber {
    public static void main(String[] args) {
        final int sum = IntStream.range(0, 11).filter(i -> i % 2 == 0).map(x -> x * x).sum();
        System.out.println(sum);
    }

    public static class PlyaWithToMap {
        public static void main(String[] args) {
            toMapMethod();

        }

        private static void toMapMethod() {
            List<String> al = Arrays.asList("ashu", "Bittoo", "Vritika", "one", "two", "three", "ash99u");
            final int length = al.stream().collect(Collectors.joining()).length();
            System.out.println(length);

            final String collect = al.stream().collect(Collectors.joining());
            System.out.println(collect);

            final Map<String, Integer> collect1 = al.stream().collect(Collectors.toMap(a -> a, b -> b.length()));
             System.out.println(collect1);

            final Map<Integer, String> collect2 = al.stream().collect(Collectors.toMap(String::length, e -> e, (oldValue, newValue) -> oldValue));
            System.out.println(collect2);
        }
    }
}
