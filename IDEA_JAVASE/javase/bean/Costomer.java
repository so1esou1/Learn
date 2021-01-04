package com.bjpowernode.javase.bean;

import java.rmi.StubNotFoundException;
import java.util.Objects;

public class Costomer {
    private String name;
     public Costomer(){

     }

    public Costomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //hashCode

    //equals
    //如果顾客名字一样，表示同一个顾客
    /*public boolean equals(Object obj){
         if (obj == null || !(obj instanceof Costomer))return false;
         if (obj == this)return true;
         Costomer c = (Costomer)obj;
         if (this.name.equals(c.name)) return true;
         return false;
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Costomer costomer = (Costomer) o;
        return Objects.equals(name, costomer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}



