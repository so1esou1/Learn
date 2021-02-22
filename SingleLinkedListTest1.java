package com.csu.linkedlist;
/*
    以水浒排名次为例，实现单链表(直接添加到链表尾部的形式)
    这是按照添加的顺序排序的，没有考虑到编号
 */
public class SingleLinkedListTest1 {
    public static void main(String[] args) {
        //测试
        //先创建节点对象
        HeroNode hero1 = new HeroNode(1, "sj", "www");
        HeroNode hero2 = new HeroNode(2,"ljy","asd");
        HeroNode hero3 = new HeroNode(3, "wy", "ojx");
        HeroNode hero4 = new HeroNode(4, "lc", "czx");
        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        //显示
        singleLinkedList.list();
    }
}

//定义SingleLinkedList管理人物
class SingleLinkedList{
    //先初始化一个头节点,不存放具体的数据，不用动
    private HeroNode head = new HeroNode(0,"","");
    //添加节点到单项链表
    //思路：当不考虑编号的顺序时
    //1、找到当前链表的最后节点
    //2、将最后这个节点的next域指向新的节点即可
    public void add(HeroNode heroNode){
        //因为head节点不动，所以需要一个辅助遍历的指针temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.next;
        }
        //当退出while循环时，表示temp就指向了链表的最后
        temp.next = heroNode;
    }
    //显示链表(head不能动，创建辅助变量进行遍历)
    public void list(){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            //判断是否到了链表的最后
            if (temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将next后移，打印下一个,否则将是个死循环
            temp = temp.next;
        }
    }
}

//定义HeroNode
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;       //next指向下一个节点

    //构造器

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方便重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
