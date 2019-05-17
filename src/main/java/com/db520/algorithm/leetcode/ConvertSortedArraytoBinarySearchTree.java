package com.db520.algorithm.leetcode;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * @author zhuyl
 * @version 2019-05-17
 */
public class ConvertSortedArraytoBinarySearchTree {



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] array = {-10,-3,0,5,9};
        System.out.println(new ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(array));
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST(nums, start, mid - 1);
        treeNode.right = sortedArrayToBST(nums, mid + 1, end);
        return treeNode;
    }
}
