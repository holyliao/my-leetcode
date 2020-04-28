package com.liao.leetcode;

//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2.
// Related Topics 树 深度优先搜索 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Stack;

import javafx.util.Pair;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }

    public int minDepth2(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        if (root == null) {
            return 0;
        } else {
            stack.add(new Pair<>(root, 1));
        }
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            root = pair.getKey();
            int cur = pair.getValue();
            if (root.left == null && root.right == null) {
                min = Math.min(cur, min);
            }
            if (root.right != null) {
                stack.push(new Pair<>(root.right, cur + 1));
            }
            if (root.left != null) {
                stack.push(new Pair<>(root.left, cur + 1));
            }
        }
        return min;
    }

    public int minDepth3(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) {
            return 0;
        } else {
            stack.add(new Pair<>(root, 1));
        }
        int cur = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.poll();
            root = pair.getKey();
            cur = pair.getValue();
            if (root.left == null && root.right == null) {
                break;
            }
            if (root.right != null) {
                stack.add(new Pair<>(root.right, cur + 1));
            }
            if (root.left != null) {
                stack.add(new Pair<>(root.left, cur + 1));
            }
        }
        return cur;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

