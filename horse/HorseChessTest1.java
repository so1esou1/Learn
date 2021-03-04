package com.csu.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/*
    马踏棋盘(骑士周游)问题的代码解决
 */
public class HorseChessTest1 {
    private static int X;       //棋盘的列数(记住不是行数)
    private static int Y;       //棋盘的行数
    //创建一个数组，标记棋盘的某个位置是否被访问过
    private static boolean visited[];
    //使用属性标记是否棋盘的所有位置都被访问过了
    private static boolean finished;        //如果为true表示成功，否则代表未全部访问，失败



    public static void main(String[] args) {
        System.out.println("骑士周游算法开始运行");
        //测试骑士周游算法是否正确:
        X = 8;
        Y = 8;
        int row = 1;
        int column = 1;          //马初始为止是1行1列
        //创建棋盘
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y];       //初始值都是false

        //顺便测试一下耗时
        long start = System.currentTimeMillis();

        //调用方法
        traversalChessboard(chessboard,row - 1,column - 1,1);           //记得减1
        long end = System.currentTimeMillis();
        System.out.println("共耗时:" + (end - start) + " 毫秒");             //共耗时:22814 毫秒

        //输出棋盘的最后情况
        for (int[] rows : chessboard){
            for (int step : rows){
                System.out.print(step + "\t");
            }
            System.out.println();
        }
/*
1	8	11	16	3	18	13	64
10	27	2	7	12	15	4	19
53	24	9	28	17	6	63	14
26	39	52	23	62	29	20	5
43	54	25	38	51	22	33	30
40	57	42	61	32	35	48	21
55	44	59	50	37	46	31	34
58	41	56	45	60	49	36	47
 */
        //棋盘过大的话，这样算法太慢了，可以使用贪心算法优化,得到的解将与原来的不一样


/*
    贪心算法的结果：
    共耗时:27 毫秒
1	16	37	32	3	18	47	22
38	31	2	17	48	21	4	19
15	36	49	54	33	64	23	46
30	39	60	35	50	53	20	5
61	14	55	52	63	34	45	24
40	29	62	59	56	51	6	9
13	58	27	42	11	8	25	44
28	41	12	57	26	43	10	7
 */
    }



    /**
     * 功能：根据当前的位置计算棋还能走哪些位置，并放到一个集合中(ArrayList)，最多有8个位置
     * point是java 自带的一个类
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint){
        //创建一个ArrayList
        ArrayList<Point> ps = new ArrayList<Point>();
        //创建一个point
        Point p1 = new Point();
        //需要使用if，不能是if else
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0){      //判断棋往左上角走(如图中的5)能否走通
            ps.add(new Point(p1));
        }
        //同理，同样的方法来判断是否可以走其他7个点
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0){      //往6走
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0){      //往7走
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0){      //往0走
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y){      //往1走
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y){      //往2走
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y){      //往3走
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y){      //往4走
            ps.add(new Point(p1));
        }
        return ps;
    }


    //根据当前一步的所有下一步的选择的位置进行非递减排序，减少回溯的次数(贪心算法):
    public static void sort(ArrayList<Point> ps){
        //重写ps的sort方法
        ps.sort(new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2) {
                //获取到o1点的下一步的所有位置的个数
                int count1 = next(o1).size();
                //获取到o2点的下一步的所有位置的个数
                int count2 = next(o2).size();
                if (count1 < count2){
                    return -1;
                }else if (count1 == count2){
                    return 0;
                }else {
                    return 1;
                }
            }
        });
    }



    /**
     *  完成马踏棋盘的核心算法
     * @param chessboard    棋盘
     * @param row           马当前位置的行，从0开始计数
     * @param column        马当前位置的列，从0开始计数
     * @param step          马走的是第几步,初始位置就是第1步
     */
    public static void traversalChessboard(int[][] chessboard,int row,int column,int step){
        chessboard[row][column] = step;
        visited[row * X + column] = true;       //把马的二维数组表示形式转成一维数组表示形式,并标记为已访问
        //获取当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next(new Point(column, row));//记得对应好行和列

        //在此处使用贪心算法:对ps进行排序，排序规则就是对ps的所有的Point对象的下一步的位置的数目进行非递减排序
        sort(ps);

        //遍历ps
        while (!ps.isEmpty()){
            Point p = ps.remove(0);     //取出下一个可以走的位置
            //判断该点是否已经访问过
            if (!visited[p.y * X + p.x]){
                //说明还没有访问过，ze:
                traversalChessboard(chessboard, p.y, p.x, step + 1);
            }
        }

        //判断马儿是否走完了所有棋盘:
        if (step < X * Y && !finished){
            chessboard[row][column] = 0;        //将整个棋盘置0
            visited[row * X + column] = false;
        }else {         //完成了周游:
            finished = true;
        }
        /*
        说明:step < X * Y,成立的情况有两种:
        1、棋盘到目前为止，仍然没有走完
        2、棋盘处于一个回溯过程
         */
    }
}
