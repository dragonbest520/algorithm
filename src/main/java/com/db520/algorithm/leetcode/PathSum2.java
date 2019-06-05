package com.db520.algorithm.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. Path Sum II
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * @author zhuyl
 * @version 2019-06-05
 */
public class PathSum2 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(5);
        TreeNode t21 = new TreeNode(4);
        TreeNode t22 = new TreeNode(8);
        TreeNode t31 = new TreeNode(11);
        TreeNode t33 = new TreeNode(13);
        TreeNode t34 = new TreeNode(4);
        TreeNode t41 = new TreeNode(7);
        TreeNode t42 = new TreeNode(2);
        TreeNode t46 = new TreeNode(1);
        t1.left = t21;
        t1.right = t22;
        t21.left = t31;
        t22.left = t33;
        t22.right = t34;
        t31.left = t41;
        t31.right = t42;
        t34.right = t46;

        System.out.println(new PathSum2().pathSum(t1, 22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resultList = new LinkedList<>();
        if(root == null) {
            return resultList;
        }
        dfs(root, sum, new ArrayList<Integer>(), resultList);
        return resultList;
    }

    public void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> resultList) {
        if(root == null) {
            return;
        }
        if(root.val == sum && root.left == null && root.right == null) {
            list.add(root.val);
            resultList.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        list.add(root.val);
        dfs(root.left, sum - root.val, list, resultList);
        dfs(root.right, sum - root.val, list, resultList);
        list.remove(list.size() - 1);
    }

    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> tempList = new LinkedList<>();
        List<List<Integer>> resultList = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) {
            return tempList;
        }
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        tempList.add(list);
        while(!queue.isEmpty()) {
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                if(queue.peek().left != null) {
                    tempList.get(0).add(queue.peek().left.val);
                    tempList.add(new ArrayList<>(tempList.get(0)));
                    tempList.get(0).remove(tempList.get(0).size() - 1);
                    queue.peek().left.val += queue.getFirst().val;
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null) {
                    tempList.get(0).add(queue.peek().right.val);
                    tempList.add(new ArrayList<>(tempList.get(0)));
                    tempList.get(0).remove(tempList.get(0).size() - 1);
                    queue.peek().right.val += queue.getFirst().val;
                    queue.offer(queue.peek().right);
                }
                if(queue.peek().left == null && queue.peek().right == null) {
                    if(queue.getFirst().val == sum) {
                        resultList.add(tempList.get(0));
                    }
                }
                queue.poll();
                tempList.remove(0);
            }
        }
        return resultList;
    }
}
