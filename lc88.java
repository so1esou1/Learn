package com.csu.wuyitoyibai;

//力扣88 合并两个有序数组
public class lc88 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //直接归并算法即可
            for (int count = 1; count <= m; count++) {
                nums1[m + n - count] = nums1[m - count];
            }
            int i = n; //i 从 n 开始
            int j = 0;
            int k = 0;
            //遍历 nums2
            while (j < n) {
                //如果 nums1 遍历结束，将 nums2 直接加入
                if (i == m + n) {
                    while (j < n) {
                        nums1[k++] = nums2[j++];
                    }
                    return;
                }
                //哪个数小就对应的添加哪个数
                if (nums2[j] < nums1[i]) {
                    nums1[k] = nums2[j++];
                } else {
                    nums1[k] = nums1[i++];
                }
                k++;
            }
        }
    }
}
