package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * @author zhuyl
 * @version 2019-06-04
 */
public class UniqueBinarySearchTrees2 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new UniqueBinarySearchTrees2().generateTrees(n));
    }


    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList<TreeNode>();
        }
        return dfs(1, n);
    }

    public List<TreeNode> dfs(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if(start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = dfs(start, i - 1);
            List<TreeNode> rights = dfs(i + 1, end);

            for (int j = 0; j < lefts.size(); j++) {
                for (int k = 0; k < rights.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = lefts.get(j);
                    root.right = rights.get(k);
                    result.add(root);
                };
            }
        }
        return result;
    }
}
