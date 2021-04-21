package com.csu.yitosanshi;

//力扣42 接雨水
public class lc42 {
    class Solution {
        public int trap(int[] height) {
            //积满雨水的图形一定是先递增再递减的图形（递增或者递减过程也可以不存在）
            if(height==null||height.length<3) return 0;
            int peak = 0;
            int rock = 0;
            int rain = 0;
            for(int i = 1;i<height.length;i++){
                if(height[i]>=height[peak]){
                    rain+=height[peak]*(i-peak-1)-rock;
                    rock = 0;
                    peak = i;
                }
                else rock+=height[i];
            }
            rock = 0;
            int peak2 = height.length-1;
            for(int i = height.length-2;i>=peak;i--){
                if(height[i]>=height[peak2]){
                    rain+=height[peak2]*(peak2-i-1)-rock;
                    rock = 0;
                    peak2 = i;
                }
                else{
                    rock+=height[i];
                }
            }
            return rain;

        }
    }
}
