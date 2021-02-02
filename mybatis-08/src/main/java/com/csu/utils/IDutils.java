package com.csu.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

public class IDutils {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");//生成一个随机数
    }

    @Test
    public void test(){
        System.out.println(IDutils.getId());
    }

}
