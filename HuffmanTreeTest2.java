package com.csu.tree.huffmantree;

import java.io.*;
import java.util.*;

/*
    赫夫曼树实现数据压缩
 */
public class HuffmanTreeTest2 {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";        //要编译的字符串
        byte[] contentBytes = str.getBytes();                       //使用平台的默认字符集将此String编码为byte序列，并将结果储存到新的byte数组中
        System.out.println(contentBytes.length);            //40


        /*分步式地写:
        //测试nodes集合
        List<Node1> nodes = getNode(contentBytes);
        System.out.println("nodes=" + nodes);

        //测试创建的二叉树
        System.out.println("赫夫曼树");
        Node1 huffmanTreeRoot = createHuffmanTree(nodes);
        System.out.println("前序遍历");
        huffmanTreeRoot.preOrder();

        //测试是否生成了对应的哈夫曼编码
        getCodes(huffmanTreeRoot);
        System.out.println("生成的哈夫曼编码表是:" + huffmanCodes);//{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}

        //测试
        byte[] huffmanCodeBytes = zip(contentBytes,huffmanCodes);
        System.out.println("huffmanCodeBytes" + Arrays.toString(huffmanCodeBytes));
        //[-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]   一共17个，相比于原来的40个，已经实现了一半的压缩

         */


        //直接使用封装后的方法进行测试:
        byte[] huffmanCodesBytes = huffmanZip(contentBytes);
        System.out.println("压缩后的结果是:" + Arrays.toString(huffmanCodesBytes));
        //[-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]  长度是17



        //测试解压赫夫曼编码
        byte[] sourceBytes = decode(huffmanCodes, huffmanCodesBytes);
        System.out.println("原来的字符串=" + new String(sourceBytes));



        //测试压缩文件
        String srcFile = "x://xxx.xx";
        String dstFile = "x://xxx.xx";
        zipFile(srcFile,dstFile);
        System.out.println("压缩文件成功");           //想要解压这个文件需要自己写算法，用其他的解压文件不可以


        //测试解压文件
        String zipFile2 = "x://xx.xx";
        String dstFile2 = "x://xx.xx";
        unZipFile(zipFile2,dstFile2);
        System.out.println("解压成功");
    }


    /**
     *
     * @param bytes 接受字节数组
     * @return      返回的就是List形式[Node1[date=97,weight=5],Node1[]date=32,weight=9.......]
     */
    private static List<Node1> getNode(byte[] bytes){
        //先创建一个ArrayList
        ArrayList<Node1> nodes = new ArrayList<>();
        //遍历bytes，统计每一个byte出现的次数->map
        HashMap<Byte,Integer> counts = new HashMap<>();
        for (byte b : bytes){
            Integer count = counts.get(b);
            if (count == null){         //map还没有这个字符数据,第一次
                counts.put(b,1);
            }else {                 //不是第一次
                counts.put(b,count+1);
            }
        }
        //把每个键值对转成一个Node对象，并加入到nodes集合
        for (Map.Entry<Byte,Integer> entry : counts.entrySet()){
            nodes.add(new Node1(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }




    //通过List创建对应的赫夫曼树
    private static Node1 createHuffmanTree(List<Node1> nodes){
        while (nodes.size() > 1){
            //排序,从小到大
            Collections.sort(nodes);
            //取出第一颗最小的二叉树
            Node1 leftNode = nodes.get(0);
            //取出第二颗最小的二叉树
            Node1 rightNode = nodes.get(1);
            //创建一颗新的二叉树，它的根结点没有data，只有权值(它的权值是下面两颗树的权值的和),事实上会有很多创建的根节点只有权重没有data值
            Node1 parent = new Node1(null, leftNode.weight+ rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            //将已经处理过的二叉树从nodes中删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树，加入到nodes
            nodes.add(parent);
        }
        //nodes最后的结点就是赫夫曼树的根节点
        return nodes.get(0);
    }



    //前序遍历的方法
    private static void preOrder(Node1 root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("赫夫曼树为空，不能遍历");
        }
    }



    //***************************************************
    //生成赫夫曼树对应的赫夫曼编码
    //思路分析:
    //1、将赫夫曼编码表存放到Map<Byte,String>中
    //形式如:32=01 97=100......
    static Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();
    //2、在生成赫夫曼编码表时需要不停地取拼接路径，定义一个StringBuilder存储某个叶子结点的路径
    static StringBuilder stringBuilder= new StringBuilder();
    /**
     * 功能:将传入的node结点的叶子结点的赫夫曼编码得到，并放入到huffmanCodes集合中
     * @param node  传入的结点，默认从根节点中传
     * @param code  规定路径:左子结点是0，右子结点是1
     * @param stringBuilder     用于拼接路径的
     */
    private static void getCodes(Node1 node,String code,StringBuilder stringBuilder ){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将传入的code加入到stringBuilder2
        stringBuilder2.append(code);
        if (node != null){      //如果node=空则不处理
            //判断当前node是叶子节点还是非叶子结点
            if (node.data == null){     //非叶子结点，要递归处理
                //向左递归
                getCodes(node.left,"0",stringBuilder2);
                //向右递归
                getCodes(node.right,"1",stringBuilder2);
            }else {     //不为空，说明是个叶子节点,找到了某个叶子结点的最后
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
    }


    //为了调用方便，这里重载一下getCodes
    private static Map<Byte,String> getCodes(Node1 root){            //传入赫夫曼树的根节点就行
        if (root == null){
            return null;
        }
        //不为空，则先处理root的左子树
        getCodes(root.left,"0",stringBuilder);
        //处理root的右子树
        getCodes(root.right,"1",stringBuilder);
        return huffmanCodes;
    }


    //*************************************************************
    /**
     * 编写一个方法,将字符串对应的bute[]数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码表压缩后的bute[]数组
     * @param bytes     原始的字符串对应的byte数组
     * @param huffmanCodes  生成赫夫曼编码Map数组
     * @return      返回赫夫曼编码处理后的一个byte数组
     */
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        //1、先利用赫夫曼编码表huffmanCodes 将byte 转成赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes数组
        for (byte b : bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }

        //将"10101000101111111100100......."转成byte[]数组,byte数组才能发送
        //2、统计返回的byte[] huffmanCodesBytes 的长度有多大
        int len;
        if (stringBuilder.length() % 8 == 0){       //因为是每8位对应一个byte
            len = stringBuilder.length() / 8;
        }else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建一个存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;      //记录是第几个byte的计数器
        for (int i = 0;i < stringBuilder.length();i += 8){
            String strByte;
            if (i+8 > stringBuilder.length()){          //最后一位会不够8位
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i,i + 8);
            }
            //将strByte转成一个byte，放入到huffmanCodeBytes
            huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte,2);
            index ++;
        }
        return huffmanCodeBytes;
    }


    //*****************************************************************************
    /**
     * 使用一个方法，将前面的方法封装起来方便调用
     * @param bytes 原始的字符串对应的字节数组，即contentBytes
     * @return      返回的是经过赫夫曼编码处理后的字节数组(压缩后的数组)
     */
    private static byte[] huffmanZip(byte[] bytes){
        List<Node1> nodes = getNode(bytes);
        //根据nodes创建赫夫曼树
        Node1 huffmanTreeRoot = createHuffmanTree(nodes);
        //生成对应的赫夫曼编码(根据赫夫曼树)
        Map<Byte,String> huffmanCodes = getCodes(huffmanTreeRoot);
        //根据生成的赫夫曼编码压缩，得到压缩后的赫夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes,huffmanCodes);

        return huffmanCodeBytes;
    }



    //*************************************************************************
    //完成数据的解压
    //思路:
    //1、将huffmanCodeBytes 重新先转成赫夫曼编码对应的二进制的字符串
    //2、赫夫曼编码对应的二进制的字符串  =>  对照赫夫曼编码重新转成原来的字符串

    /**
     * 该方法是将一个byte转成一个二进制的字符串
     * @param b      传入的byte
     * @param flag  表示是否需要补高位，如果是true表示需要补，false不补,如果是最后一个字节无须补高位
     * @return      是该b 对应的二进制的字符串(注意是补码返回)
     */
    private static String byteToBitString(boolean flag,byte b){
        //使用一个变量保存b(将b转成一个int，因为只有Integer才有toBinaryString()方法)
        int temp = b;
        //如果是正数，还存在补高位的问题
        if (flag){
            temp |= 256;        //temp 1 => 000
        }
        String str = Integer.toBinaryString(temp);
        if (flag){
            return str.substring(str.length() - 8);     //取后面8位
        }else {
            return str;
        }
    }
    /**
     * 解码的方法:
     * @param huffmanCodes  赫夫曼编码表Map
     * @param huffmanBytes  上一方法中哈夫曼编码的到的字节数组
     * @return      返回的就是原来的字符串对应的数组
     */
    private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){
        //1、先得到huffmanBytes 对应的二进制的字符串
        StringBuilder stringBuilder1 = new StringBuilder();
        //2、将byte数组转成二进制的字符串
        for (int i = 0;i < huffmanBytes.length;i ++){
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder1.append(byteToBitString(!flag,b));
        }

        //把字符串按照指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行交换，因为要反向查询
        Map<String,Byte> map = new HashMap<String,Byte>();
        for (Map.Entry<Byte,String> entry : huffmanCodes.entrySet()){
            map.put(entry.getValue(), entry.getKey());
        }

        //创建一个集合存放byte
        List<Byte> list = new ArrayList<>();
        for (int i = 0;i < stringBuilder1.length();){           //i可以理解成一个索引，扫描stringBuilder
            int count = 1;      //小的计数器
            boolean flag = true;
            Byte b = null;
            while (flag){
                //递增地取出key'1'或'0'
                String key = stringBuilder1.substring(i,i+count);   //i不动，让count移动，直到匹配到一个字符
                b = map.get(key);
                if (b == null){     //说明没有匹配到
                    count ++;
                }else {             //匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count;         //i直接移动到count
        }
        //当for循环结束后，list中就存放了所有的字符
        //把list中的数据放在一个byte[]并返回
        byte[] b = new byte[list.size()];
        for (int i = 0;i < b.length;i ++){
            b[i] = list.get(i);
        }
        return b;
    }




    //***************************************************************************
    /**
     * 编写一个方法，将文件进行压缩(会使用到IO)
     * @param srcFile       传入的希望压缩的文件的全路径
     * @param dstFile       将压缩文件放到哪个目录下
     */
    public static void zipFile(String srcFile,String dstFile){
        //先创建输出流
        ObjectOutputStream oos = null;
        OutputStream os = null;
        //创建文件输入流
        FileInputStream is = null;
        try {
            //创建文件的输入流读取文件
            is = new FileInputStream(srcFile);
            //创建一个和源文件大小一样的byte[]数组
            byte[] b = new byte[is.available()];
            //读取文件
            is.read(b);
            //直接对源文件进行压缩
            byte[] huffmanBytes = huffmanZip(b);
            //创建文件的输出流，存放压缩文件
            os = new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            //把赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            //以对象流的方式写入赫夫曼编码，目的是以后解压源文件时使用，可以直接将huffmanBytes以对象的形式输出出去
            //注意：一定要把赫夫曼编码写入压缩文件
            oos.writeObject(huffmanCodes);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                is.close();
                os.close();
                oos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //编写一个方法，完成对压缩文件的解压
    /**
     * @param zipFile   准备要解压的文件
     * @param dstFile   将文件解压到哪个路径
     */
    public static void unZipFile(String zipFile,String dstFile){
        //先定义文件的输入流
        InputStream is = null;
        //定义一个对象输入流
        ObjectInputStream ois = null;
        //定义文件的输出流
        OutputStream os = null;
        try{
            //创建文件输入流
            is = new FileInputStream(zipFile);
            //创建一个和is关联的对象输入流
            ois = new ObjectInputStream(is);
            //读取byte数组 huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取赫夫曼编码表
            Map<Byte,String> huffmanCodes = (Map<Byte,String>)ois.readObject();
            //解码
            byte[] bytes = decode(huffmanCodes,huffmanBytes);
            //将bytes写入到目标文件
            //创建文件输入流
            os = new FileOutputStream(dstFile);
            //写出数据到文件中
            os.write(bytes);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            //关闭流的顺序要和打开流的顺序一致
            try {
                os.close();
                ois.close();
                is.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}






//==================================================================
//写结点类
class Node1 implements Comparable<Node1>{
    Byte data;      //存放数据(字符)本身，比如'a'=>97   ' '=>32
    int weight;     //权值，表示字符出现的次数
    Node1 left;
    Node1 right;
    //构造器
    public Node1(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node1 o) {
        return this.weight - o.weight;
    }
    @Override
    public String toString() {
        return "Node1[" +
                "data=" + data +
                ", weight=" + weight +
                ']';
    }

    //写一个前序遍历
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
