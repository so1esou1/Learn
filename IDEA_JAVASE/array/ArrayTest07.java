package com.bjpowernode.javase.array;
/*一维数组的深入，数组中存储的类型为：引用数据类型
对于数组来说，实际上只能存储java对象的“内存地址”，数组中存储的每个元素是“引用”。
 */
public class ArrayTest07 {
    public static void main(String[] args) {
        int[] a = {100,200,300};
        System.out.println(a[1]);
        //a[2]= 400;


        int[] array = {1,2,3};
        for (int i = 0;i < array.length;i ++){
            /*int temp = array[i];
            System.out.println(temp);*/
            System.out.println(array[i]);
        }
        //创建一个Animal类型的数组
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        Animal[] animals = {a1,a2};
        //对Animal数组进行遍历
        for (int i = 0;i < animals.length;i ++){
            /*Animal a = animals[i];
            a.move();*/
            //代码合并
            animals[i].move();
        }
        //动态初始化一个长度为2的Animal类型数组
        Animal[] ans = new Animal[2];
        //创建一个Animal对象，放到数组的第一个盒子当中
        ans[0] = new Animal();
        //ans[1] = new Product();    Animal数组中只能放Animal类型，不能存放Product类型
        //Animal数组中可以存放Cat类型的数据，因为Cat是Animal的子类
        ans[1] = new Cat();
        //创建一个Animal类型的数据，数据当中存储Cat和Bird
        Animal[] anis = {new Cat(),new Bird()};   //该数组中存储了两个对象的内存地址
        for (int i =0;i < anis.length;i ++){
            //这个取出来的可能是Cat，也可能是Bird，不过肯定是一个Animal
            //如果调用的方法是父类中已经存在的方法不需要向下转型，直接使用父类型引用调用即可
            Animal an = anis[i];
            an.move();
        }
    }
}
class Animal{
    public void move(){
        System.out.println("Animal move...");
    }
}
class Product{

}
//Cat是子类
class Cat extends Animal{
    public void move(){
        System.out.println("猫在走猫步");
    }
    //特有方法
    public void catchMouse(){
        System.out.println("猫在抓老鼠");
    }
}
//Bird子类
class Bird extends Animal{
    public void move(){
        System.out.println("Bird fly");
    }
    //特有方法
    public void sing(){
        System.out.println("鸟儿在歌唱");
    }
}