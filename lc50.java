package com.csu.yitosanshi;

//力扣50 Pow(x, n)
public class lc50 {
    class Solution {
        public double myPow(double x, int n) {
            //这题与计算机底层有关:
            if (n == 0) return 1;
            if (n == -1) return 1 / x;
            if (n == 1) return x;
            return myPow(x * x, n / 2) * (n % 2 == 0 ? 1 : n > 1 ? x : 1 / x);

        }
    }
}
