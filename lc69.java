package com.csu.wuyitoyibai;

//力扣69  x 的平方根
public class lc69 {
    class Solution {
        public int mySqrt(int x) {
            long i,num = 0;
            for(i=0;i<=x;i++) {
                if(i*i <=x  && (i+1)*(i+1)>x) {
                    num = i;
                    break;
                }
            }
            return (int)num;
        }
    }
}
