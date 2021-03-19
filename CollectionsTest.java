package com.csu.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/*
    collections工具类
 */
public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("zs");
        list.add("ls");
        list.add("ww");
        list.add("zl");

        //1、反转:
        Collections.reverse(list);

        //2、随机排序:
        Collections.shuffle(list);

        //3、按自然顺序排序(从小到大):
        Collections.sort(list);
        //4、自定义排序顺序:
        Collections.sort(list, new Comparator() {
            public int compare(Object o1,Object o2){
                return ((String)o1).length() - ((String)o2).length();       //按字符串长度排序
            }
        });

        //5、swap(List,int,int):指定List集合中的i处元素和j处元素进行交换
        Collections.swap(list,0,1);     //第一个元素与第二个元素交换

        //6、max:根据元素自然排序，返回集合中最大的元素
        Collections.max(list);
        //自定义顺序，并取出最大值:
        Collections.max(list,new Comparator(){
            public int compare(Object o1,Object o2){
                return ((String)o1).length() - ((String)o2).length();
            }
        });

        //7、min，方法同max

        //8、frequency(Collection,Object)返回指定集合中指定元素的出现次数
        Collections.frequency(list,"zs");

        //9、copy(List dest,List src)拷贝,将src数据拷到dest
        ArrayList dest = new ArrayList();
        Collections.copy(dest,list);
        //注意:这里会直接抛出异常:IndexOutOfBoundException数组下标越界异常，因为dest集合里面没有数据，而list集合里有4个
        //需要先给dest赋值，长度和list一样即可
        for (int i = 0;i < list.size();i ++){
            dest.add("");
        }
        Collections.copy(dest,list);

        //10、replaceAll(List list,Object oldVal,Object newVal)  使用新值替换List对象的所有旧值
        //需求：如果有"lisi",就替换成"lishi":
        Collections.replaceAll(list,"lisi","lishi");
    }
}
