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
        //resultList.
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> firstList = new ArrayList<>();
        resultList.add(firstList);
        for (int i = 0; i < len; i++) {
            Iterator<List<Integer>> iterator = resultList.iterator();
            while(iterator.hasNext()) {
                List list = new ArrayList(iterator.next());
                list.add(nums[i]);
                resultList.add(list);
            }
        }


        return resultList;
    }
}
