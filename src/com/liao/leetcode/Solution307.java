package com.liao.leetcode;

//给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。
//
// update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
//
// 示例:
//
// Given nums = [1, 3, 5]
//
//sumRange(0, 2) -> 9
//update(1, 2)
//sumRange(0, 2) -> 8
//
//
// 说明:
//
//
// 数组仅可以在 update 函数下进行修改。
// 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
//
// Related Topics 树状数组 线段树
// 👍 147 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {

    int[] tree;
    int n;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            this.n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }

    private void buildTree(int[] nums) {
        for (int i = this.n, j = 0; i < 2 * this.n; i++, j++) {
            tree[i] = nums[j];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public void update(int pos, int val) {
        pos += this.n;
        tree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }

    public int sumRange(int l, int r) {
        l += n;
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
                sum += tree[l];
                l++;
            }
            if ((r % 2) == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj = new NumArray(nums); obj.update(i,val); int param_2 =
 * obj.sumRange(i,j);
 */
//leetcode submit region end(Prohibit modification and deletion)
