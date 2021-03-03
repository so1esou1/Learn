package com.csu.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/*
    无向图代码实现+深度优先遍历+广度优先遍历
    图的邻接矩阵:
         A   B   C   D   E
     A   0   1   1   0   0
     B   1   0   1   1   1
     C   1   1   0   0   0
     D   0   1   0   0   0
     E   0   1   0   0   0

 */
public class Graph {
    private ArrayList<String> vertexList;       //存储顶点的集合
    private int[][] edges;                      //存储图对应的邻接矩阵
    private int numOfEdges;                     //表示边的数目
    //定义一个数组记录某个顶点是否被访问过(深度优先遍历)
    private boolean[] isVisited;

    //构造器
    public Graph(int n){
        //初始化矩阵和ArrayList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[5];
    }

    //插入节点的方法:
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //添加边的方法:
    /**
     *
     * @param v1    传入的第一个点的下标，即是第几个顶点
     * @param v2    传入的第二个点的下标，即是第几个顶点
     * @param weight    表示边的具体的值
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
    }
    //图里面常用的方法:
    //1、返回节点的个数:
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //2、得到边的数目:
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //3、返回节点i(下标)对应的数据 0->'A'  1->'B' 2->'C'
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //4、返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    //5、显示图对应的矩阵(遍历二维数组)
    public void showGraph(){
        for (int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }


//************************************************************************************
    //得到第一个邻接结点的下标
    /**
     *
     * @param index
     * @return  如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index){
        for (int j = 0;j < vertexList.size();j ++){
            if (edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1,int v2){
        for (int j = v2+1;j < vertexList.size();j ++){
            if (edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    private void dfs(boolean[] isVisited,int i){       //i第一次就是0
        //首先我们访问该节点
        System.out.print(getValueByIndex(i) + "->");
        //将该节点设置为已经访问过
        isVisited[i] = true;            //给已经遍历过的数组打上标记
        //查找结点i的第一个邻接结点w
        int w = getFirstNeighbor(i);
        while (w != -1){                //说明有邻接结点
            if (!isVisited[w]){
                dfs(isVisited,w);       //递归
            }
            //如果w结点已经被访问过
            w = getNextNeighbor(i,w);
        }
    }

    //对dfs进行重载,遍历所有的节点，并进行dfs
    public void dfs(){
        //遍历所有的节点，进行dfs(回溯)
        for (int i = 0;i < getNumOfVertex();i ++){
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }


    //************************************************************************************
    //对节点进行广度优先遍历的方法:
    private void bfs(boolean[] isVisited,int i){
        int u;          //u表示队列的头节点对应的下标
        int w;          //邻接结点下标w
        //需要一个队列,记录结点访问的顺序
        LinkedList queue = new LinkedList();
        //访问节点(输出节点的信息)
        System.out.print(getValueByIndex(i) + "=>");
        //标记为已访问
        isVisited[i] = true;
        //将这个节点假如队列
        queue.addLast(i);           //队列是尾部加，头部取
        while (!queue.isEmpty()){
            //取出队列的头节点下标
            u = (Integer) queue.removeFirst();
            //得到第一个邻接结点的下标w
            w = getFirstNeighbor(u);
            while (w != -1){        //找到
                //是否访问过
                if (isVisited[w]){
                    System.out.println(getValueByIndex(w) + "=>");
                    //标记已经访问
                    isVisited[w] = true;
                    //入队列，已经访问过的进入队列记录下来
                    queue.addLast(w);
                }
                //如果被访问过了，以u为前驱点，找w后面的下一个结点
                w = getNextNeighbor(u,w);       //体现出广度优先
            }
        }
    }



    //遍历所有的结点，都进行广度优先搜索
    public void bfs(){
        for (int i = 0;i < getNumOfVertex();i ++){
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }



    public static void main(String[] args) {
        //测试图是否创建成功
        int n = 5;              //节点的个数是5
        String Vertex[] = {"A","B","C","D","E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环地添加顶点
        for (String vertexValue : Vertex){
            graph.insertVertex(vertexValue);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0,1,1);        //A下标为0，B下标为1，权值为1
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        //显示邻接矩阵
        graph.showGraph();
        /*
        [0, 1, 1, 0, 0]
        [1, 0, 1, 1, 1]
        [1, 1, 0, 0, 0]
        [0, 1, 0, 0, 0]
        [0, 1, 0, 0, 0]
         */


        //测试深度遍历DFS是否ok
        System.out.println("深度遍历");
        graph.dfs();                //A->B->C->D->E->

        System.out.println();

        //测试广度优先遍历BFS是否ok
        System.out.println("广度优先");
        graph.bfs();
    }

}



