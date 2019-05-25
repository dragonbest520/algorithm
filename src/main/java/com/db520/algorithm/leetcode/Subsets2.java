package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * @author zhuyl
 * @version 2019-05-25
 */
public class Subsets2 {

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(new Subsets2().subsetsWithDup(nums));
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {

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
            //if(!resultList.contains(tempList)) {
                resultList.add(new ArrayList<>(tempList));
            //}
            return;
        }

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            dfs(resultList, tempList, nums, i + 1, num);
            tempList.remove(tempList.size() - 1);
            while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}
