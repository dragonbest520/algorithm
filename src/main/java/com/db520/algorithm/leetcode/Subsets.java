package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 78. Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * @author zhuyl
 * @version 2019-05-23
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Subsets().subsets(nums));
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(nums.length == 0) {
            return resultList;
        }
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> firstList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        resultList.add(firstList);

        for (int i = 1; i <= len; i++) {
            //tempList.clear();
            dfs(resultList, tempList, nums, 0, i);
        }


        return resultList;
    }

    public void dfs(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, int start, int num) {
        if(num == tempList.size()) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            dfs(resultList, tempList, nums, i + 1, num);
            tempList.remove(tempList.size() - 1);
        }

    }
}
