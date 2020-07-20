package com.liao.leetcode;

//给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
//区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
//
// 说明:
//最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
//
// 示例:
//
// 输入: nums = [-2,5,-1], lower = -2, upper = 2,
//输出: 3
//解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
//
// Related Topics 排序 树状数组 线段树 二分查找 分治算法
// 👍 103 👎 0


import java.util.Arrays;
import java.util.TreeMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution327 {

    public static void main(String[] args) {
        Solution327 temp = new Solution327();
        int sum = temp.countRangeSum(new int[]{-2147483647, 0, -2147483647, 2147483647}, -564, 3864);
        System.out.println(sum);
        int sum2 = temp.countRangeSum2(new int[]{-2147483647, 0, -2147483647, 2147483647}, -564, 3864);
        System.out.println(sum2);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        // 构造前缀和
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        System.out.println(Arrays.toString(sum));

        int ans = 0;
        // 穷举所有子数组
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                // sum of nums[j..i-1]
                int k = sum[i] - upper;
                int r = sum[i] - lower;
                if (sum[j] >= k && sum[j] <= r) {
                    System.out.println("------------------");
                    System.out.println(i + ", " + j + ", " + k);
                    System.out.println(sum[i] + ", " + sum[j]);
                    ans++;
                }
            }
        }

        return ans;
    }

    public int countRangeSum2(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //键值为区间和和这个区间和出现的次数
        TreeMap<Long, Integer> tree = new TreeMap<>();
        tree.put(0L, 1);

        int count = 0;
        long sum = 0L;
        for (int num : nums) {
            sum += num;
            //subMap()返回一个值在sum - upper 和sum - lower 之间的子集合，values()方法获得这个映射的值得视图
            for (int cnt : tree.subMap(sum - upper, true, sum - lower, true).values()) {
                count += cnt; //统计满足条件的区间和个数
            }
            tree.put(sum, tree.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
