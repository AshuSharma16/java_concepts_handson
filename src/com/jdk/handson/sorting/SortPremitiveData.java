package com.jdk.handson.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortPremitiveData {
    public static void main(String[] args) {
        final List<String> list = Arrays.asList("Ashu", "Shyam", "Ram", "Masum");

        // sort based on Collections class
        Collections.sort(list);
        System.out.println(list);
    }
}
