package com.csu.yitosanshi;

import java.util.*;

//力扣49 字母异位词分组
public class lc49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            //这道题没想出合适的思路

            //使用HashMap接收,ArrayList是add方法,HashMap是put方法，获取所有值是values方法，通过key获取值是get方法
            if(strs.length == 0 || strs == null) return new ArrayList();
            Map<String, ArrayList> ans = new HashMap<String, ArrayList>();
            for(String s : strs){
                char[] c = s.toCharArray();
                Arrays.sort(c);
                String key = String.valueOf(c);//将char数组转换为字符串，作为一个键
                if(!ans.containsKey(key)){
                    ans.put(key, new ArrayList());
                }
                ans.get(key).add(s);//ans.get(key)为ArrayList类型
            }
            return new ArrayList(ans.values());//HashMap.values()返回所有的值

        }
    }
}
