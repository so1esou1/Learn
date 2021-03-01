package com.csu.binarytree;
/*
    实现顺序二叉树
 */
public class ArrayBinaryTreeTest1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        //创建一个ArrayBinaryTree对象
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        //arrayBinaryTree.preOrder(0);        //从根结点0开始
        arrayBinaryTree.preOrder();
        //结果顺序是:1245367


    }
}


//===========================================================================


//编写一个ArrayBinaryTree，实现顺序存储二叉树的遍历
class ArrayBinaryTree{
    private int[] arr;      //存储二叉树结点数据的数组
    //构造器
    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }
    //重载preOrder方法，使得不用每次都传第一个值0进去
    public void preOrder(){
        this.preOrder(0);
    }


    //编写顺序存储二叉树的前序遍历的方法
    public void preOrder(int index){            //index即二叉树中数组的下标，以0(根节点)开始
        //如果数组为空或数组arr.length = 0
        if (arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        System.out.println(arr[index]);     //输出当前这个元素
        //向左递归遍历
        if (index * 2 + 1 < arr.length){            //防止左子节点的数组下标越界
            preOrder(index * 2 + 1);        //第n个元素的左子节点的下标为  2 * n + 1
        }
        //向右递归遍历
        if (index * 2 + 2 < arr.length){            //防止右子节点的数组下标越界
            preOrder(index * 2 + 2);           //第n个元素的右子节点的下标为  2 * n + 2
        }
    }
}

