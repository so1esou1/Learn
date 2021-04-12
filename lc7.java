package com.csu.yitosanshi;

//力扣第7题，整数反转
public class lc7 {
    class Solution {
        public int reverse(int x) {
            long a = 0;
            while(x != 0){
                a = a * 10 + x % 10;
                x = x / 10;
            }
            return (int)a == a ? (int)a : 0;
        }
    }
}
