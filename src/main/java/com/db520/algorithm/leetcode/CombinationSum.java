package com.db520.algorithm.leetcode;

import java.util.*;

/**
 * 39. Combination Sum
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * @author zhuyl
 * @version 2019-05-19
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(new CombinationSum().combinationSum(candidates, target));
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < candidates.length; i++) {
            numMap.putIfAbsent(candidates[i], i);
        }

        int t = target;
        while(t > 0) {

        }


        List<List<Integer>> list = new ArrayList<>();

        return list;
    }

    public boolean test(int[] candidates, int target) {
        for (int i = 0; i < candidates.length; i++) {
            if(candidates)
        }
    }
}
