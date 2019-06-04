package com.db520.algorithm.leetcode;

/**
 * 109. Convert Sorted List to Binary Search Tree
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * @author zhuyl
 * @version 2019-06-04
 */
public class ConvertSortedListtoBinarySearchTree {

    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        new ConvertSortedListtoBinarySearchTree().sortedListToBST(node1);
    }

    ListNode curNode = null;


    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode temp = head;
        int len = 1;
        while(temp.next != null) {
            temp = temp.next;
            len++;
        }

        curNode = head;
        TreeNode root = dfs(head, len);
        return root;
    }


    public TreeNode dfs(ListNode head, int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = dfs(head, size / 2);
        TreeNode root = new TreeNode(curNode.val);

        // move the current node to the next place.
        curNode = curNode.next;
        TreeNode right = dfs(curNode, size - size / 2 - 1);

        root.left = left;
        root.right = right;

        return root;
    }
}
