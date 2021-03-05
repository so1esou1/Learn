package com.csu.prim;

import java.util.Arrays;

/*
    普利姆算法
 */
public class PrimAlgorithmTest1 {
    public static void main(String[] args) {
        //测试看看图是否创建成功
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组描述
        int[][] weight = new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}};           //10000代表不能走通的路，权值太大一定不会选择
        //创建一个MGraph的对象
        MGraph mGraph = new MGraph(verxs);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph,verxs,data,weight);
        //输出
        minTree.show(mGraph);
        /*
        [10000, 5, 7, 10000, 10000, 10000, 2]
        [5, 10000, 10000, 9, 10000, 10000, 3]
        [7, 10000, 10000, 10000, 8, 10000, 10000]
        [10000, 9, 10000, 10000, 10000, 4, 10000]
        [10000, 10000, 8, 10000, 10000, 5, 4]
        [10000, 10000, 10000, 4, 5, 10000, 6]
        [2, 3, 10000, 10000, 4, 6, 10000]
         */

        //测试普利姆算法
        minTree.prim(mGraph,0);
        /*结果:
            边<A,G> 权值是:2
            边<G,B> 权值是:3
            边<G,E> 权值是:4
            边<E,F> 权值是:5
            边<F,D> 权值是:4
            边<A,C> 权值是:7
         */
    }
}

//=========================================================================
//创建最小生成树->村庄的图
class MinTree{
    //创建图的邻接矩阵
    /**
     *
     * @param graph 图对象
     * @param verxs 图对应的顶点的位置
     * @param data  图的各个顶点的值
     * @param weight    图的邻接矩阵
     */
    public void createGraph(MGraph graph,int verxs,char data[],int[][] weight){
        int i,j;
        for (i = 0;i < verxs;i++){
            graph.data[i] = data[i];
            for (j = 0;j < verxs;j ++){
                graph.weight[i][j] = weight[i][j];
            }
        }
    }
    //显示图的方法
    public void show(MGraph graph){
        //显示图的对应的邻接矩阵
        for (int[] link : graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }

    //编写一个prim算法,得到最小生成数
    /**
     *
     * @param graph 图
     * @param v     从图的第几个顶点开始生成（其实从任意顶点开始生成都可以）
     */
    public void prim(MGraph graph,int v){
        int[] visited = new int[graph.verxs];       //visited标记结点是否被访问过,初始化为0，访问过为1
        //把当前节点标记为已访问
        visited[v] = 1;
        int h1 = -1;
        int h2 = -1;        //用h1、h2记录两个顶点的下标(-1比较显眼)
        int minWeight = 10000;      //后面在遍历过程会会被替换
        for (int k = 1;k < graph.verxs;k ++){       //因为有graph.verxs个顶点，普利姆算法结束后有graph.verxs-1条边.从第二个点开始
            //确定每一次生成的子图，和哪个结点距离最近
            for (int i = 0;i < graph.verxs;i ++){       //i结点表示被访问过的结点
                for (int j = 0;j < graph.verxs;j ++){   //j表示还没有被访问过的结点
                    //先看i有没有被访问过，访问过了看与i相连的j们哪个没有被访问过，判断这些ij间权值最小的，替换原来的minWeight,h1、h2获得i、j的值
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight){
                        //替换minWeight，寻找i与j们连线中最小的权值
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边是最小
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值是:" + minWeight);
            //将当前这个结点标记为已经被访问
            visited[h2] = 1;
            //重置minWeight
            minWeight = 10000;
        }
    }
}




//=========================================================================
//创建图表
class MGraph{
    int verxs;       //表示图中结点的个数
    char[] data;        //存放结点的数据
    int[][] weight;     //存放边的权值，就是邻接矩阵
    //构造器
    public MGraph(int verxs){
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
