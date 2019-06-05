package com.db520.algorithm.leetcode;

/**
 * 129. Sum Root to Leaf Numbers
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * @author zhuyl
 * @version 2019-06-05
 */
public class SumRoottoLeafNumbers {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        /*TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;*/
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(1);
        t1.left = t2;

        System.out.println(new SumRoottoLeafNumbers().sumNumbers(t1));
    }


    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int num) {
        if(root == null) {
            return 0;
        }
        num = root.val + 10 * num;
        if(root.left == null && root.right == null) {
            return num;
        }
        return dfs(root.left,  num) + dfs(root.right,  num);
    }

}
