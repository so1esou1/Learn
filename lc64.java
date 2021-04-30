package com.csu.wuyitoyibai;

//力扣64 最小路径和
public class lc64 {
    class Solution {
        public int minPathSum(int[][] grid) {
            //使用动态规划:
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int rows = grid.length, columns = grid[0].length;
            int[][] dp = new int[rows][columns];//状态定义
            dp[0][0] = grid[0][0];//初始状态
            for (int i = 1; i < rows; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];//转移方程，加的是grid[i][0]
            }//注意：这里求的是最小路径和
            for (int j = 1; j < columns; j++) {
                dp[0][j] = dp[0][j - 1] + grid[0][j];//转移方程
            }
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < columns; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];//转移方程
                }
            }
            return dp[rows - 1][columns - 1];

        }
    }
}
