package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 52. N-Queens II
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * @Description NQueens2
 * @Author zhuyl
 * @Date 2019/7/9 11:29
 **/
public class NQueens2 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new NQueens2().totalNQueens(n));
    }

    public int totalNQueens(int n) {
        int result = 0;
        List<Integer> queenCol = new ArrayList<>();
        StringBuilder rowStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            queenCol.add(-1);
        }
        return helper(0, queenCol, result);
    }

    public int helper(int rowNum, List<Integer> queenCol, int result) {
        int n = queenCol.size();
        if(rowNum == n) {
            result++;
            return result;
        }

        for (int i = 0; i < n; i++) {
            if(isValid(queenCol, rowNum, i)) {
                queenCol.set(rowNum, i);
                result = helper(rowNum + 1, queenCol, result);
                queenCol.set(rowNum, -1);
            }
        }
        return result;
    }

    public boolean isValid(List<Integer> queenCol, int rowNum, int colNum) {
        for (int i = 0; i < rowNum; i++) {
            if(colNum == queenCol.get(i) || Math.abs(rowNum - i) == Math.abs(colNum - queenCol.get(i))) {
                return false;
            }
        }
        return true;
    }
}
