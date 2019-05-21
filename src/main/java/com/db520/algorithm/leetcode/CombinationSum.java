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
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res, temp, target, candidates, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int target,
                     int[] candidates, int j) {
        if (target == 0) {  //满足条件，将中间集加入结果集
            res.add(new ArrayList<>(temp));
        }
        for (int i = j; i < candidates.length && target >= candidates[i]; i++) {  //target>=candidates[i]是剪枝操作
            temp.add(candidates[i]);
            dfs(res, temp, target - candidates[i], candidates, i);
            temp.remove(temp.size() - 1);
        }
    }
}
