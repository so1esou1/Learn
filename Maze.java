package com.csu.recursion;
/*
    用递归实现迷宫
 */
public class Maze {
    public static void main(String[] args) {
        //先创建一个二维数组模拟迷宫，8行7列
        int[][] map = new int[8][7];
        //使用1表示墙，不能同行
        //先把上下全部置为1
        for (int i = 0;i < 7;i ++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //把左右都置为1
        for (int i = 0;i < 8;i ++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置相应的挡板
        map[3][1] = 1;
        map[3][2] = 1;

        //输出/遍历地图
        for (int i = 0;i < 8;i ++){
            for (int j = 0;j < 7;j ++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }



        //测试：使用递归回溯给小球找路
        //findWay(map,1,1);       //从[1][1]开始走
        findWay2(map,1,1);      //策略不一样，小球走的路径就不一样。在没有学习更好的算法之前，只能通过修改策略测试，把路径保存到集合中，看哪个集合的和最小

        //输出新的地图，这个地图就会显示小球走过并标识过的地图
        System.out.println("小球走过并标识过的地图:");
        for (int i = 0;i < 8;i ++){
            for (int j = 0;j < 7;j ++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    //使用递归回溯来给小球找路
    //找到了为true，找不到为false
    /**
     *  如果小球能到map的[6][5]位置，则说明通路找到
     *  约定:当map[i][j]为0时，表示该点没有走过，当为1时表示墙，不能走，当为2时表示时通路可以走；为3表示该点已经走过，但是走不通
     *  在走迷宫时需要确定一个策略(方法):先走下面，下面走不通再走右，不通走上，最后走左。如果该点走不通再回溯
     * @param map   表示地图
     * @param i     从哪个位置开始找
     * @param j     从哪个位置开始找
     * @return
     */
    public static boolean findWay(int[][] map,int i,int j){
        if (map[6][5] == 2){    //通路已经找到
            return true;
        }else {
            if (map[i][j] == 0){    //如果当前这个点还没有走过
                //按照策略走 下--右--上--左
                map[i][j] = 2;      //假定该点是能走通的
                if (findWay(map, i+1, j)){  //向下走
                    return true;
                }else if (findWay(map, i, j+1)){        //向右走
                    return true;
                }else if (findWay(map, i-1, j)){            //向上走
                    return true;
                }else if (findWay(map, i, j-1)){        //向左走
                    return true;
                }else {
                    //以上都不可以说明这个点是走不通的，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {       //这个点不等于0，map[i][j]=1、2、3,走过或是墙时
                return false;
            }
        }
    }


    //为了能得到最短路径，需要修改找路的策略，改成上--右--下--左
    public static boolean findWay2(int[][] map,int i,int j){
        if (map[6][5] == 2){    //通路已经找到
            return true;
        }else {
            if (map[i][j] == 0){    //如果当前这个点还没有走过
                //按照策略走 下--右--上--左
                map[i][j] = 2;      //假定该点是能走通的
                if (findWay2(map, i-1, j)){  //向上走
                    return true;
                }else if (findWay2(map, i, j+1)){        //向右走
                    return true;
                }else if (findWay2(map, i+1, j)){            //向下走
                    return true;
                }else if (findWay2(map, i, j-1)){        //向左走
                    return true;
                }else {
                    //以上都不可以说明这个点是走不通的，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {       //这个点不等于0，map[i][j]=1、2、3,走过或是墙时
                return false;
            }
        }
    }
}


