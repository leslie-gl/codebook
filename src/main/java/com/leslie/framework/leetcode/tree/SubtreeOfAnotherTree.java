package com.leslie.framework.leetcode.tree;

/**
 * 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 t 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * @author leslie
 * @date 2021/2/19
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return isSameNode(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameNode(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return isSameNode(s.left, t.left) && isSameNode(s.right, t.right);
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
