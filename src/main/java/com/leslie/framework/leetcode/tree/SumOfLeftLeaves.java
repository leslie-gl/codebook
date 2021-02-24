package com.leslie.framework.leetcode.tree;

/**
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * @author leslie
 * @date 2021/2/24
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeave(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public boolean isLeave(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
