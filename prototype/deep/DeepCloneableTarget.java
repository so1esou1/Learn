package com.csu.prototype.deep;

import java.io.Serializable;

/*

 */
public class DeepCloneableTarget implements Serializable,Cloneable {
    private static final long serialVersionUID = 1L;

    private String cloneName;   //名字

    private String cloneClass;  //类型
    //构造器
    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }
    //因为该类的属性都是String，因此我们这里使用默认的克隆方法完成即可
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
