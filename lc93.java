package com.csu.wuyitoyibai;

import java.util.ArrayList;
import java.util.List;

//力扣93 还原IP地址
public class lc93 {
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            //可以使用递归法



            //也可以使用回溯方法:
            //需要划分为 4 部分，所以我们直接用利用三个指针将字符串强行分为四部分，遍历所有的划分，然后选取合法的解。
            List<String> res = new ArrayList<String>();
            int len = s.length();
            //i < 4 保证第一部分不超过 3 位数
            //i < len - 2 保证剩余的字符串还能分成 3 部分
            for(int i = 1; i<4 && i<len-2; i++){
                for(int j = i+1; j<i+4 && j<len-1; j++){
                    for(int k = j+1; k<j+4 && k<len; k++){
                        //保存四部分的字符串
                        String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                        //判断是否合法
                        if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                            res.add(s1+"."+s2+"."+s3+"."+s4);
                        }
                    }
                }
            }
            return res;
        }

        public boolean isValid(String s){
            if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
                return false;
            return true;
        }
    }
}
