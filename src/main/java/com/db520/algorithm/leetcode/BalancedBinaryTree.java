package com.db520.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * @author zhuyl
 * @version 2019-05-17
 */
public class BalancedBinaryTree {

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
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(2);
        TreeNode t31 = new TreeNode(3);
        TreeNode t32 = new TreeNode(3);
        TreeNode t33 = new TreeNode(3);
        TreeNode t34 = new TreeNode(3);
        TreeNode t41 = new TreeNode(4);
        TreeNode t42 = new TreeNode(4);
        TreeNode t43 = new TreeNode(4);
        TreeNode t44 = new TreeNode(4);
        TreeNode t45 = new TreeNode(4);
        TreeNode t46 = new TreeNode(4);
        TreeNode t51 = new TreeNode(5);
        TreeNode t52 = new TreeNode(5);
        t1.left = t21;
        t1.right = t22;
        t21.left = t31;
        t21.right = t32;
        t22.left = t33;
        t22.right = t34;
        t31.left = t41;
        t31.right = t42;
        t32.left = t43;
        t32.right = t44;
        t33.left = t45;
        t33.right = t46;
        t41.left = t51;
        t41.right = t52;

        System.out.println(new BalancedBinaryTree().isBalanced(t1));

    }


    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        int h1 = dfs(root.left);
        int h2 = dfs(root.right);
        if (h1 - h2 > 1 || h1 - h2 < -1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        else {
            int h1 = dfs(root.left) + 1;
            int h2 = dfs(root.right) + 1;
            return (h1 > h2) ? h1 : h2;
        }
    }
}
