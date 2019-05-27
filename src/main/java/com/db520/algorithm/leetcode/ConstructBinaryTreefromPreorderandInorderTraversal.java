package com.db520.algorithm.leetcode;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * @author zhuyl
 * @version 2019-05-27
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        new ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode treeNode = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return treeNode;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[preStart]) {
                rootIndex = i;
                break;
            }
        }
        int len = rootIndex - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + len, inorder, inStart, rootIndex - 1);
        root.right = buildTree(preorder, preStart + 1 + len, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }
}
