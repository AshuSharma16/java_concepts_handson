package com.jdk.handson.question.answer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlayWithListInterface {
    public static void main(String[] args) {

        List<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);
        al.add(7);
        System.out.println(al.get(3));  // get teh elemet from index 3
        al.add(77); // add element at last
        System.out.println(al);
        al.remove(3);  // removed teh element from index 3
        System.out.println(al);
    }

    public static
    class UniqueData {
        public static void main (String[] args) {

            List<Integer> elementList = Arrays.asList(22,3,44,66,34,22,44,23,456,21,22,3,22,3,44,3,22);

            //1.  find deplicate element in a given list
            Set<Integer> set = new HashSet<>();
            List<Integer> duplicateElementList = elementList.stream().filter(e -> !set.add(e)).collect(Collectors.toList());
            System.out.println("duplicateElementList ::"+duplicateElementList);

            Set<Integer> set1 = duplicateElementList.stream()
                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(m -> m.getValue() > 1)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toSet());
            System.out.println("Set-1 ::"+set1);

            // 2. using distinct
            List<String> nameList = Arrays.asList("Kames", "Sandy", "Prasad", "prasad", "ashu", "Sandy");

            List<String> uniqueName = nameList.stream().map(name->name.toLowerCase()).distinct().collect(Collectors.toList());
            System.out.println("Unique Name: "+ uniqueName);


        }
    }
}
