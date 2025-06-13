package com.jdk.handson.db.util;

import com.jdk.handson.dto.Person;

import java.util.Arrays;
import java.util.List;

public
class PersonDBUtils {
    public static List<Person> getPersonList() {
        Person p1 = new Person("Chandan",Double.valueOf(300000),"Java","Male");
        Person p2 = new Person("Geetha", Double.valueOf(55000), "Java", "Female");
        Person p3 = new Person("Rajesh", Double.valueOf(78000), "Python", "Male");
        Person p4 = new Person("Neetika", Double.valueOf(49000), "C", "Female");
        Person p5 = new Person("Kalu", Double.valueOf(45000), "C", "Male");
        Person p6 = new Person("Paramvir", Double.valueOf(60000), "Java", "Male");
        Person p7 = new Person("Sandhya", Double.valueOf(25000), "Java", "Female");
        return  Arrays.asList(p1,p2,p3,p4,p5,p6,p7);
    }
}
