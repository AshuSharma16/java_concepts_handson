package com.jdk.handson.question.answer;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindNthNonReaptingChar {

    public static void main(String[] args) {
        String st = "There is a tree tree has a leaves and leaves are green in color";
        final char nthNonReaptingChar = findNthNonReaptingChar(st, 5);
        System.out.println(nthNonReaptingChar);

    }

    private static char findNthNonReaptingChar(String s, int n) {
        final char[] chars = s.toCharArray();
       /* for(char ch : chars) {
            System.out.println(ch);
        }*/
        Map<Character, Integer> hm = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            hm.put(chars[i], hm.containsKey(hm.get(i)) ? hm.get(i) + 1 : 1);
        }
        System.out.println(hm);
        return hm.entrySet().stream().filter(x -> x.getValue() == 1).skip(n).map(x -> x.getKey()).findFirst().get();
    }
}


