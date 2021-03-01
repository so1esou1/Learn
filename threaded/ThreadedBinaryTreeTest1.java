package com.csu.binarytree.threaded;


/*
    线索二叉树的实现(中序遍历方式)
 */
public class ThreadedBinaryTreeTest1 {
    public static void main(String[] args) {
        //测试中序线索二叉树的功能是否正确
        //创建一个二叉树
        Node1 root = new Node1(1, "zhangsan");
        Node1 node2 = new Node1(3, "lisi");
        Node1 node3 = new Node1(6, "wangwu");
        Node1 node4 = new Node1(8, "zhaoliu");
        Node1 node5 = new Node1(10, "wuqi");
        Node1 node6 = new Node1(14, "wangba");
        //二叉树以后会通过递归创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadNodes();
        //以10号node5结点做测试
        Node1 leftNode = node5.getLeft();
        Node1 rightNode = node5.getRight();
        System.out.println("10号结点的前驱节点:" + leftNode);       //3
        System.out.println("10号结点的后继结点是:" + rightNode);     //1

        //遍历线索化二叉树
        System.out.println("使用线索化的方式遍历线索化二叉树");
        threadedBinaryTree.threadedShow();          //8 3 10 1 14 6
    }
}



//=================================================================================
//创建一个实现了线索化功能的二叉树(复制BinaryTreeTest1的二叉树类)
class ThreadedBinaryTree {
    private Node1 root;      //根节点
    //为了实现线索化，需要创建一个指向当前结点的前驱结点的指针.在递归进行线索化时，这个pre总是保留前一个结点
    private Node1 pre = null;
    //set方法
    public void setRoot(Node1 root) {
        this.root = root;
    }
    //重载线索化的方法
    public void threadNodes(){
        this.threadNodes(root);
    }

    //编写对二叉树进行中序线索化的方法
    /**
     * @param node  当前需要线索化的结点
     */
    public void threadNodes(Node1 node){
        //如果node==null，不能线索化，直接退出
        if (node == null){
            return;
        }
        //(1)先线索化左子树
        threadNodes(node.getLeft());
        //(2)线索化当前结点(有难度)
            //处理当前结点的前驱节点
        if (node.getLeft() == null){
            //让当前结点的左指针指向前驱节点
            node.setLeft(pre);          //此时pre还是null，因为这里是第一个左子结点，所以这个结点前驱结点确实应该是null
            //修改当前节点的左指针的类型
            node.setLeftType(1);        //设置当前指针指向前驱节点
        }
            //处理后继结点时在递归的下一次中处理的，上一个结点对应于下一个结点来说是前驱结点，下一结点对上一结点来说是后继结点，
            //因此处理上一结点的后继结点就是处理下一结点的前驱结点，思路与上面类似
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);         //让前驱结点的右指针指向当前节点
            pre.setRightType(1);        //修改前驱节点的右指针类型
        }
        pre = node;         //每处理一个节点之后，让当前结点是下一个结点的前驱结点。如果没有这个代码的话线索化就会失败
        //(3)再线索化右子树
        threadNodes(node.getRight());
    }


    //遍历线索化二叉树的方法:
    /*线索化后，各个结点指向有变化，因此原来的遍历方式不能使用，这时需要使用新的方式遍历线索化二叉树，
      各个节点可以通过线型方式遍历，因此无需使用递归方式，这样也提高了遍历的效率。 遍历的次序应当和中序遍历保持一致。
    */
    public void threadedShow(){
        //定义一个变量,存储当前遍历的结点，从root开始
        Node1 node = root;
        while (node != null){

            while (node.getLeftType() == 0){
                node = node.getLeft();
            }
            //打印当前这个节点
            System.out.println(node);               //输出的node是8号
            //如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() == 1){
                //获取到当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的结点
            node = node.getRight();
        }
        /*
        刚开始的结点是root，!=null,进入大循环。其前驱节点是==0的，进入第一个循环，
        然后root左边是node3，node3的leftType也是0，再次循环到node8,8的leftType=1，因此循环退出，打印8.
        8的rightType是1，进入循环，转成3，打印3，3后面是右子节点不是有效的后继结点，会退出这个循环。
        变成3的右子节点10，10号又重新开始一轮新的大循环。10的左边是有效的线索，跳过第一个循环，打印10，进入第二个循环，
        变成1，输出1...............
         */
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
    public Node1 preOrderSearch(int no){
        if (root != null){
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    //中序遍历
    public Node1 midOrderSearch(int no){
        if (root != null){
            return root.midOrderSearch(no);
        }else {
            return null;
        }
    }
    //后序遍历
    public Node1 postOrderSearch(int no){
        if (root != null){
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }

    //删除结点的方法：
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





//==================================================================================
//创建Node结点(复制二叉树BinaryTreeTest1结点类)
class Node1{
    private int no;
    private String name;
    private Node1 left;
    private Node1 right;
    //说明(不先将线索做好规定就无法写下去):
    //1、如果leftType == 0,表示指向的是左子树，如果是1，则表示指向的是前驱结点
    //2、如果rightType == 0,表示指向的是右子树，如果是1，表示指向的是后继节点
    private int leftType;
    private int rightType;
    //给leftType、rightType设置get、set方法,之后需要用到
    public int getLeftType() {
        return leftType;
    }
    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }
    public int getRightType() {
        return rightType;
    }
    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public Node1(int no, String name) {
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
    public Node1 getLeft() {
        return left;
    }
    public void setLeft(Node1 left) {
        this.left = left;
    }
    public Node1 getRight() {
        return right;
    }
    public void setRight(Node1 right) {
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
        System.out.println(this);
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
    public Node1 preOrderSearch(int no){
        System.out.println("进入前序查找");       //这句话总共出现了4次
        //比较当前节点是不是
        if (this.no == no){
            return this;
        }
        //1、判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        //如果左递归前序查找找到节点,则返回
        Node1 resNode = null;
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
    public Node1 midOrderSearch(int no){

        //判断当前节点的左子节点是否为空，如果不为空，则递归中序查找
        Node1 resNode = null;
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
    public Node1 postOrderSearch(int no){
        //判断当前节点的左子节点是否为空，如果不为空，则递归后序查找
        Node1 resNode = null;
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
