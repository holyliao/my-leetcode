package com.liao.leetcode;

//给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
// Related Topics 树 深度优先搜索
// 👍 291 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        constructPath(root, "", paths);
        return paths;
    }

    private void constructPath(TreeNode node, String path, List<String> paths) {
        if (node != null) {
            path += Integer.toString(node.val);
            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                path += "->";
                constructPath(node.left, path, paths);
                constructPath(node.right, path, paths);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

