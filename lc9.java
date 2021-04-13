package com.csu.yitosanshi;

//力扣题9，回文数
public class lc9 {
    class Solution {
        public boolean isPalindrome(int x) {
            int temp = x;
            int res = 0;
            if(x < 0){
                return false;
            }else{
                while(temp != 0){
                    res = res * 10 + temp % 10;
                    temp /= 10;
                }
            }

            if(x == res){
                return true;
            }else{
                return false;
            }
        }
    }
}
