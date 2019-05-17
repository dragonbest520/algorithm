package com.db520.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 112. Path Sum
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * Note: A leaf is a node with no children.
 * @author zhuyl
 * @version 2019-05-17
 */
public class PathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t21 = new TreeNode(4);
        TreeNode t22 = new TreeNode(8);
        TreeNode t31 = new TreeNode(11);
        TreeNode t33 = new TreeNode(13);
        TreeNode t34 = new TreeNode(4);
        TreeNode t41 = new TreeNode(7);
        TreeNode t42 = new TreeNode(2);
        TreeNode t46 = new TreeNode(1);
        t1.left = t21;
        t1.right = t22;
        t21.left = t31;
        t22.left = t33;
        t22.right = t34;
        t31.left = t41;
        t31.right = t42;
        t34.right = t46;

        System.out.println(new PathSum().hasPathSum(t1, 22));
    }


    public boolean hasPathSum(TreeNode root, int sum) {

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) {
            return false;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                if(queue.peek().left != null) {
                    queue.peek().left.val += queue.getFirst().val;
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null) {
                    queue.peek().right.val += queue.getFirst().val;
                    queue.offer(queue.peek().right);
                }
                if(queue.peek().left == null && queue.peek().right == null) {
                    if(queue.getFirst().val == sum) {
                        return true;
                    }
                }
                queue.poll();
            }
        }
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null & root.right == null & sum == root.val) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }

}
