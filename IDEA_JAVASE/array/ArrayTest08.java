package com.bjpowernode.javase.array;
/*关于一维数组的扩容
在java开发中，数组长度一旦确定不可变，那么数组满了怎么办？需要扩容
    在java中对数组的扩容是：
    先新建一个大容量的数组，再将小容量数组中的数据一个一个拷贝到大数组当中
    数组扩容效率较低，因为涉及到拷贝的问题，在以后的开发中注意：尽可能少的进行数组的拷贝，
    可以在创建数组对象的时候预估计多长合适，减少数组扩容次数，提高效率
java中数组怎么进行拷贝的？
    System.arraycopy(五个参数);
 */
public class ArrayTest08 {
    public static void main(String[] args) {
        //拷贝源（从这个数据中拷贝）
        int[] src = {1,11,22,3,4};
        //拷贝目标（拷贝到这个目标数组上）
        int[] dest = new int[20];  //动态初始化一个长度20的数组，每一个元素默认值0
        //调用JDK System类中的arraycopy方法来完成数组的拷贝
        System.arraycopy(src,1,dest,3,2);
        //Object src（源）,  int  srcPos目标,Object dest（源的下标）, int destPos（目标的下标）,int length（长度）

        //遍历目标数组
        for (int i = 0;i < dest.length;i++){
            System.out.println(dest[i]);  //0 0 0 11 22 ....0
        }

        //数组中存储的元素是引用的拷贝
        String[] strs = {"hello","world","study","java","yuyu","mumu","opop"};
        String[] newStrs = new String[20];
        System.arraycopy(strs,0,newStrs,0,strs.length);
        for (int i = 0;i < newStrs.length;i ++){
            System.out.println(newStrs[i]);
        }

    }
}
