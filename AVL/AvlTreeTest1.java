package com.csu.tree.AVL;
/*
    代码实现:平衡二叉树+左旋转
 */
public class AvlTreeTest1 {
    public static void main(String[] args) {
        //创建数组
        int[] arr = {4,3,6,5,7,8};          //左旋转用示例
        //int[] arr = {10,12,8,9,7,6};        //右旋转用示例

        //创建一个AVLTree对象
        AVLTree avlTree = new AVLTree();
        //添加结点
        for (int i = 0;i < arr.length;i ++){
            avlTree.add(new Node(arr[i]));
        }
        //遍历（中序遍历）
        System.out.println("中序遍历");
        avlTree.midOrder();             //345678

        //平衡处理后的树的高度:
        System.out.println("树的高度:" + avlTree.getRoot().height());
        System.out.println("树的左子树的高度" + avlTree.getRoot().leftHeight());
        System.out.println("树的右子树的高度" + avlTree.getRoot().rightHeight());
        System.out.println("当前根节点=" + avlTree.getRoot());
        //此时两颗树的高度差>1，因此需要左旋转
    }
}



//======================================================================
//创建AVL树(直接复制的BinarySortTreeTest1中的BinarySortTree类)
class AVLTree{
    private Node root;
    public Node getRoot() {
        return root;
    }
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



//======================================================================
//创建结点(直接复制的BinarySortTreeTest1中的Node):添加方法---返回当前结点的高度+左旋转方法
class Node{
    int value;
    Node left;
    Node right;

    //**********************************************
    //返回当前结点的高度的方法(以该结点为根节点的树的高度)
    public int height(){
        return Math.max(left == null ? 0 : left.height(),right == null ? 0 : right.height()) + 1;
    }
    //返回左子树的高度:
    public int leftHeight(){
        if (left == null){
            return 0;
        }
        return left.height();
    }
    //返回右子树的高度
    public int rightHeight(){
        if (right == null){
            return 0;
        }
        return right.height();
    }


    //********************************************************************************************
    //(右子树比左子树高时)左旋转的方法：
    private void leftRotate(){
        //1、以当前根结点的值创建新的结点
        Node newNode = new Node(value);
        //2、把新的结点的左子树设置成当前节点的左子树
        newNode.left = left;
        //3、把新的结点的右子树设置成当前结点的右子树的左子树
        newNode.right = right.left;
        //4、把当前节点的值替换成右子结点的值
        value = right.value;
        //5、把当前节点的右子树设置成右子树的右子树
        right = right.right;
        //6、把当前节点的左子结点设置成新的结点
        left = newNode;
    }
    //左旋转方法调用的时机(下面的add方法后面)是在添加结点的时候，判断高度差


    //(左子树比右子树高时)右旋转的方法:
    private void rightRotate(){
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

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


        //当添加完一个结点之后，如果:(右子树的高度-左子树的高度) > 1，则进行左旋转
        //(注意:需要记得考虑双旋转的情况)
        if (rightHeight() - leftHeight() > 1){
            //如果它的右子树的左子树的高度>它的右子树的高度
            //先对右子结点进行右旋转再对当前结点进行左旋转
            if (right != null && right.leftHeight() > right.rightHeight()){
                //先对右子结点进行右旋转
                right.rightRotate();
                //再对当前结点进行左旋转
                leftRotate();
            }else {
                leftRotate();
            }
            return;         //记得必须写上返回return，否则可能会进入右旋转的方法中进行判断
        }
        //当添加完一个结点之后，如果:(左子树的高度-右子树的高度) > 1，则进行右旋转
        //(注意:需要记得考虑双旋转的情况)
        if (leftHeight() - rightHeight() > 1){
            //如果它的左子树的右子树的高度>它的左子树的高度
            //先进行左旋转再进行右旋转
            if (left != null && left.rightHeight() > left.leftHeight()){
                //先对当前结点的左结点(左子树)进行左旋转
                left.leftRotate();
                //再对当前结点进行右旋转
                rightRotate();
            }else {         //否则直接进行右旋转即可
                rightRotate();
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
}
