package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * @author zhuyl
 * @version 2019-06-12
 */
public class Combinations {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(new Combinations().combine(n, k));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(1, n, k, new ArrayList<Integer>(), resultList);
        return resultList;
    }

    public void dfs(int start, int n, int k, List<Integer> list, List<List<Integer>> resultList) {
        if(0 == k) {
            resultList.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            if(!list.contains(i)) {
                list.add(i);
                dfs(i + 1, n, k - 1, list, resultList);
                list.remove(list.size() - 1);
            }
        }
    }
}
