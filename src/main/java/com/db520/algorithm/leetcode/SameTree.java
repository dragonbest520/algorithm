package com.db520.algorithm.leetcode;

/**
 * 100. Same Tree
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * @author zhuyl
 * @version 2019-05-16
 */
public class SameTree {

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
        System.out.println(new SameTree().isSameTree(t1, t2));
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null) {
            return false;
        }
        if(p != null && q == null) {
            return false;
        }
        if(p == null && q == null) {
            return true;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
