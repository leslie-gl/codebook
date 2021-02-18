package com.leslie.framework.leetcode.tree;

import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 110. 平衡二叉树[EASY]
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 *
 * @author leslie
 * @date 2021/2/18
 */
public class BalancedBinaryTree {

    Map<TreeNode, Integer> cache = new HashMap<>(16);

    /**
     * 自顶向下
     * <p>
     * 对于节点 p，如果它的深度是 d，则 maxDepth(p)最多会被调用 d 次（即遍历到它的每一个祖先节点时）
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isBalanced4Root = Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
        return isBalanced4Root && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Integer depth = cache.get(root);
        if (depth == null) {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            depth = Math.max(leftDepth, rightDepth) + 1;
            cache.put(root, depth);
        }
        return depth;
    }

    /**
     * 自底向上
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return height(root) > 0;
    }

    /**
     * if result is -1,not balanced
     */
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = height(root.left);
        int rightDepth = height(root.right);
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    @EqualsAndHashCode
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