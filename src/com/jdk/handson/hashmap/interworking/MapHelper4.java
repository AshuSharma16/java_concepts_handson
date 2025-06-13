package com.jdk.handson.hashmap.interworking;

import java.util.Map;

public class MapHelper4 implements Runnable{

    Map<String, Integer> map;

    public MapHelper4(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, "mapHelper-1").start();
    }

    @Override
    public void run() {
        map.put("four", 4);
        try{
            System.out.println("mapHelper-4 sleeing");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}
