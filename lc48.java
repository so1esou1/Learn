package com.csu.yitosanshi;
//力扣48 旋转图像
public class lc48 {
    class Solution {
        public void rotate(int[][] matrix) {
        /*第一行变换后变成了倒数第一列，而本行中元素的顺序没有改变。
            同样的，第二行变为倒数第二列，第三行变为倒数第三列
            公式:matrix[col][n-row-1] = matrix[row][col]
        */

            int n = matrix.length;
            int[][] newMatrix = new int[n][n];
            for(int i = 0;i < n;++i){
                for(int j = 0;j < n;++j){
                    newMatrix[j][n-i-1] = matrix[i][j];
                }
            }

            for(int i = 0;i < n;++ i){
                for(int j = 0;j < n;++j){
                    matrix[i][j] = newMatrix[i][j];
                }
            }

        }
    }
}
