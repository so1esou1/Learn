package com.csu.wuyitoyibai;

//力扣74 搜索二维矩阵
public class lc74 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            //把矩阵变成一行的数组，然后使用二分法查找:
            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            int col = matrix[0].length;
            // 将二维数组拉成一维数组，利用二分法解决
            int left = 0;
            int right = matrix.length * col - 1;
            while (left <= right) {
                // 计算中间数的下标和值
                int middleIndex = (left + right) / 2;
                int middleVal = matrix[middleIndex / col][middleIndex % col];
                if (middleVal == target) {
                    return true;
                }

                if (middleVal < target) {
                    left = middleIndex + 1;
                } else {
                    right = middleIndex - 1;
                }
            }

            return false;
        }
    }
}
