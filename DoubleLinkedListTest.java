package com.csu.linkedlist;
/*
    代码实现双向链表
 */
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        //先创建节点：
        HNode hero1 = new HNode(1, "sj", "www");
        HNode hero3 = new HNode(3, "wy", "ojx");
        HNode hero4 = new HNode(4, "lc", "czx");
        HNode hero2 = new HNode(2,"ljy","asd");
        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero4);

        doubleLinkedList.list();
    }
}


class DoubleLinkedList{
    private HNode head = new HNode(0,"","");
    public HNode getHead() {
        return head;
    }

    //遍历双向链表的方法，与单向链表一样
    public void list(){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HNode temp = head.next;
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


    //添加节点的方法(默认在最后添加),单向链表上进行修改
    public void addByOrder(HNode hNode){
        HNode temp = head;
        boolean flag = false;       //标志添加的节点是否存在，默认是false
        while (true){
            if (temp.next == null){     //说明temp已经在链表的最后，不能添加
                break;
            }
            if (temp.next.no > hNode.no){
                //就是这个位置，在temp后面插入,停止循环
                break;
            }else if (temp.next.no == hNode.no){    //说明编号已经存在了
                flag = true;
                break;
            }
            temp = temp.next;       //temp后移，相当于遍历当前链表
        }
        //当退出while循环的时候，temp就指向了链表的最后
        //形成一个双向链表
        temp.next = hNode;
        hNode.pre = temp;
    }


    //修改一个节点,与单向链表一致
    public void update(HNode newhNode){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        //先定义一个辅助变量
        HNode temp = head.next;
        boolean flag = false;       //表示是否找到该节点
        while (true){
            if (temp == null){
                break;         //表示链表已经遍历完了
            }
            if (temp.no == newhNode.no){
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag){
            temp.name = newhNode.name;
            temp.nickname = newhNode.nickname;
        }else {     //没有找到这个节点
            System.out.println("没有找到编号为" + newhNode.no + "的节点，不能修改");
        }
    }


    //删除双向链表中的节点,与单向链表差距较大
    //对于双向链表，我们可以直接找到要删除的节点，而不需要找到前一个节点，找到后自我删除即可
    public void del(int no){
        //判断当前链表是否为空
        if (head.next == null){
            System.out.println("链表为空，不能删除");
            return;
        }
        HNode temp = head.next;      //辅助变量(辅助指针),从第二个节点开始，单向链表中是从head开始的
        boolean flag = false;   //标识是否找到节点
        while (true){
            if (temp == null){          //已经到了链表最后的next了，在单向链表中，这里写成temp.next
                break;
            }
            if (temp.no == no){
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if (flag){
            //可以删除
            //temp.next = temp.next.next;   单向链表删除方式
            temp.pre.next = temp.next;
            //temp.next.pre = temp.pre;   假如删除的是最后一个节点，这一句就有问题，最后一个节点就不需要执行这句话，否则会出现空指针异常
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("要删除的节点" + no + "不存在");
        }
    }

}



//创建一个双向链表类
class HNode{
    public int no;
    public String name;
    public String nickname;
    public HNode next;
    public HNode pre;           //指向前一个节点，默认为null
    public HNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
