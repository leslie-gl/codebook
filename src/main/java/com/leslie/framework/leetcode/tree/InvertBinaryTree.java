package com.leslie.framework.leetcode.tree;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * @author leslie
 * @date 2021/2/18
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTreeNode = invertTree(root.right);
        return new TreeNode(root.val, rightTreeNode, leftTree);
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
