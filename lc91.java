package com.csu.wuyitoyibai;

//力扣91 解码方法
public class lc91 {
    class Solution {
        public int numDecodings(String s) {
            //方式一、递归:超时了
            /*return getAns(s, 0);*/

            //方式二、动态规划:
            //递归就是压栈压栈压栈，出栈出栈出栈的过程，我们可以利用动态规划的思想，省略压栈的过程，直接从 bottom 到 top。
            int len = s.length();
            int[] dp = new int[len + 1];
            dp[len] = 1; //将递归法的结束条件初始化为 1
            //最后一个数字不等于 0 就初始化为 1
            if (s.charAt(len - 1) != '0') {
                dp[len - 1] = 1;
            }
            for (int i = len - 2; i >= 0; i--) {
                //当前数字时 0 ，直接跳过，0 不代表任何字母
                if (s.charAt(i) == '0') {
                    continue;
                }
                int ans1 = dp[i + 1];
                //判断两个字母组成的数字是否小于等于 26
                int ans2 = 0;
                int ten = (s.charAt(i) - '0') * 10;
                int one = s.charAt(i + 1) - '0';
                if (ten + one <= 26) {
                    ans2 = dp[i + 2];
                }
                dp[i] = ans1 + ans2;

            }
            return dp[0];
        }

    /*
    private int getAns(String s, int start) {
        //划分到了最后返回 1
        if (start == s.length()) {
            return 1;
        }
        //开头是 0,0 不对应任何字母，直接返回 0
        if (s.charAt(start) == '0') {
            return 0;
        }
        //得到第一种的划分的解码方式
        int ans1 = getAns(s, start + 1);
        int ans2 = 0;
        //判断前两个数字是不是小于等于 26 的
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
                ans2 = getAns(s, start + 2);
            }
        }
        return ans1 + ans2;
    }
    */
    }
}
