package com.bjpowernode.java2.JDK8;
import java.util.Optional;
/*
    Optional类

    方法:
    创建Optional类对象的方法：
        Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
        Optional.empty() : 创建一个空的 Optional 实例
        Optional.ofNullable(T t)：t可以为null
    判断Optional容器中是否包含对象：
        boolean isPresent() : 判断是否包含对象
        void ifPresent(Consumer<? super T> consumer) ：如果有值，就执行Consumer接口的实现代码，并且该值会作为参数传给它。
    获取Optional容器的对象：
        T get(): 如果调用对象包含值，返回该值，否则抛异常
        T orElse(T other) ：如果有值则将其返回，否则返回指定的other对象。
        T orElseGet(Supplier<? extends T> other) ：如果有值则将其返回，否则返回由Supplier接口实现提供的对象。
        T orElseThrow(Supplier<? extends X> exceptionSupplier) ：如果有值则将其返回，否则抛出由Supp


 */
public class OptinalTest1 {
    public static void main(String[] args) {
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);

    }

}


class Girl{
    private String name;
    public Girl(String name){
        this.name = name;
    }
    public Girl() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}


class Boy{
    private String name;
    public Boy() {
    }
    public Boy(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
