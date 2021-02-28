package com.leslie.framework.leetcode.tree;

/**
 * 687. 最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * @author leslie
 * @date 2021/2/28
 */
public class LongestSameValuedPath {

    private int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        longestPath(root);
        return res;
    }

    public int longestPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTreePath = longestPath(root.left);
        int rightTreePath = longestPath(root.right);
        int longestPathByLeft = root.left != null && root.val == root.left.val ? leftTreePath + 1 : 0;
        int longestPathByRight = root.right != null && root.val == root.right.val ? rightTreePath + 1 : 0;
        res = Math.max(res, longestPathByLeft + longestPathByRight);
        return Math.max(longestPathByLeft, longestPathByRight);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
