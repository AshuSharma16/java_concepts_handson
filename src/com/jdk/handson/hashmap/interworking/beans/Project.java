package com.jdk.handson.hashmap.interworking.beans;

import java.util.Objects;

public class Project {

    private String pName;
    private int pId;

    public Project(String pName, int i) {
        this.pName = pName;
        this.pId = i;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("In equals of Project");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return pId == project.pId && Objects.equals(pName, project.pName);
    }

    @Override
    public int hashCode() {
        System.out.println("In Hashocde of Project");
        return Objects.hash(pName, pId);
    }
}
