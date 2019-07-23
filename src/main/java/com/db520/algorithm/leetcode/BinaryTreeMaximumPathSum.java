package com.db520.algorithm.leetcode;

/**
 * 124. Binary Tree Maximum Path Sum
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * @Description BinaryTreeMaximumPathSum
 * @Author zhuyl
 * @Date 2019/7/16 9:48
 **/
public class BinaryTreeMaximumPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(-10);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(n1));
    }

    //二叉树的算法大多可以选择递归来解决
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        maxSum(root);
        return max;
    }

    //递归函数
    int maxSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int curVal = root.val;
        int lMaxSum = maxSum(root.left);
        int rMaxSum = maxSum(root.right);
        if(lMaxSum > 0) {
            curVal += lMaxSum;
        }
        if(rMaxSum > 0) {
            curVal += rMaxSum;
        }
        if(curVal > max) {
            max = curVal;
        }
        return Math.max(root.val, Math.max(root.val + lMaxSum, root.val + rMaxSum));
    }
}
