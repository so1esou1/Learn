package com.csu.linkedlist;

import java.util.Stack;

import static com.csu.linkedlist.SingleLinkedList2.*;

/*
    按照顺序插入节点
 */
public class SingleLinkedListTest2 {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "sj", "www");
        HeroNode2 hero3 = new HeroNode2(3, "wy", "ojx");
        HeroNode2 hero4 = new HeroNode2(4, "lc", "czx");
        HeroNode2 hero2 = new HeroNode2(2,"ljy","asd");
        //创建一个链表
        SingleLinkedList2 singleLinkedList2 = new SingleLinkedList2();
        //加入
        singleLinkedList2.addByOrder(hero1);
        singleLinkedList2.addByOrder(hero2);
        singleLinkedList2.addByOrder(hero3);
        singleLinkedList2.addByOrder(hero4);
        //显示
        singleLinkedList2.list();

        //测试修改
        HeroNode2 newHeroNode = new HeroNode2(3,"yy","ssa");
        singleLinkedList2.update(newHeroNode);

        //测试删除
        singleLinkedList2.del(1);

        //获取单链表中有效节点的个数
        SingleLinkedList2 sll = new SingleLinkedList2();
        System.out.println("有效的节点个数为:" + sll.getLength(singleLinkedList2.getHead()));

        //测试倒数第k个的方法
        HeroNode2 res = findLnode(sll.getHead(),1);


        //测试反转单链表的功能
        reverseList(singleLinkedList2.getHead());


        //测试逆序打印单链表(链表本身的结构没有发生变化)
        reverPrint(singleLinkedList2.getHead());
    }
}




class SingleLinkedList2{
    //先初始化一个头节点,不存放具体的数据，不用动
    private HeroNode2 head = new HeroNode2(0,"","");
    public HeroNode2 getHead() {
        return head;
    }

    //添加节点到单项链表，要求按照顺序插入
    public void addByOrder(HeroNode2 heroNode2){
        //仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为是单链表，我们找到temp是位于添加位置的前一个节点，否则加不进去
        HeroNode2 temp = head;
        boolean flag = false;       //标志添加的节点是否存在，默认是false
        while (true){
            if (temp.next == null){     //说明temp已经在链表的最后，不能添加
                break;
            }
            if (temp.next.no > heroNode2.no){
                //就是这个位置，在temp后面插入,停止循环
                break;
            }else if (temp.next.no == heroNode2.no){    //说明编号已经存在了
                flag = true;
                break;
            }
            temp = temp.next;       //temp后移，相当于遍历当前链表
        }
        //判断flag的值
        if (flag){      //如果为真，编号已有，不能再添加
            System.out.println("准备插入的人物" + heroNode2.no + "已经存在了，不能插入");
        }else {
            //插入到链表中
            heroNode2.next = temp.next;     //插入的节点的next指向原来temp的下一个节点
            temp.next = heroNode2;          //temp的next指向插入的节点
        }
    }



    //显示链表(head不能动，创建辅助变量进行遍历)
    public void list(){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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


    //修改节点的信息：根据编号修改其他两个属性
    public void update(HeroNode2 newHeroNode){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        //先定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false;       //表示是否找到该节点
        while (true){
            if (temp == null){
                break;         //表示链表已经遍历完了
            }
            if (temp.no == newHeroNode.no){
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {     //没有找到这个节点
            System.out.println("没有找到编号为" + newHeroNode.no + "的节点，不能修改");
        }
    }



    //删除节点的方法
    //思路：1、head节点不能动，仍需要一个temp辅助节点，找到待删除节点的前一个节点
    //2、在比较时，是temp.next.no与需要删除节点的no比较
    public void del(int no){
        HeroNode2 temp = head;
        boolean flag = false;       //是否找到待删除节点的
        while (true){
            if (temp.next == null){     //已经到了链表的最后
                break;
            }
            if (temp.next.no == no){
                //找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;       //temp后移，实现遍历
        }
        //判断flag
        if (flag){
            //为真，可以删除
            temp.next = temp.next.next;
        }else {
            System.out.println("要删除的" + no + "节点不存在");
        }
    }


    //获取单链表中有效节点的个数的方法(如果带头节点，需要去掉)
    public static int getLength(HeroNode2 head){
        if (head.next == null){         //空链表
            return 0;
        }
        //定义辅助变量
        int length = 0;
        HeroNode2 cur = head.next;
        while (cur != null){
            length ++;
            cur = cur.next;     //遍历
        }
        return length;
    }


    //查找单链表中倒数第K个节点的方法
    //思路：1、编写一个方法，接收head节点，同时接收一个index(倒数第index个节点)
    //2、先把链表从头到尾遍历一下，得到链表的总的长度size(省略，调用上面的getLength即可)
    //3、从链表的第一个开始遍历，遍历size-index个
    public static HeroNode2 findLnode(HeroNode2 head,int index){
        //判断如果链表为空，返回null
        if (head.next == null){
            return null;    //没有找到
        }
        //第一次遍历，得到链表的长度
        int size = getLength(head);
        //第二次遍历size-index 位置，就是我们的倒数第K个节点
        //先做一个index的校验，判断其是否合理
        if (index <= 0 || index > size){
            return null;
        }
        //定义一个辅助变量（指针）,for循环定位到倒数的index
        HeroNode2 cur = head.next;
        for (int i = 0;i < size - index;i ++){
            cur = cur.next;
        }
        return cur;
    }



    //将单链表反转的方法（头插法）
    /*思路
        1. 先定义一个节点 reverseHead = new HeroNode();
        2. 从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端.
        将下一个节点插入上一个插入的节点与头节点reverseHead之间，再改变这三个节点间的next指向
        3. 原来的链表的head.next = reverseHead.next
     */
    public static void reverseList(HeroNode2 head){
        //如果当前链表为空，或只有一个节点，则无须反转，直接返回
        if (head.next == null || head.next.next == null){
            return;
        }
        //先定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode2 cur = head.next;
        HeroNode2 next = null;      //设定指向当前节点的下一个节点为空
        HeroNode2 reverseHead = new HeroNode2(0,"","");     //新链表的头节点
        //遍历原来的链表，每遍历一次就取出放到reverseHead最前端
        while (cur != null){        //cur指向了空，代表已经遍历完了
            next = cur.next;        //备份cur指针的下一个节点
            cur.next = reverseHead.next;        //cur的节点指向原先reverseHead指向的下一个节点
            reverseHead.next = cur;         //reverseHead指向cur，实现了将cur插入reverseHead与下一个节点之间
            cur = next;     //让cur后移指针，将其指向next备份的地方，以此进行循环
        }
        //将head.next指向reverseHead.next(新链表的第一个节点)，实现单链表的反转
        head.next = reverseHead.next;
    }



    //使用栈的方式实现逆序打印单链表
    public static void reverPrint(HeroNode2 head){
        if (head.next == null){
            return;        //空链表，无法打印
        }
        //创建一个栈，将各个节点压入栈中
        Stack<HeroNode2> stack = new Stack<>();
        HeroNode2 cur = head.next;
        //将链表的所有节点压入栈中
        while(cur != null){
            stack.push(cur);
            cur = cur.next;     //后移，压入下一个
        }
        //将栈中的节点打印，pop出栈
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

}





class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;       //next指向下一个节点

    //构造器

    public HeroNode2(int no, String name, String nickname) {
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
