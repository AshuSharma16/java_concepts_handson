package com.jdk.handson.design.patterns.singleton;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Client {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException, CloneNotSupportedException {
        final LazyInitialzationSingleton instance1 = LazyInitialzationSingleton.getInstance();
        final LazyInitialzationSingleton instance2 = LazyInitialzationSingleton.getInstance();
        boolean isMutilpeInstanceCreated = instance1.hashCode() == instance2.hashCode() ? false : true;
            System.out.println("isMutilpeInstanceCreated  : "+ isMutilpeInstanceCreated);

            // trying to breaking the singleton
            // using reflection
        /* final Constructor<EmployeeSingleton> declaredConstructor = EmployeeSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        final EmployeeSingleton instance3 = declaredConstructor.newInstance();
        boolean isMutilpeInstanceCreated2 = instance1.hashCode() == instance3.hashCode() ? false : true;
        System.out.println("isMutilpeInstanceCreated2  : "+ isMutilpeInstanceCreated2);;*/

        //2. using Serializationa dn Deserialzation
        // Serialized the object
       /* final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("employee.ser"));
        System.out.println("objectOutputStream ::"+ objectOutputStream);
        objectOutputStream.writeObject(instance1);
        objectOutputStream.close();

         // De-Serialized teh object
        final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("employee.ser"));
        final LazyInitialzationSingleton employeeSingleton4 = (LazyInitialzationSingleton) objectInputStream.readObject();
        boolean isMutilpeInstanceCreated4 = instance1.hashCode() == employeeSingleton4.hashCode() ? false : true;
        System.out.println("isMutilpeInstanceCreated4  : "+ isMutilpeInstanceCreated4);;*/

        //3. Using Clone
       /* final LazyInitialzationSingleton clonedObject =(LazyInitialzationSingleton) instance1.clone();
        boolean isMutilpeInstanceCreated5 = instance1.hashCode() == clonedObject.hashCode() ? false : true;
        System.out.println("isMutilpeInstanceCreated5  : "+ isMutilpeInstanceCreated5);;*/


        LazyInnerClassSingleton ob1 = LazyInnerClassSingleton.getInstance();
        LazyInnerClassSingleton ob2 = LazyInnerClassSingleton.getInstance();

        System.out.println(ob1.hashCode());
        System.out.println(ob2.hashCode());


    }
}
