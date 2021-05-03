package com.csu.wuyitoyibai;

import java.util.ArrayList;
import java.util.List;

//力扣78 子集
public class lc78 {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            //1、枚举法，我能想到的办法:
            // 枚举每个元素，把这个元素添加到现有的所有集合，然后把这个新集合加入list中
          /*ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
          list.add(new ArrayList());  // 添加一个空集合
          for(int i = 0; i < nums.length; i++){
              int size = list.size();
              for(int j = 0; j < size; j++){
                  List<Integer> sub = new ArrayList<>(list.get(j));
                 sub.add(nums[i]);
                 list.add(sub);
             }
         }
        return list;*/


            //2、二进制位运算，需要去学习二进制和位运算了:
            // 利用位数为数组长度的二进制数，这个二进制数所能表示的元素个数刚好等于这个幂集的子集的个数
            // 且二进制数的每个数代表了一种子集的选择情况，数位为1则表示选该数，数位0则表示不选该数
            ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
            for(int i = 0; i < (1 << nums.length); i++){
                List<Integer> sub = new ArrayList<Integer>();
                for(int j = 0; j < nums.length; j++){
                    if(((i >> j) & 1) == 1)
                        sub.add(nums[j]);
                }
                list.add(sub);
            }
            return list;
        }
    }
}
