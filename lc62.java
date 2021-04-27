package com.csu.wuyitoyibai;

//力扣62 不同路径
public class lc62 {
    class Solution {
        public int uniquePaths(int m, int n) {
            //动态规划算法:         也可以使用杨辉三角的方法
            int[][] dp = new int[m][n];

            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(i==0||j==0) {

                        dp[i][j]=1;


                    }else {
                        dp[i][j] = dp[i-1][j]+dp[i][j-1];
                    }
                }
            }
            return dp[m-1][n-1];
        }
    }
}
