package com.liao.leetcode;

//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1:
//
// 输入: [3,2,3]
//输出: 3
//
// 示例 2:
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
//
// Related Topics 位运算 数组 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution169 {
    public int majorityElement(int[] nums) {
        return handle(nums, 0, nums.length - 1);
    }

    private int countRange(int[] nums, int l, int r, int target) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }

    private int handle(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }

        int mid = (r - l) / 2 + l;
        int m = handle(nums, l, mid);
        int n = handle(nums, mid + 1, r);
        if (m == n) {
            return m;
        }

        int i = countRange(nums, l, r, m);
        int j = countRange(nums, l, r, n);
        return i > j ? m : n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)