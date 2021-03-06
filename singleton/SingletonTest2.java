package com.csu.singleton;
/*
    单例模式饿汉式2：
    静态代码块:
    分析:
    这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块
中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优
缺点和上面是一样的。
    结论：这种单例模式可用，但是可能造成内存浪费
 */
public class SingletonTest2 {
    public static void main(String[] args) {
        Singleton2 instance = Singleton2.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();
        System.out.println(instance == instance2);
    }
}

class Singleton2{
    //1、构造器私有化，外部不能new
    private Singleton2(){
    }

    //2、在本类内部创建对象实例
    private static Singleton2 instance;

    //3、在静态代码块中创建单例对象
    static {
        instance = new Singleton2();
    }

    //3、返回一个公有的静态方法，返回实例对象即可
    public static Singleton2 getInstance(){
        return instance;
    }
}
