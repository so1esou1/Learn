package com.csu.wuyitoyibai;

//力扣70 爬楼梯
public class lc70 {
    class Solution {
        public int climbStairs(int n) {
            //递归的方式,不行，超出时间限制了
            //return climb_Stairs(0,n);

            //使用动态规划的方式:
            if (n == 1) {
                return 1;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];

        }
    /*public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }*/
    }
}
