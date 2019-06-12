package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * @author zhuyl
 * @version 2019-06-12
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Permutations().permute(nums));
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(nums, new ArrayList<Integer>(), resultList);
        return resultList;
    }

    public void dfs(int[] nums, List<Integer> list, List<List<Integer>> resultList) {
        if(list.size() == nums.length) {
            resultList.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs(nums, list, resultList);
                list.remove(list.size() - 1);
            }
        }
    }
}
