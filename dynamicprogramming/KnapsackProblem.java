package com.csu.dynamicprogramming;
/*
    动态规划解决背包问题
    (1)  v[i][0]=v[0][j]=0;
    (2) 当w[i]> j 时：v[i][j]=v[i-1][j]
    (3) 当j>=w[i]时： v[i][j]=max{v[i-1][j], v[i]+v[i-1][j-w[i]]}

 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1,4,3};      //物品的重量
        int[] val = {1500,3000,2000};       //物品的价值，这里的val[i]就是v[i]
        int m = 4;      //背包的容量
        int n = val.length;     //物品的个数

        //创建二维数组，表示
        //v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n+1][m+1];          //代表行和列
        //为了记录放入物品的情况，定一个二维数组
        int[][] path = new int[n+1][m+1];

        //初始化第一行和第一列,这里在本程序中可以不去处理，默认为0
        for (int i = 0;i < v.length;i ++){
            v[i][0] = 0;        //将第一列设置为0
        }
        for (int i = 0;i < v[0].length;i ++){
            v[0][i] = 0;        //将第一行设置为0
        }




        //根据前面得到的公式来动态规划处理
        for (int i = 1;i < v.length;i ++){      //不处理第一行
            for (int j = 1;j < v[0].length;j ++){       //不处理第一列
                //套用公式
                if (w[i-1] > j){          //-1了才是从第一个开始(因为原来公式是从0开始的)
                    v[i][j] = v[i-1][j];
                }else{
                    //公式进行调整:
                    //v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);

                    //因为为了记录物品存放到背包的情况，不能简单地使用上面的公式了
                    //需要使用if else来替代处理
                    if (v[i-1][j] < val[i-1] + v[i-1][j-w[i-1]]){
                        v[i][j] = val[i-1] + v[i-1][j-w[i-1]];
                        //把当前的情况记录到path
                        path[i][j] = 1;
                    }else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }

        //输出v看看
        for (int i = 0;i < v.length;i ++){
            for (int j = 0;j < v[i].length;j ++){
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        //输出最后放入的哪些商品
        //遍历path,我们只需要最后的放入情况，以下的写法会把所有的放入情况都得到:
        /*for (int i = 0;i < path.length;i ++){
            for (int j = 0;j < path[i].length;j ++){
                if (path[i][j] == 1){
                    System.out.println("第" + i + "个物品放入背包");
                }
            }
        }*/

        //动脑筋:
        int i = path.length - 1;        //行的最大下标
        int j = path[0].length - 1;     //列的最大下标
        while (i > 0 && j > 0){          //从path数组的嘴都开始找
            if (path[i][j] == 1){       //=1说明这个点曾经放过数据
                System.out.println("第" + i + "个物品放入背包");
                j -= w[i-1];        //w[i-1]
            }
            i --;
        }
    }
}



