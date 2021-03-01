package com.csu.tree.huffmantree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
    哈夫曼树代码实现
 */
public class HuffmanTreeTest1 {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node root = createHuffmanTree(arr);

        //测试(前序遍历方式):
        preOrder(root);             //67  29  38  15  7.............
    }


    //创建赫夫曼树的方法
    /**
     * @param arr   需要创建成赫夫曼树的数组
     * @return      创建好后的赫夫曼树的root结点
     */
    public static Node createHuffmanTree(int[] arr){
        //1、为了操作方便，先遍历arr数组,将arr的每个元素构建成一个Node,将Node放入到ArrayList中，便于管理
        List<Node> nodes = new ArrayList<Node>();
        for (int value : arr ){
            nodes.add(new Node(value));     //每遍历一个就放进nodes中
        }
        //我们处理的过程应该是一个循环的过程
        while (nodes.size() > 1){           //因为不停地加、删，nodes中实际上只有一个结点。直到最后排序完才能有3个结点，此时退出
            //排序，从小到大
            Collections.sort(nodes);
            System.out.println("nodes =" + nodes);      //1 3 6 7 8 13 29

            //取出根节点权值最小的两颗二叉树
            //(1)取出权值最小的结点(看作是最简单的二叉树)
            Node leftNode = nodes.get(0);
            //(2)再取出第二小的结点
            Node rightNode = nodes.get(1);
            //(3)构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //(4)从ArrayList中删除处理过的二叉树(这样的话后面的数才能成为最小的)
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //(5)将parent加入到nodes(parent成为新的二叉树的一个成员)
            nodes.add(parent);
            System.out.println("第一次处理过后的二叉树:" + nodes);         //6 7 8 13 29
        }
        //最后返回赫夫曼树的头root结点
        return nodes.get(0);
    }



    //编写一个前序遍历的方法
    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("该赫夫曼树是空树，不能遍历");
        }
    }
}



//创建结点类
//为了让Node类对象支持Collection集合排序，需要让Node类实现Comparable接口
class Node implements Comparable<Node>{
    int value;      //结点的权值
    Node left;      //指向左子结点
    Node right;     //指向右子结点
    //构造器
    public Node(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
    @Override    //实现compareTo方法
    public int compareTo(Node o) {
        //表示从小到大排
        return this.value - o.value;
    }


    //写一个前序遍历以做测试用
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
}
