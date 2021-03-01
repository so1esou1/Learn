package com.csu.binarytree;

/*
    二叉树前序中序后序遍历的实现
 */
public class BinaryTreeTest1 {
    public static void main(String[] args) {
        //首先需要创建一个二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        Node root = new Node(1, "zhangsan");
        Node node2 = new Node(2, "lisi");
        Node node3 = new Node(3, "wangwu");
        Node node4 = new Node(4, "zhaoliu");
        Node node5 = new Node(5,"wuqi");
        //我们先手动创建二叉树，后面再以递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);   //二叉树与节点绑定
        //二叉树关系形成了

        //测试遍历:
        System.out.println("前序遍历:" );
        binaryTree.preOrder();          //1、2、3、4

        System.out.println("中序遍历:");
        binaryTree.midOrder();          //2、1、3、4

        System.out.println("后序遍历:");
        binaryTree.postOrder();         //2、4、3、1



        //测试查找
        System.out.println("前序遍历方式:");
        Node resNode1 = binaryTree.preOrderSearch(5);
        if (resNode1 != null){
            System.out.println("找到了，信息为no=" + resNode1.getNo() + "name=" + resNode1.getName());
        }else {
            System.out.println("没有找到编号为no=" + resNode1.getNo() + "的英雄");
        }

        System.out.println("中序遍历方式:");
        Node resNode2 = binaryTree.midOrderSearch(5);
        if (resNode2 != null){
            System.out.println("找到了，信息为no=" + resNode2.getNo() + "name=" + resNode2.getName());
        }else {
            System.out.println("没有找到编号为no=" + resNode2.getNo() + "的英雄");
        }

        System.out.println("后序遍历方式:");
        Node resNode3 = binaryTree.postOrderSearch(5);
        if (resNode3 != null){
            System.out.println("找到了，信息为no=" + resNode3.getNo() + "name=" + resNode3.getName());
        }else {
            System.out.println("没有找到编号为no=" + resNode3.getNo() + "的英雄");
        }



        //测试删除结点
        binaryTree.delNode(5);
        System.out.println("删除后二叉树遍历:");
        binaryTree.preOrder();
    }
}



//=========================================================================================


//定义一个binarytree二叉树
class BinaryTree{
    private Node root;      //根节点
    //set方法
    public void setRoot(Node root) {
        this.root = root;
    }
    //前序遍历
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //中序遍历
    public void midOrder(){
        if (this.root != null){
            this.root.midOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }


    //这里不写上会空指针?
    //前序遍历
    public Node preOrderSearch(int no){
        if (root != null){
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    //中序遍历
    public Node midOrderSearch(int no){
        if (root != null){
            return root.midOrderSearch(no);
        }else {
            return null;
        }
    }
    //后序遍历
    public Node postOrderSearch(int no){
        if (root != null){
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }




    //删除结点的方法：
    //考虑如果树是空树root,如果只有一个root结点，则等价将二叉树置空
    public void delNode(int no){
        if (root != null){
            //如果只有一个root结点，这里需要立即判断root是不是就是要删除的结点
            if (root.getNo() == no){
                root = null;
            }else {
                //递归删除
                root.delNode(no);       //这个delNode是结点类的方法
            }
        }else {
            System.out.println("空树不能删除");
        }
    }
    //删除遍历的轨迹是先判断左边，再判断右边，再回到左边，判断左子节点下面的左右子节点，再判断右子节点下面的左右子节点......
}




//=============================================================================================



//创建节点Node
class Node{
    private int no;
    private String name;
    private Node left;              //指向左边的索引，默认为空
    private Node right;             //指向右边的索引，默认为空
    //构造器
    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }



    //(一)节点前序遍历的方法:
    public void preOrder(){
        System.out.println(this);       //先输出父节点
        //递归向左子树
        if (this.left != null){
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null){
            this.right.preOrder();
        }
    }


    //(二)节点中序遍历的方法:
    public void midOrder(){
        //首先先递归向左子树中序遍历
        if (this.left != null){
            this.left.midOrder();
        }
        //输出当前节点(父节点)
        System.out.println(this);
        //递归向右子树中序遍历
        if (this.right != null){
            this.right.midOrder();
        }
    }


    //(三)节点后序遍历的方法:
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }



    //查找节点的方法:
    //(一)、通过前序遍历查找的方式
    /**
     * @param no 查找的no
     * @return  找到就返回Node，没有找到就返回null
     */
    public Node preOrderSearch(int no){
        System.out.println("进入前序查找");       //这句话总共出现了4次
        //比较当前节点是不是
        if (this.no == no){
            return this;
        }
        //1、判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        //如果左递归前序查找找到节点,则返回
        Node resNode = null;
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){       //说明左子树上找到了
            return resNode;
        }
        //没有找到则继续判断右子节点是否为空，不为空则继续向右递归前序查找
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //(三)、通过中序遍历查找的方式
    public Node midOrderSearch(int no){

        //判断当前节点的左子节点是否为空，如果不为空，则递归中序查找
        Node resNode = null;
        if (this.left != null){
            resNode = this.left.midOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        System.out.println("进入中序查找");           //这里将输出3次
        //如果找到则返回，如果没有找到就和当前节点比较，如果是则返回当前节点
        if (this.no == no){
            return this;
        }
        //否则继续向右进行中序查找
        if (this.right != null){
            resNode = this.right.midOrderSearch(no);
        }
        return resNode;
    }

    //(三)、通过后序遍历查找的方式
    public Node postOrderSearch(int no){
        //判断当前节点的左子节点是否为空，如果不为空，则递归后序查找
        Node resNode = null;
        if (this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null){       //说明在左子树找到
            return resNode;
        }
        //如果左子树没有找到，就向右子树递归进行遍历查找
        if (this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        System.out.println("进入后序查找");       //这里将出现2次
        //如果左右子树都没有找到，就比较当前节点是不是
        if (this.no == no){
            return this;
        }
        return resNode;
    }




    //递归删除结点的方法:
    //1、如果删除的结点的是叶子结点，则删除该结点
    //2、如果删除的结点是非叶子结点，则删除该子树
    public void delNode(int no){
        //如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将 this.left = null; 并且就返回
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        //如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将 this.right= null ;并且就返回
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        //否则我们就需要向左子节点进行递归删除
        if (this.left != null){
            this.left.delNode(no);
        }
        //向右子树进行递归删除
        if (this.right != null){
            this.right.delNode(no);
        }

    }

}