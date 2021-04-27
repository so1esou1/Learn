package com.csu.wuyitoyibai;

//力扣63 不同路径 II
public class lc63 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            //与上题相似，也使用动态规划的算法:
            int m=obstacleGrid.length;
            int n=obstacleGrid[0].length;
            if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1){

                return 0;
            }
            int dp[][] = new int[m + 1][n + 1];
            dp[0][1]=1;
            for(int i=1;i<=m;i++){

                for(int j=1;j<=n;j++){

                    if (obstacleGrid[i - 1][j - 1] == 0)
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m][n];
        }
    }
}
