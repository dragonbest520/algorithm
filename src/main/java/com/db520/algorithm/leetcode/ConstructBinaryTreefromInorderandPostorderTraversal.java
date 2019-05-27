package com.db520.algorithm.leetcode;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * @author zhuyl
 * @version 2019-05-27
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder  = {9,15,7,20,3};
        new ConstructBinaryTreefromInorderandPostorderTraversal().buildTree(inorder, postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode treeNode = buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return treeNode;
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == postorder[postEnd]) {
                rootIndex = i;
                break;
            }
        }
        int len = rootIndex - inStart;

        root.left = buildTree(inorder, inStart, rootIndex - 1, postorder, postStart, postStart+len-1);
        root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postStart+len, postEnd - 1);
        return root;
    }
}
