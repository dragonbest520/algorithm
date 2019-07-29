package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * @Description BinaryTreePostorderTraversal
 * @Author zhuyl
 * @Date 2019/7/23 10:08
 **/
public class BinaryTreePostorderTraversal {

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
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t2.left = t3;

        System.out.println(new BinaryTreePostorderTraversal().postorderTraversal2(t1));
    }

    //dfs
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        dfs(root.left, list);
        dfs(root.right, list);
        list.add(root.val);
    }

    //iteratively
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                list.add(0, root.val);
                root = root.right;
            }
            if(!stack.isEmpty()) {
                root = stack.pop();
                root = root.left;
            }
        }
        return list;
    }
}
