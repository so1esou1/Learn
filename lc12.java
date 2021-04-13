package com.csu.yitosanshi;

//力扣12，整数转罗马数字
public class lc12 {
    class Solution {
        public String intToRoman(int num) {
            StringBuffer ans = new StringBuffer();
            int[] v = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
            String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
            for(int i = 0;i < v.length;i ++){
                while(num >= v[i]){
                    ans.append(romans[i]);
                    num -= v[i];
                }
            }
            return ans.toString();
        }
    }
}
