package com.jdk.handson.question.answer;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseAnArray {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};
        reverseAnArray(arr);

        String st = "HappyNewYear";
        Set<String> hs= new HashSet<>();
        final List<String> collect = Arrays.stream(st.split("")).filter(ch -> hs.add(ch)).collect(Collectors.toList());
        System.out.println(collect);
        /*int arr1[] = {1,2,3};
        int j = 0;
        for(int i = arr1.length-1; i >=0;i--) {

            int temp = arr1[i];
            arr1[j] = temp;
            j++;

        }
        System.out.println(arr1[j]);
    }*/
    }
    private static void reverseAnArray(Integer[] arr) {
        Collections.reverse(Arrays.asList(arr));
        System.out.println(Arrays.asList(arr));

    }


}
