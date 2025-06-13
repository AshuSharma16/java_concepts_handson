package com.jdk.handson.design.patterns.singleton;

import java.io.Serializable;

public class LazyInitialzationSingletonDoubleLock implements Serializable, Cloneable {

    private static LazyInitialzationSingletonDoubleLock singletonInstance = null;

    private LazyInitialzationSingletonDoubleLock() throws IllegalAccessException, InstantiationException {
        System.out.println("constrctor calling ....");
        // avaoid create another object using reflection
        if (singletonInstance != null) {
            throw new InstantiationException("instance already created");
        }
    }

    // avaoid create another object using Serialization
    public Object readResolve() {
        return singletonInstance;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static LazyInitialzationSingletonDoubleLock getInstance() throws IllegalAccessException, InstantiationException {
        if (singletonInstance == null) {
            synchronized (LazyInitialzationSingletonDoubleLock.class) {
                if (singletonInstance == null) {
                    singletonInstance = new LazyInitialzationSingletonDoubleLock();
                }
            }

        }
        return singletonInstance;
    }


}
