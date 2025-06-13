package com.jdk.handson.hashmap.interworking;

import java.util.Map;

public class MapHelper2 implements Runnable{

    Map<String, Integer> map;

    public MapHelper2(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, "mapHelper-2").start();
    }

    @Override
    public void run() {
        map.put("two", 2);
        try{
            System.out.println("mapHelper-2 sleeing");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}
