package com.jdk.handson.hashmap.interworking.beans;

public class Employee {

    private String eName;
    private int eId;


    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public Employee(String name, int id) {
        this.eId = id;
        this.eName = name;
    }

    public int hashCode() {
        System.out.println("In hashcode");
        int hashcode = 0;
        hashcode = eId * 7;
        hashcode += eName.hashCode();
        return hashcode;
    }

    public boolean equals(Object obj) {
        System.out.println("In equals");
        if (obj instanceof Employee) {
            Employee emp = (Employee) obj;
            return (emp.eName.equals(this.eName) && emp.eId == this.eId);
        } else {
            return false;
        }
    }
}
