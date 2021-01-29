package com.csu.crm;

import java.util.UUID;

/*
UUID生成器 通用唯一识别码（Universally Unique Identifier）
让分布式系统中的所有元素，都能有唯一的辨识信息，而不需要通过中央控制端来做辨识信息的指定
 */
public class UUIDGenerrator {
    private UUIDGenerrator(){

    }

    /**
     * 生产UUID
     * @return
     */
    public static String generate(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
