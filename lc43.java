package com.csu.yitosanshi;

//力扣43 字符串相乘
public class lc43 {
    class Solution {
        public String multiply(String num1, String num2) {
            if(num1.equals("0") || num2.equals("0")) return "0";
            int len = num1.length()+num2.length(),flag = 0;
            int[] data = new int[len];
            StringBuilder res = new StringBuilder();
            for (int i = num1.length()-1; i >=0 ; i--) {
                for (int j = num2.length()-1; j >=0 ; j--) {
                    data[i+j+1] += (num1.charAt(i) -'0')*(num2.charAt(j)-'0');
                    if(data[i+j+1]>=10){
                        int tmp = data[i+j+1];
                        data[i+j+1] = tmp%10; //余数放在该放的位置上
                        data[i+j] += tmp/10; //进位
                    }
                }

            }

            int k = 0;
            for (; k < len; k++) {
                if (data[k] != 0) break;
            }
            //反转
            while(k<len) res.append(data[k++]);
            return res.toString();
        }
    }
}
