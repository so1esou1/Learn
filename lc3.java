package com.csu.yitosanshi;

import java.util.HashSet;

//力扣第三题，无重复字符的最长子串
public class lc3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            int length = s.length();
            if(length <= 1){
                return length;
            }
            HashSet<Character> set = new HashSet<>();
            int max = 0;
            int i = 0;
            int j = 0;
            while(i < length &&j < length){
                if(!set.contains(s.charAt(j))){
                    max = Math.max(max,j-i+1);
                    set.add(s.charAt(j ++));
                }else{
                    set.remove(s.charAt(i ++));
                }
            }
            return max;
        }
    }
}
