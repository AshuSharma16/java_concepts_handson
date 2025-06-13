package com.jdk.handson.hashmap.interworking;

import java.util.Map;

public class MapHelper1 implements Runnable{

    Map<String, Integer> map;

    public MapHelper1(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, "mapHelper-1").start();
    }

    @Override
    public void run() {
        map.put("one", 1);
        try{
            System.out.println("mapHelper-1 sleeing");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}
