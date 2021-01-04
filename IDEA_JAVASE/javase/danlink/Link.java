package com.bjpowernode.javase.danlink;
/*
链表类（单向链表）
链表优点：由于链表上的元素在空间存储上内存地址不连续
        所以随机增删元素的时候不会有大量元素位移，因此随机增删效率较高
        在以后的开发过程中，如果遇到随机增删集合中元素的业务较多时，交易使用LinkedList
链表缺点：不能通过数学表达式计算被查找元素的内存地址，每一次查找都是从头节点开始遍历，直到找到为止，所以检索/查找效率较低

LinkList也可以创建下标
 */
public class Link {
    //头节点
    Node header = null;

    int size = 0;

    public int size(){
        return size;
    }

    //向链表中添加元素的方法（向末尾添加）
    public  void  add(Object data){
        //创建一个新的节点对象
        //让之前单链表的末尾节点next指向新节点对象。
        //有可能这个元素是第一个，也可能是第二个，也可能是第三个
        if (header == null){
            //说明还没有节点
            //new一个新的节点对象，作为头节点
            //这时候头节点既是一个头节点又是一个末尾节点
            new Node(data,null);
        }else {
            //说明头不是空
            //头节点已经存在了
            //找出当前末尾节点，让当前末尾的next节点是新节点
            Node currentLastNode = findLast(header);
            currentLastNode.next = new Node(data,null);
        }
        size++;
    }

    /**
     * 专门查找末尾节点的方法
     */
    private Node findLast(Node node) {
        if (node.next == null){
            //如果一个节点的next是null
            //说明这个节点就是末尾节点
            return node;
        }
        //程序能够到这里说明：node不是末尾节点
        return findLast(node.next);   //递归算法
    }

    //删除链表中某个数据的方法
    public void remove(Object obj){

    }

    //修改链表中某个数据的方法
    public void modify(Object obj){

    }

    //查找链表中某个元素的方法
    public int find(Object obj){
        return 1;
    }
}
