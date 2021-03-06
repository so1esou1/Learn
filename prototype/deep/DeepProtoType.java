package com.csu.prototype.deep;

import java.io.*;

/*
    深拷贝原型模式
 */
public class DeepProtoType implements Serializable,Cloneable {
    public String name; //String属性
    public DeepCloneableTarget deepCloneableTarget;     //引用类型的属性
    //构造方法
    public DeepProtoType(){
        super();
    }

    //完成深拷贝的实现:
    //方式1、克隆的方法:
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        deep = super.clone();       //这里完成对基本数据类型(属性)和字符串的克隆的克隆
        //对引用类型的属性进行单独的处理:
        DeepProtoType deepProtoType = (DeepProtoType)deep;
        deepProtoType.deepCloneableTarget = (DeepCloneableTarget)deepCloneableTarget.clone();       //类型转换，然后调用deepCloneableTarget自己的克隆方法

        return deepProtoType;
    }

    //深拷贝方式二: 通过对象的序列化实现(推荐)
    //以对象流的方式输出去，再以对象流的方式读回来
    public Object deepClone(){
        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);      //把当前这个对象以对象流的方式输出/序列化

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepProtoType copyObj = (DeepProtoType) ois.readObject();

            return copyObj;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            }catch (Exception e2){
                System.out.println(e2.getMessage());
            }
        }
    }
}
