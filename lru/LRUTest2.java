package com.csu.lru;

import java.util.HashMap;
import java.util.Map;

/*

 */
public class LRUTest2 {
    //map负责查找，构建一个虚拟的双向链表，它里面安装的就是一个个node结点作为数据载体

    //1、构造一个Node结点作为数据载体
    class Node<K,V>{
        K key;
        V value;
        Node<K,V> prev;
        Node<K,V> next;

        public Node(){
            this.prev = this.next = null;       //前指针=后指针=null
        }

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    //2、构造一个虚拟的双向链表，里面安放的是一个个Node结点，作为数据载体
    class DoubleLinkedList<K,V>{
        Node<K,V> head;
        Node<K,V> tail;
        public DoubleLinkedList(){
            //数据初始化
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;       //双向链表，头的下一个=尾
            tail.prev = head;       //尾的前一个=头
        }

        //添加到头(在头尾中间插入):
        public void  addHead(Node<K,V> node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        //删除节点:
        public void removeNode(Node<K,V> node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        //获得最后一个节点:
        public Node getLast(){
            return tail.prev;
        }
    }

    private int cacheSize;
    Map<Integer,Node<Integer,Integer>> map;
    DoubleLinkedList<Integer,Integer> doubleLinkedList;

    public LRUTest2(int cacheSize){
        this.cacheSize = cacheSize;     //坑位
        map = new HashMap<>();      //负责查找
        doubleLinkedList = new DoubleLinkedList<>();
    }

    //读
    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }

        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);

        return node.value;
    }

    //写
    public void put(int key,int value){
        if (map.containsKey(key)){      //更新的操作
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key,node);

            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        }else {
            if (map.size() == cacheSize){       //坑位满了
                Node<Integer,Integer> lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
            //这才是新增:
            Node<Integer, Integer> newNode = new Node<>(key, value);
            map.put(key,newNode);
            doubleLinkedList.addHead(newNode);
        }
    }

    //3、
    public static void main(String[] args) {
        LRUTest2 lruTest2 = new LRUTest2(3);
        lruTest2.put(1,1);
        lruTest2.put(2,2);
        lruTest2.put(3,3);
        System.out.println(lruTest2.map.keySet());          //[1, 2, 3]

        lruTest2.put(4,4);
        System.out.println(lruTest2.map.keySet());            //[2, 3, 4]

        lruTest2.put(3,3);
        System.out.println(lruTest2.map.keySet());            //[2, 4, 3]
        lruTest2.put(3,3);
        System.out.println(lruTest2.map.keySet());            //[2, 4, 3]
        lruTest2.put(3,3);
        System.out.println(lruTest2.map.keySet());            //[2, 4, 3]
        lruTest2.put(5,5);
        System.out.println(lruTest2.map.keySet());           //[4, 3, 5]
    }
}
