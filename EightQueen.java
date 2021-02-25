package com.csu.recursion;
/*
    递归解决八皇后问题:

    问题描述:在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，
      即：任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法？

    思路：1、第一个皇后先放第一行第一列
          2、第二个皇后放在第二行第一列、然后判断是否OK， 如果不OK，继续放在第二列、第三列、依次把所有列都放完，找到一个合适
          3、继续第三个皇后，还是第一列、第二列……直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解
          4、当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，全部得到.
          5、然后回头继续第一个皇后放第二列，后面继续循环执行 1,2,3,4的步骤

 */
public class EightQueen {
    //先定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组，保存皇后放置位置的结果
    int[] array = new int[max];
    static int count = 0;       //用来统计解法数量
    static int circle = 0;      //用来统计回溯次数

    public static void main(String[] args) {
        //测试
        EightQueen eightQueen = new EightQueen();
        eightQueen.check(0);        //从0开始放
        System.out.println("一共有" + count + "种解法");          //92
        System.out.println("一共有" + circle + "次回溯");         //15720次，回溯效率比较慢
    }



    //(3)编写一个方法，放置第n+1个皇后
    //特别注意:check时每一次递归时进入到check方法中都有for循环,因此会有回溯
    private void check(int n){
        if (n == max){      //n = 8时，其实是放置第9个皇后，8个皇后已经放好了
            printQueen();
            return;
        }
        //依次放入皇后并判断是否冲突
        for (int i = 0;i < max;i ++){
            //先把当前这个皇后n放到该行的第1列进行判断
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)){      //不冲突时，接着放n+1个皇后,即开始递归
                check(n + 1);
            }
            //如果冲突，就继续执行array[n] = i;即将第n个皇后放置在本行的后移的一个位置(i++),所以不用写任何东西，直接进行循环
        }
    }


    /**
     * (2)写一个方法，当我们放置第n+1个皇后的时候，就去检测该皇后是否和前面已经摆放的皇后冲突
     * @param n 表示第n+1个皇后
     * @return
     */
    private boolean judge(int n){
        circle ++;      //调一次，冲突一次就加一次
        for (int i = 0;i < n;i ++){
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){      //说明两个皇后在同一列或一条斜线上(这个算法比较的是斜率?斜率为1)
                return false;
            }
            //没有必要判断是否在同一行，n每次都在递增
        }
        return true;
    }


    //(1)写一个方法，将皇后摆放的位置打印出来
    private void printQueen(){
        count++;        //打印几次就说明有几个解法
        for (int i = 0;i < array.length;i ++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
