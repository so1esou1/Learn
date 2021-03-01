package com.csu.tree.binarysorttree;
/*
    二叉排序树代码实现
 */
public class BinarySortTreeTest1 {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环地添加结点到二叉排序树
        for (int i = 0;i < arr.length;i ++){
            binarySortTree.add(new Node(arr[i]));
        }
        //遍历二叉排序树
        binarySortTree.midOrder();          //1,3,5,7,9,10,12       刚好是一个升序

        //测试一下删除叶子结点
        binarySortTree.delNode(9);  //测试叶子节点的情况
        binarySortTree.midOrder();
        binarySortTree.delNode(1);  //测试只有一个子树的结点
        binarySortTree.midOrder();
        binarySortTree.delNode(7);  //测试删除有两颗子树的结点
        binarySortTree.midOrder();


    }
}



//======================================================================
//创建二叉排序树
class BinarySortTree{
    private Node root;
    //添加节点的方法
    public void add(Node node){
        if (root == null){
            root = node;        //如果root为空，则直接让root指向node
        }else {
            root.add(node);
        }
    }
    //中序遍历的方法
    public void midOrder(){
        if (root != null){
            root.midOrder();
        }else {
            System.out.println("二叉排序树是空的，无法遍历");
        }
    }

    //*********************************************************************************
    //查找要删除的结点:
    public Node search(int value){
        if (root == null){
            return null;
        }else {
            return root.search(value);
        }
    }
    //查找父节点
    public Node searchParent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    /**
     *  编写方法
     * @param node  传入的结点(当做二叉排序树的根节点)
     * @return      返回的是以Node结点为根节点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node){
        Node target = node;
        //循环地查找左结点，就会找到最小值
        while (target.left != null){
            target = target.left;
        }
        //这是target就指向了最小结点
        //删除这个最小结点
        delNode(target.value);
        return target.value;
    }

    //删除结点
    public void delNode(int value){
        if (root == null){
            return;
        }else {
            //需要先去找到要删除的结点 targetNode
            Node target = search(value);        //目标要删除的结点
            //如果没有找到要删除的结点
            if (target == null){
                return;
            }
            //如果发现target没有父节点(二叉树只有一个结点||查找的target是根节点)
            if (root.left == null && root.right == null){
                root = null;
                return;
            }
            //去找到target的父结点
            Node parent = searchParent(value);
            //第一种情况:如果要删除的结点是叶子结点
            if (target.left == null && target.right == null){
                //判断target是父节点左子结点还是右子结点
                if (parent.left != null && parent.left.value == value){
                    parent.left = null;         //将左子结点置空
                }else if (parent.right != null && parent.right.value == value){
                    parent.right = null;        //将右子结点置空
                }
            }


            //第三种情况:删除有两颗子树的节点
            else if (target.left != null && target.right != null){
                int minVal = delRightTreeMin(target.right);      //以target的右子节点为根节点
                target.value = minVal;
            }


            //第二种情况:删除只有一颗子树的结点
            else {
                //如果要删除的结点target有左子结点
                if (target.left != null){
                    if (parent != null){            //判断parent是否等于空，才能随便删除任意结点而不报空指针异常，否则只能按顺序删除结点
                        //如果 target 是 parent 的左子结点
                        if (parent.left.value == value){
                            parent.left = target.left;
                        }else {         //如果 target 是 parent 的右子结点
                            parent.right = target.left;
                        }
                    }else {
                        root = target.left;     //parent=null，则让root这个结点指向目标节点的左子结点
                    }
                }else {         //如果要删除的结点target有右子结点
                    if (parent != null){            //判断parent是否等于空
                        //如果 target 是 parent 的左子结点
                        if (parent.left.value == value){
                            parent.left = target.right;
                        }else {             //如果 target 是 parent 的右子结点
                            parent.right = target.right;
                        }
                    }else {
                        root = target.right;         //parent=null，则让root这个结点指向目标节点的右子结点
                    }
                }

            }

        }
    }
}




//=======================================================================
//创建树的结点
class Node{
    int value;
    Node left;
    Node right;
    //构造器
    public Node(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

    //方法一:添加节点的方法(递归的形式，需要满足二叉排序树的要求)
    public void add(Node node){
        if (node == null){
            return;
        }
        //判断传入的结点的值，和当前子树的根节点的值的关系
        if (node.value < this.value){       //传入的值小于当前的值
            if (this.left == null){         //如果当前结点的左子结点为空
                this.left = node;           //传入的值放到当前结点的左子结点
            }else {             //如果左边不为空
                this.left.add(node);    //开始递归
            }
        }else {             //传入的值大于当前的值
            if (this.right == null){        //如果当前结点的右子结点为空
                this.right = node;          //传入的值放到当前结点的右子结点
            }else {
                //递归地向右子树添加
                this.right.add(node);
            }
        }

    }

    //中序遍历的方法
    public void midOrder(){
        if (this.left != null){
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.midOrder();
        }
    }


    //*************************************************************
    //方法二:删除结点的方法
    //二.1：查找要删除的结点：
    public Node search(int value){             //value代表想要删除的值
        if (value == this.value){               //说明找到，直接返回
            return this;
        }else if (value < this.value){      //如果查找的值<当前结点，向左子树递归查找
            if (this.left == null){              //如果左子结点为空,说明找不到了
                return null;
            }
            return this.left.search(value);
        }else {                     //查找的值不小于当前结点,向右子树递归查找
            if (this.right == null){
                return null;
            }else {
                return this.right.search(value);
            }
        }
    }
    //二.2:查找要删除结点的父节点:
    public Node searchParent(int value){            //value代表想要删除的值
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            //表示当前结点就是要删除结点的父节点
            return this;
        }else {
            //如果查找的值小于当前结点的值，并且当前结点的左子结点不为空
            if (value < this.value && this.left != null){
                //向当前结点的左子结点递归查找
                return this.left.searchParent(value);
            }else if (value >= this.value && this.right != null){
                //向当前结点的右子结点递归查找
                return this.right.searchParent(value);
            }else {
                return null;            //没有找到父节点
            }
        }
    }
    //将以上两个方法封装到BinarySortTree类中

}