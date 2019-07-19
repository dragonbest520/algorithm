package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 99. Recover Binary Search Tree
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * @Description RecoverBinarySearchTree
 * @Author zhuyl
 * @Date 2019/7/16 9:46
 **/
public class RecoverBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
        n2.right = n3;
        new RecoverBinarySearchTree().recoverTree2(n1);
        System.out.println(n1);
    }

    //双list
    public void recoverTree(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        List<Integer> valList = new ArrayList<>();
        inorder(root, nodeList, valList);
        Collections.sort(valList);
        for (int i = 0; i < nodeList.size(); i++) {
            nodeList.get(i).val = valList.get(i);
        }
    }

    private void inorder(TreeNode treeNode, List<TreeNode> nodeList, List<Integer> valList) {
        if(treeNode == null) return;
        inorder(treeNode.left, nodeList, valList);
        nodeList.add(treeNode);
        valList.add(treeNode.val);
        inorder(treeNode.right, nodeList, valList);
    }

    //双指针
    TreeNode pre = null, first = null, second = null;
    public void recoverTree2(TreeNode root) {
        inorder2(root);
        int val1 = first.val;
        int val2 = second.val;
        first.val = val2;
        second.val = val1;
    }

    private void inorder2(TreeNode treeNode) {
        if(treeNode == null) return;
        inorder2(treeNode.left);
        if(pre == null) {
            pre = treeNode;
        } else {
            if(pre.val > treeNode.val) {
                if(first == null) {
                    first = pre;
                }
                second = treeNode;
            }
            pre = treeNode;
        }
        inorder2(treeNode.right);
    }

}
