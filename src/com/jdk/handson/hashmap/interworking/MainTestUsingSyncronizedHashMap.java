package com.jdk.handson.hashmap.interworking;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MainTestUsingSyncronizedHashMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
         Map<String, Integer> stringIntegerMap = Collections.synchronizedMap(hashMap);
         MapHelper1 mapHelper1 = new MapHelper1(stringIntegerMap);
        MapHelper2 mapHelper2 = new MapHelper2(stringIntegerMap);
        MapHelper3 mapHelper3 = new MapHelper3(stringIntegerMap);
        MapHelper4 mapHelper4 = new MapHelper4(stringIntegerMap);


        for(Map.Entry<String, Integer> hm : stringIntegerMap.entrySet()) {
            System.out.println("key : " + hm.getKey() + "  Value : "+ hm.getValue());
        }
    }
}
