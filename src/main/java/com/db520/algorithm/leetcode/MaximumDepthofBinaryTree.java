package com.db520.algorithm.leetcode;

/**
 * 104. Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * @author zhuyl
 * @version 2019-05-16
 */
public class MaximumDepthofBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t11 = new TreeNode(2);
        TreeNode t12 = new TreeNode(3);
        t1.left = t11;
        t1.right = t12;
        TreeNode t2 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(3);
        t2.left = t21;
        t2.right = t22;
        System.out.println(new MaximumDepthofBinaryTree().maxDepth(t1));

    }
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
