package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 *
 * @author zhuyl
 * @version 2019-05-19
 */
public class CombinationSumTwo {

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int[] candidates2 = {2,5,2,1,2};
        int target = 8;
        int target2 = 5;
        System.out.println(new CombinationSumTwo().combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res, temp, target, candidates, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int target,
                     int[] candidates, int j) {
        if (target == 0) {  //满足条件，将中间集加入结果集
            //if(!res.contains(temp)) {
                res.add(new ArrayList<>(temp));
            //}
        }
        for (int i = j; i < candidates.length && target >= candidates[i]; i++) {  //target>=candidates[i]是剪枝操作
            if (i > j && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            dfs(res, temp, target - candidates[i], candidates, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
