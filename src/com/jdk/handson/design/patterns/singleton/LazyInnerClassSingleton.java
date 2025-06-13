package com.jdk.handson.design.patterns.singleton;

public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton() {
    }

    public static LazyInnerClassSingleton getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final LazyInnerClassSingleton instance = new LazyInnerClassSingleton();
    }

}
