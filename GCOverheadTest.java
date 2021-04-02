package com.csu.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/*
    GC回收错误
    参数设置:-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class GCOverheadTest {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("*****i:" + i);
            e.printStackTrace();
            throw e;
        } finally {
        }
    }
}
