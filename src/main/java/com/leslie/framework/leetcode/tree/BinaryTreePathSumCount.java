package com.leslie.framework.leetcode.tree;

/**
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * @author leslie
 * @date 2021/2/19
 */
public class BinaryTreePathSumCount {
    
    public int pathSum(TreeNode root, int sum) {
        int count = 0;
        if (root == null) {
            return count;
        }
        count += countPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return count;
    }

    public int countPathSum(TreeNode root, int sum) {
        int count = 0;
        if (root == null) {
            return count;
        }
        if (root.val == sum) {
            count++;
        }
        int leftCount = countPathSum(root.left, sum - root.val);
        int rightCount = countPathSum(root.right, sum - root.val);
        count += leftCount + rightCount;
        return count;
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
