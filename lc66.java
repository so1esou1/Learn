package com.csu.wuyitoyibai;

import java.util.Arrays;

//力扣66 加一
public class lc66 {
    class Solution {
        public int[] plusOne(int[] digits) {
            //需要先有一个判断:遇到当前位数为9的时候会产生进位，遇到非9直接结束判断
            int[] ans = new int[digits.length + 1];
            boolean flag = false;

            for (int i = digits.length - 1; i >= 0; i--) {
                if (i == 0 && digits[i] == 9) flag = true;
                digits[i] += 1;
                if (digits[i] < 10) break;
                digits[i] -= 10;
            }

            if (flag) {
                ans[0] = 1;
                int cnt = 1;
                for (int e : digits) {
                    ans[cnt++] = e;
                }
            } else {
                ans = digits;
            }

            return Arrays.copyOfRange(ans, ans[0] == 0 && ans.length != 1 ? 1 : 0, ans.length);
        }
    }
}
