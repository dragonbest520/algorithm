package com.db520.algorithm.leetcode;

/**
 * 111. Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * @author zhuyl
 * @version 2019-05-17
 */
public class MinimumDepthofBinaryTree {

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

        System.out.println(new MinimumDepthofBinaryTree().minDepth(t1));
    }

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int h1 = minDepth(root.left) + 1;
            int h2 = minDepth(root.right) + 1;
            if(h1 == 1 && h2 == 1) {
                return 1;
            } else if(h1 == 1){
                return h2;
            } else if(h2 == 1) {
                return h1;
            }
            return (h1 < h2) ? h1 : h2;
        }
    }
}
