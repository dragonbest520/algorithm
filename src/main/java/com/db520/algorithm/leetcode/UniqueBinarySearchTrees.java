package com.db520.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 96. Unique Binary Search Trees
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * @author zhuyl
 * @version 2019-06-04
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        int n = 3;
        int n2 = 18;
        System.out.println(new UniqueBinarySearchTrees().numTrees2(n2));
    }

    Map<Integer, Integer> map = new HashMap();

    public int numTrees(int n) {
        if(n == 0) {
            return 0;
        }
        return dfs(1, n);
    }

    public int dfs(int start, int end) {
        if(start > end) {
            return 1;
        }
        if(map.containsKey(end - start)) {
            return map.get(end - start);
        }
        int result = 0;
        for (int i = start; i <= end; i++) {
            int lefts = dfs(start, i - 1);
            int rights = dfs(i + 1, end);

            result += lefts * rights;
        }
        map.put(end - start, result);
        return result;
    }

    //卡特兰数
    public int numTrees2(int n) {
        if(n == 0) {
            return 0;
        }
        int[] c = new int[n + 1];
        c[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                c[i] += c[j] * c[i - 1 - j];
            }

        }
        return c[n];
    }
}
