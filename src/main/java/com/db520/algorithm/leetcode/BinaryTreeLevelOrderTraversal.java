package com.db520.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * @author zhuyl
 * @version 2019-06-04
 */
public class BinaryTreeLevelOrderTraversal {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        TreeNode right1left2 = new TreeNode(15);
        TreeNode right1right2 = new TreeNode(7);
        root.left = left1;
        root.right = right1;
        right1.left = right1left2;
        right1.right = right1right2;

        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(root));
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
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
            list.add(levelList);
        }
        return list;
    }
}
