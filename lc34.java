package com.csu.yitosanshi;

//力扣34 在排序数组中查找元素的第一个和最后一个位置
public class lc34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int ret[] = {-1, -1};
            int startIndex = searchIndex(nums, target, 0, nums.length - 1, true);
            if (startIndex == -1) return ret;
            ret[0] = startIndex;
            int endIndex = searchIndex(nums, target, startIndex, nums.length - 1, false);
            ret[1] = endIndex;
            return ret;
        }

        private int searchIndex(int[] nums, int target, int start, int end, boolean left) {
            int index = -1;
            while (start <= end) {
                int mid = (start + end) >> 1;
                if (nums[mid] == target) {
                    index = mid;
                    if (left) end = mid - 1;
                    else start = mid + 1;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return index;
        }
    }
}
