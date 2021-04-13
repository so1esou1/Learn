package com.csu.yitosanshi;

//力扣11，盛最多水的容器
public class lc11 {
    class Solution {
        public int maxArea(int[] height) {
            if(height.length == 0){
                return 0;
            }
            int r = height.length - 1;
            int l = 0;
            int res = 0;
            while(l < r){
                int area = Math.min(height[l],height[r]) * (r - l);
                res = Math.max(area,res);
                if(height[l] <= height[r]){
                    l ++;
                }else{
                    r --;
                }
            }
            return res;
        }
    }
}
