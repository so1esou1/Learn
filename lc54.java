package com.csu.wuyitoyibai;

import java.util.ArrayList;
import java.util.List;

//力扣54 螺旋矩阵
public class lc54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> nums = new ArrayList<Integer>();
            if(matrix.length == 0 || matrix[0].length == 0){
                return nums;
            }
            while(true){
                int i = 0, j = 0;
                int m = matrix.length, n = matrix[0].length;
                while(i < m && j < n && matrix[i][j] == -99){
                    i++;
                    j++;
                    m--;
                    n--;
                }
                if(i >= m || j >= n){
                    break;
                }
                for(int l = j; l < n; l++){//从左到右
                    if(matrix[i][l] != -99){
                        nums.add(matrix[i][l]);
                        matrix[i][l] = -99;

                    }
                }
                for(int l = i + 1; l < m; l++){//从上到下
                    if(matrix[l][n - 1] != -99){
                        nums.add(matrix[l][n - 1]);
                        matrix[l][n - 1] = -99;
                    }
                }
                for(int l = n - 2; l >= j; l--){//从右到左
                    if(matrix[m - 1][l] != -99){
                        nums.add(matrix[m - 1][l]);
                        matrix[m - 1][l] = -99;
                    }
                }
                for(int l = m - 2; l >= i + 1; l--){//从下到上
                    if(matrix[l][j] != -99){
                        nums.add(matrix[l][j]);
                        matrix[l][j] = -99;
                    }
                }
            }
            return nums;
        }

    }
}
