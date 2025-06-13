package com.jdk.handson.hashmap.interworking;

import java.util.Map;

public class MapHelper3 implements Runnable{

    Map<String, Integer> map;

    public MapHelper3(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, "mapHelper-3").start();
    }

    @Override
    public void run() {
        map.put("three", 3);
        try{
            System.out.println("mapHelper-3 sleeing");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}
