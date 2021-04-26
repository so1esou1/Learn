package com.csu.wuyitoyibai;

import java.util.Arrays;

//力扣56 合并区间
public class lc56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            //可以使用排序的方式，这里并不是
            int[] start = new int[intervals.length];
            int[] end = new int[intervals.length];
            for(int i=0;i<intervals.length;i++){
                start[i] = intervals[i][0];
                end[i] = intervals[i][1];
            }
            Arrays.sort(start);
            Arrays.sort(end);
            int[][] res = new int[intervals.length][2];
            int count=0;
            int ps=0;
            int pe=1;
            while(pe<end.length){
                while(start[pe]<=end[pe-1]){
                    pe++;
                    if(pe>=end.length) break;
                }
                res[count][0]=start[ps];
                res[count][1]=end[pe-1];
                count++;
                ps=pe;
                pe++;
            }
            if(pe == end.length){
                res[count][0]=start[ps];
                res[count][1]=end[pe-1];
                count++;
            }
            int[][] result = new int[count][2];
            for(int i =0;i<count;i++){
                result[i][0] = res[i][0];
                result[i][1] = res[i][1];
            }
            return result;

        }

    }
}
