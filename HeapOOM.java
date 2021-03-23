package com.csu.jvm;

import java.util.ArrayList;

/**
 * @author so1esou1
 * @ClassName   模拟堆溢出,jprofiles解决
 * @Date 2021.1.4
 * @TODO
 */
public class HeapOOM {
    byte[] arr = new byte[1 * 1024 * 1024];     //1m
    public static void main(String[] args) {
        ArrayList<HeapOOM> list = new ArrayList<>();
        int count = 0;

        try {
            while (true){
                list.add(new HeapOOM());
                count ++;
            }
        }catch (Exception e){
            System.out.println("count" + count);
            e.printStackTrace();
        }


    }
}
