package com.csu.yitosanshi;

import java.util.ArrayList;
import java.util.List;

//力扣20 有效的括号
public class lc20 {
    class Solution {
        public boolean isValid(String s) {
            boolean flag = true;
            List<String> list = new ArrayList<>();
            for(int i = 0;i < s.length();i ++){
                String temp = s.substring(i,i + 1);
                if(temp.equals("(") || temp.equals("[") || temp.equals("{")){
                    list.add(temp);
                }else if(temp.equals(")")){
                    if(list.size() > 0 && list.get(list.size() - 1).equals("(")){
                        list.remove(list.size() - 1);
                    }else{
                        flag = false;
                        break;
                    }
                }else if(temp.equals("]")){
                    if(list.size() > 0 && list.get(list.size() - 1).equals("[")){
                        list.remove(list.size() -1);
                    }else{
                        flag = false;
                        break;
                    }
                }else if(temp.equals("}")){
                    if(list.size() > 0 && list.get(list.size() - 1).equals("{")){
                        list.remove(list.size() -1);
                    }else{
                        flag = false;
                        break;
                    }
                }
            }
            if(flag && list.size() == 0){
                return true;

            }else{
                return false;
            }
        }
    }
}
