package com.csu.yitosanshi;

//力扣45 跳跃游戏II
public class lc45 {
    class Solution {
        public int jump(int[] nums) {
            //使用贪心算法，尽可能保证每次跳跃最远
            if(nums.length == 1) return 0;
            int reach = 0;
            int nextreach = nums[0];
            int step = 0;
            for(int i = 0;i<nums.length;i++){
                nextreach = Math.max(i+nums[i],nextreach);
                if(nextreach >= nums.length-1) return (step+1);
                if(i == reach){
                    step++;
                    reach = nextreach;
                }
                if(nextreach >= nums.length-1) return step;//这里的判断可以去掉，去掉更好，因为上面判断中的内容并不是总执行，也就是判断中的step++不是每次都执行，所以这个判断加在上面更好！！
            }
            return step;

        }
    }
}
