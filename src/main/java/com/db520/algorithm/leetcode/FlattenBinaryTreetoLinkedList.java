package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 114. Flatten Binary Tree to Linked List
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * @author zhuyl
 * @version 2019-06-05
 */
public class FlattenBinaryTreetoLinkedList {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(6);
        root.left = t1;
        t1.left = t2;
        t1.right = t3;
        root.right = t4;
        t4.right = t5;
        new FlattenBinaryTreetoLinkedList().flatten2(root);
    }

    TreeNode lastvisited = null;
    public void flatten(TreeNode root) {
        if(root == null)
            return;

        TreeNode realright = root.right;
        if(lastvisited != null){
            lastvisited.left = null;
            lastvisited.right = root;
        }

        lastvisited = root;
        flatten(root.left);
        flatten(realright);
    }

    public void flatten2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        while(p != null || !stack.empty()){

            if(p.right != null){
                stack.push(p.right);
            }

            if(p.left != null){
                p.right = p.left;
                p.left = null;
            }else if(!stack.empty()){
                TreeNode temp = stack.pop();
                p.right=temp;
            }

            p = p.right;
        }
    }
}
