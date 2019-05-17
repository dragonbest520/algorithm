package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. Binary Tree Level Order Traversal II
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * @author zhuyl
 * @version 2019-05-17
 */
public class BinaryTreeLevelOrderTraversal2 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t21 = new TreeNode(9);
        TreeNode t22 = new TreeNode(20);
        TreeNode t33 = new TreeNode(15);
        TreeNode t34 = new TreeNode(7);
        t1.left = t21;
        t1.right = t22;
        t22.left = t33;
        t22.right = t34;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) {
            return list;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                if(queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                levelList.add(queue.poll().val);
            }
            list.add(0, levelList);
        }
        return list;
    }
}
