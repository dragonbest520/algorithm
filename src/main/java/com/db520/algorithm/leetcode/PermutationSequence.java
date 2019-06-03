package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. Permutation Sequence
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * @author zhuyl
 * @version 2019-05-31
 */
public class PermutationSequence {

    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        int n2 = 4;
        int k2 = 9;
        System.out.println(new PermutationSequence().getPermutation(n2, k2));
    }


    public String getPermutation(int n, int k) {
        int total = 1;
        List<Integer> list = new ArrayList();
        for (int i = 1; i <= n; i++) {
            list.add(i);
            total = total * i;
        }
        StringBuilder result = new StringBuilder();

        dfs(total, n, k, list, result);
        return result.toString();
    }

    public void dfs(int total, int n, int k, List<Integer> list, StringBuilder result) {
        if(n == 0) {
            return;
        }
        int n1 = k / (total / n);
        int n2 = k % (total / n);
        int newK;
        int newTotal = total / n;
        if(n2 != 0) {
            n1 = n1 + 1;//第几分组
        }
        result.append(list.get(n1 - 1));
        list.remove(n1 - 1);
        newK = k - (n1 - 1) * (total / n);//新的k
        dfs(newTotal, n - 1, newK, list, result);

    }
}
