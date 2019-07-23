package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> postorderTraversal(TreeNode root) {
        return new ArrayList<>();
    }
}
