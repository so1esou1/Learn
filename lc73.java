package com.csu.wuyitoyibai;

import java.util.HashSet;
import java.util.Set;

//力扣73 矩阵置零
public class lc73 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            //先扫描一遍矩阵, 将遇到的0与之所在的行和列的所有数设置为一个flag数
            //不使用flag然后直接将所有0在的行和列设置为0的话, 最后结果总是整个矩阵都是0

        /*int m = matrix.length;
        int n = matrix[0].length;
        int flag = -10; // 第一轮扫描该被置零的位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = flag; // 该位先置为flag
                    // 所在行
                    for (int k = 0; k < n; k++) {
                        // 不能直接把同行同列的0的设置为flag, 否则会忽略掉一部分0
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = flag;
                        }
                    }
                    // 所在列
                    for (int k = 0; k < m; k++) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = flag;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == flag) {
                    matrix[i][j] = 0;
                }
            }
        }*/


            //使用hashMap的方式，但是执行速度变慢了
            int rows = matrix.length;
            int columns = matrix[0].length;
            Set<Integer> R = new HashSet<Integer>();//无序不可重复
            Set<Integer> C = new HashSet<Integer>();

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if(matrix[i][j] == 0){
                        R.add(i);
                        C.add(j);
                    }
                }
            }

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if(R.contains(i) || C.contains(j)){
                        matrix[i][j] = 0;
                    }
                }
            }

        }
    }
}
