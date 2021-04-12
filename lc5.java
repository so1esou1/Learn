package com.csu.yitosanshi;

//力扣第五题，最长回文子串
public class lc5 {
    class Solution {
        public String longestPalindrome(String s) {
            int length = s.length();
            if(length <= 1){
                return s;
            }
            int relen = 1;
            String res = s.substring(0,1);

            for(int i = 0;i < length - 1;i ++){
                for(int j = i + 1;j < length;j ++){
                    if(j - i + 1 > relen && suit(s,i,j)){
                        relen = j - i + 1;
                        res = s.substring(i,j + 1);
                    }
                }
            }
            return res;
        }

        boolean suit(String s,int i,int j){
            while(i < j){
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }
                i ++;
                j --;
            }
            return true;
        }
    }
}
