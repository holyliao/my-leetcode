package com.liao.leetcode;

//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution106 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        return maxDepth2(root.left, 1, root.right, 1, 1);
    }

    private int maxDepth2(TreeNode left, Integer ld, TreeNode right, Integer rd, Integer max) {
        if (left != null) {
            ld++;
        }
        if (right != null) {
            rd++;
        }
        int temp = Math.max(ld, rd);
        max = Math.max(temp, max);
        int m1 = max;
        int m2 = max;
        if (left != null) {
            m1 = maxDepth2(left.left, ld, left.right, ld, max);
        }
        if (right != null) {
            m2 = maxDepth2(right.left, rd, right.right, rd, max);
        }
        return Math.max(m1, m2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
