package com.jdk.handson.design.patterns.singleton;

import java.io.Serializable;

public class LazyInitialzationSingleton implements Serializable , Cloneable {

    private static LazyInitialzationSingleton singletonInstance = null;

    private LazyInitialzationSingleton() throws IllegalAccessException, InstantiationException {
        System.out.println("constrctor calling ....");
        // avaoid create another object using reflection
        if(singletonInstance != null) {
            throw new InstantiationException("instance already created");
        }
    }

    // avaoid create another object using Serialization
    public Object readResolve()  {
        return  singletonInstance;
    }

    public  Object clone() throws CloneNotSupportedException {
        throw  new CloneNotSupportedException();
    }

    public static synchronized LazyInitialzationSingleton getInstance() throws IllegalAccessException, InstantiationException {
        if(singletonInstance == null) {
            singletonInstance = new LazyInitialzationSingleton();
        }
        return  singletonInstance;
    }


}
