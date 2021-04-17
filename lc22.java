package com.csu.yitosanshi;

import java.util.ArrayList;
import java.util.List;

//力扣22 括号生成
public class lc22 {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> s = new ArrayList();
            String str = "";
            backtrack(s,"",0,0,n);

            return s;
        }
        public void backtrack(List<String> s,String str,int pre,int last,int max){
            if(str.length() == max * 2){
                s.add(str);
                return;
            }
            if(pre < max){
                backtrack(s,str+"(",pre + 1,last,max);
            }
            if(last < pre){
                backtrack(s,str+")",pre,last+1,max);
            }
        }
    }
}
