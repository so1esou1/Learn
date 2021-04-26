package com.csu.wuyitoyibai;

import java.util.ArrayList;
import java.util.List;

//力扣57 插入区间
public class lc57 {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int left = newInterval[0];
            int right = newInterval[1];
            List<int []> resultList = new ArrayList<int []>();
            boolean addNewValue = false;
            for(int [] layer : intervals){
                //说明该层最大的值还要小于left值
                if(layer[1] < left){
                    resultList.add(layer);
                } else if(layer[0] > right){
                    //若是该层的最小值大于right
                    //那么首先要把left和right放入到list中
                    if(!addNewValue){
                        resultList.add(new int[]{left,right});
                        addNewValue = true;
                    }
                    //再把当前层放入list
                    resultList.add(layer);
                } else {
                    //比较left，right得到本层的最大值，最小值，再继续跟下一层对比
                    left = Math.min(layer[0],left);
                    right = Math.max(layer[1],right);
                }
            }
            //如果还没有把left和right放入到list中
            if(!addNewValue){
                resultList.add(new int[]{left,right});
            }
            int result[][] = new int [resultList.size()][2];
            for(int i = 0 ; i < resultList.size() ; i++){
                result[i][0] = resultList.get(i)[0];
                result[i][1] = resultList.get(i)[1];
            }
            return result;
        }
    }
}
