package com.bjpowernode.javase.danlink;

public class Test {
    public static void main(String[] args) {
        Link link = new Link();
        link.add(100);
        link.add(200);
        link.add(300);
        System.out.println(link.size());
    }
}
