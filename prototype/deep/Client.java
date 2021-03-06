package com.csu.prototype.deep;

public class Client {
    public static void main(String[] args) throws Exception {
        DeepProtoType p = new DeepProtoType();
        p.name = "张三";
        p.deepCloneableTarget = new DeepCloneableTarget("李四","学生");

        //方式1完成深拷贝:
        DeepProtoType p2 = (DeepProtoType)p.clone();

        System.out.println("p.name=" + p.name + "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
        System.out.println("p2.name=" + p2.name + "p2.deepCloneableTarget=" + p2.deepCloneableTarget.hashCode());
        //两个p的哈希码不一样，实现了深拷贝


        //方式二完成深拷贝
        /*DeepProtoType p2 = (DeepProtoType)p.deepClone();

        System.out.println("p.name=" + p.name + "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
        System.out.println("p2.name=" + p2.name + "p2.deepCloneableTarget=" + p2.deepCloneableTarget.hashCode());
         */
    }

}
