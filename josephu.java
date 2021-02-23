package com.csu.linkedlist;
/*
    单向循环链表解决约瑟夫难题
 */
public class josephu {
    public static void main(String[] args) {
        //测试
        //先创建一个环形单向链表
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        //创建5个节点的小孩
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        //测试小孩出圈是否正确
        circleSingleLinkedList.countBoy(1,2,5);         //2->4->1->5->3
    }
}




//创建一个环形的单向链表
class CircleSingleLinkedList{
    //创建一个first节点，当前没有编号
    private Boy first = new Boy(-1);        //后面会修改的，只是为了让这个暂时为空
    //添加小孩的节点，构建成环形的链表
    public void addBoy(int nums){       //形参是节点数
        //做一个数据校验
        if (nums < 1){      //至少得有一个
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;      //辅助变量，帮助构建环形链表
        //使用for循环创建环形链表
        for (int i = 1;i <= nums;i ++){
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1){
                first = boy;
                first.setNext(first);       //构成一个环状
                curBoy = first;             //让curboy指向第一个小孩
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前环形链表
    public void showBoy(){
        //先判断链表是否为空
        if (first == null){
            System.out.println("链表为空，没有任何小孩");
            return;
        }
        //因为first不能动，因此仍然使用辅助指针curBoy完成遍历
        Boy curBoy = first;
        while (true){
            System.out.println("小孩的编号:" + curBoy.getNo());
            if (curBoy.getNext() == first){         //判断是否已经到了最后了
                break;
            }//没有满足的话curboy继续往后移
            curBoy = curBoy.getNext();
        }
    }



    /**
     * 根据用户的输入，计算小孩出圈的顺序
     * @param startNo   从第几个小孩开始数数
     * @param countNum  数几下
     * @param nums      最初有多少小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){
        //先做一个校验
        if (first == null || startNo < 1 || startNo > nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建一个辅助指针，帮助完成小孩出圈
        Boy helper = first;     //创建一个辅助变量helper，事先指向环形链表的最后这个节点（first=-1）
        while (true){
            if (helper.getNext() == first){         //说明helper指向到了最后一个小孩节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让 first 和  helper 移动 k - 1次(移动到第k个小孩这来)
        for (int j = 0;j < startNo - 1;j ++){
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数，让first 和 helper 指针同时 的移动  m  - 1 次(因为自己也会报数，把自己的那个减掉)，然后出圈
        //这里是一个循环的操作，知道圈中只有一个节点
        while (true){
            if (helper == first){       //说明圈中只有一个节点
                break;
            }
            //让first、helper同时移动countNum - 1
            for (int j = 0;j < countNum - 1;j ++){
                first = first.getNext();
                helper = helper.getNext();
            }//这时，first指向的节点就是要出圈的节点
            System.out.println("小孩" + first.getNo() + "出圈");
            //这时将first指向的小孩出圈(取消掉它的所有引用)
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩编号:" + first.getNo());
    }
}






//创建一个boy类，表示一个节点
class Boy{
    private int no;     //编号，后面有用
    private Boy next;       //指向下一个节点，默认为null
    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
