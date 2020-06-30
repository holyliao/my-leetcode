package com.liao.leetcode;

//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  2   5
//     / \
//    5   7
//
//输出: 5
//说明: 最小的值是 2 ，第二小的值是 5 。
//
//
// 示例 2:
//
// 输入:
//    2
//   / \
//  2   2
//
//输出: -1
//说明: 最小的值是 2, 但是不存在第二小的值。
//
// Related Topics 树

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution671 {

    private static int second = -1;

    private static void findSecond(TreeNode node, int min) {
        if (node == null) {
            return;
        }
        if (node.val > min) {
            if (second == -1 || node.val < second) {
                second = node.val;
            }
        }
        findSecond(node.left, min);
        findSecond(node.right, min);
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }

        findSecond(root.left, root.val);
        findSecond(root.right, root.val);
        return second;
    }
}
//leetcode submit region end(Prohibit modification and deletion)