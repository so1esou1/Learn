package com.csu.floyd;

import java.util.Arrays;

/*
    弗洛伊德算法解决最短路径的代码实现
    容易理解、容易编写
 */
public class FloydTest1 {
    public static void main(String[] args) {
        //测试图是否创建成功
        char[] vertex = {'A','B','C','D','E','F','G'};
        //创建原始的邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
        matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
        matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
        matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
        matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
        matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
        matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };
        //创建图对象
        Graph graph = new Graph(vertex.length, matrix, vertex);
        graph.show();
/*
A A A A A A A
(A到A的最短路径是:0)(A到B的最短路径是:5)(A到C的最短路径是:7)(A到D的最短路径是:65535)(A到E的最短路径是:65535)(A到F的最短路径是:65535)(A到G的最短路径是:2)
B B B B B B B
(B到A的最短路径是:5)(B到B的最短路径是:0)(B到C的最短路径是:65535)(B到D的最短路径是:9)(B到E的最短路径是:65535)(B到F的最短路径是:65535)(B到G的最短路径是:3)
C C C C C C C
(C到A的最短路径是:7)(C到B的最短路径是:65535)(C到C的最短路径是:0)(C到D的最短路径是:65535)(C到E的最短路径是:8)(C到F的最短路径是:65535)(C到G的最短路径是:65535)
D D D D D D D
(D到A的最短路径是:65535)(D到B的最短路径是:9)(D到C的最短路径是:65535)(D到D的最短路径是:0)(D到E的最短路径是:65535)(D到F的最短路径是:4)(D到G的最短路径是:65535)
E E E E E E E
(E到A的最短路径是:65535)(E到B的最短路径是:65535)(E到C的最短路径是:8)(E到D的最短路径是:65535)(E到E的最短路径是:0)(E到F的最短路径是:5)(E到G的最短路径是:4)
F F F F F F F
(F到A的最短路径是:65535)(F到B的最短路径是:65535)(F到C的最短路径是:65535)(F到D的最短路径是:4)(F到E的最短路径是:5)(F到F的最短路径是:0)(F到G的最短路径是:6)
G G G G G G G
(G到A的最短路径是:2)(G到B的最短路径是:3)(G到C的最短路径是:65535)(G到D的最短路径是:65535)(G到E的最短路径是:4)(G到F的最短路径是:6)(G到G的最短路径是:0)
 */

        System.out.println("===================================");
        //调用弗洛伊德算法
        graph.floyd();
        graph.show();
/*
A A A F G G A
(A到A的最短路径是:0)(A到B的最短路径是:5)(A到C的最短路径是:7)(A到D的最短路径是:12)(A到E的最短路径是:6)(A到F的最短路径是:8)(A到G的最短路径是:2)
B B A B G G B
(B到A的最短路径是:5)(B到B的最短路径是:0)(B到C的最短路径是:12)(B到D的最短路径是:9)(B到E的最短路径是:7)(B到F的最短路径是:9)(B到G的最短路径是:3)
C A C F C E A
(C到A的最短路径是:7)(C到B的最短路径是:12)(C到C的最短路径是:0)(C到D的最短路径是:17)(C到E的最短路径是:8)(C到F的最短路径是:13)(C到G的最短路径是:9)
G D E D F D F
(D到A的最短路径是:12)(D到B的最短路径是:9)(D到C的最短路径是:17)(D到D的最短路径是:0)(D到E的最短路径是:9)(D到F的最短路径是:4)(D到G的最短路径是:10)
G G E F E E E
(E到A的最短路径是:6)(E到B的最短路径是:7)(E到C的最短路径是:8)(E到D的最短路径是:9)(E到E的最短路径是:0)(E到F的最短路径是:5)(E到G的最短路径是:4)
G G E F F F F
(F到A的最短路径是:8)(F到B的最短路径是:9)(F到C的最短路径是:13)(F到D的最短路径是:4)(F到E的最短路径是:5)(F到F的最短路径是:0)(F到G的最短路径是:6)
G G A F G G G
(G到A的最短路径是:2)(G到B的最短路径是:3)(G到C的最短路径是:9)(G到D的最短路径是:10)(G到E的最短路径是:4)(G到F的最短路径是:6)(G到G的最短路径是:0)
 */
    }
}


//=======================================================================
//创建图
class Graph{
    private char[] vertex;      //存放顶点的数组
    private int[][] dis;        //保存从各个顶点出发到其他顶点的距离，最后结果保留在该数组中
    private int[][] pre;        //保存到达目标顶点的前驱顶点(动态变化着的)
    //构造器
    /**
     *
     * @param length    大小
     * @param matrix    邻接矩阵
     * @param vertex    顶点数组
     */
    public Graph(int length,int[][] matrix,char[] vertex){
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];
        //对pre数组进行初始化，注意存放的是前驱顶点的下标.遍历前各个顶点的前驱顶点就是自身
        for (int i = 0;i < length;i ++){
            Arrays.fill(pre[i],i);
        }
    }

    /**
     * 功能：显示pre数组和dis数组
     */
    public void show(){
        //为了显示便于阅读，我们优化一下输出:
        char[] vertex = {'A','B','C','D','E','F','G'};


        for (int k = 0;k < dis.length;k ++){
            //先输出pre数组的一行数据
            for (int i = 0;i < dis.length;i ++){
                System.out.print(vertex[pre[k][i]] + " ");
            }
            System.out.println();
            //输出完一行pre后紧接着输出dis数组的一行数据
            for (int i = 0;i < dis.length;i ++){
                System.out.print("(" + vertex[k] + "到" + vertex[i] + "的最短路径是:" + dis[k][i] + ")");
            }
            System.out.println();
            System.out.println();
        }
    }



    //***************************************************************************
    /**
     *  弗洛伊德算法
     */
    public void floyd(){
        int len = 0;        //保存距离的变量
        //三层for循环
        for (int k = 0;k < dis.length;k ++){                //对中间顶点的遍历，k就是中间顶点的下标
            for (int i = 0;i < dis.length;i ++){            //对起始顶点的遍历，i就是起始顶点的下标
                for (int j = 0;j < dis.length;j ++){        //对结束顶点的遍历，j就是结束顶点的下标
                    len = dis[i][k] + dis[k][j];        //求出i->k->j的距离长度
                    if (len < dis[i][j]){           //如果i->k->j 小于 直连距离i->j
                        //则更新距离
                        dis[i][j] = len;
                        pre[i][j] = pre[k][j];      //更新前驱顶点
                    }
                }
            }
        }
    }
}