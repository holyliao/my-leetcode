package com.liao.leetcode;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int t = 0;
        int[] cp = Arrays.copyOf(nums1, nums1.length);
        while (i < m && j < n) {
            nums1[t++] = cp[i] <= nums2[j] ? cp[i++] : nums2[j++];
        }

        if (i < m) {
            System.arraycopy(cp, i, nums1, i + j, m + n - i - j);
        } else if (j < n) {
            System.arraycopy(nums2, j, nums1, i + j, m + n - j - i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

