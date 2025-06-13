package com.jdk.handson.question.answer;

import java.util.Arrays;
import java.util.List;

public
class PlayWithCount {
    public static void main (String[] args) {

        List<Integer> elementList = Arrays.asList(22,3,44,66,34,22,44,23,456,21,22,3,22,3,44,3,22);
        // find total element in list using stream api
        System.out.println("total element in list::" +elementList.stream().count());

    }
}
