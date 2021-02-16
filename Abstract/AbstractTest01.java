package com.csu.javase.Abstract;
/*
1、什么是抽象类？
  抽象类无法实例化，无法创建对象，抽象类是类和类之间有共同特征，由于类本身是不存在的，所有抽象类无法创建对象
  抽象类和抽象类之间还可以再抽象。类到对象是实例化，对象到类是抽象
2、抽象类也属于引用数据类型

3、抽象类怎么定义？
语法：
  [修饰符列表] abstract class 类名{
    类体;
  }

4、抽象类无法实例化、无法创建对象的，
因此抽象类是用来被子类继承的
final不能修饰抽象类，final和abstract不能联用，这两个关键字是对立的

5、抽象类虽然无法实例化，但是抽象类有构造方法，供子类创建对象时使用(super调父类的构造方法)

6、抽象方法：没有实现的方法，没有方法体的方法，例如：
   public abstract void doSome();
   抽象方法特点:(1)没有方法体，以分号结尾(2)前面修饰符列表中有abstract关键字

7、抽象类中可以没有抽象方法，可以有不是抽象方法的普通方法。
但抽象方法一定要出现在抽象类中

8、非抽象类的子类去继承有抽象方法的抽象类的话，必须去实现这个抽象方法(因为抽象方法必须出现在抽象类中)

9、面向抽象，降低程序耦合度，提高程序扩展力，这种编程符合OCP原则

 */

public class AbstractTest01 {
    public static void main(String[] args) {

    }
}
//银行账户类
abstract class Account{

}
//子类继承抽象类，子类可以实例化对象
abstract class CreditAccount extends Account{
    //子类也可以是抽象类
}
