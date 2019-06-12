package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * @author zhuyl
 * @version 2019-06-12
 */
public class Permutations2 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new Permutations2().permuteUnique2(nums));
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<Integer>(), new ArrayList<Integer>(), resultList);
        return resultList;
    }

    public void dfs(int[] nums, List<Integer> list, List<Integer> indexList, List<List<Integer>> resultList) {
        if(list.size() == nums.length) {
            resultList.add(new ArrayList<>(list));
            return;
        }

        int last = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != last && !indexList.contains(i)) {
                last = nums[i];
                list.add(nums[i]);
                indexList.add(i);
                dfs(nums, list, indexList, resultList);
                list.remove(list.size() - 1);
                indexList.remove(indexList.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        dfs2(nums, new ArrayList<Integer>(), new boolean[nums.length], resultList);
        return resultList;
    }

    public void dfs2(int[] nums, List<Integer> list, boolean[] visited, List<List<Integer>> resultList) {
        if(list.size() == nums.length) {
            resultList.add(new ArrayList<>(list));
            return;
        }

        int last = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != last && visited[i] == false) {
                last = nums[i];
                list.add(nums[i]);
                visited[i] = true;
                dfs2(nums, list, visited, resultList);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
