package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 51. N-Queens
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * @Description NQueens
 * @Author zhuyl
 * @Date 2019/7/9 11:26
 **/
public class NQueens {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new NQueens().solveNQueens2(n));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resultList = new ArrayList<>();
        List<String> queens = new ArrayList<>();
        StringBuilder rowStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            rowStr.append(".");
        }
        for (int i = 0; i < n; i++) {
            queens.add(rowStr.toString());
        }
        helper(0, queens, resultList);
        return resultList;
    }

    public void helper(int rowNum, List<String> queens, List<List<String>> resultList) {
        int n = queens.size();
        if(rowNum == n) {
            resultList.add(new ArrayList<>(queens));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(isValid(queens, rowNum, i)) {
                queens.set(rowNum, queens.get(rowNum).substring(0, i) + "Q" + queens.get(rowNum).substring(i + 1, n));
                helper(rowNum + 1, queens, resultList);
                queens.set(rowNum, queens.get(rowNum).substring(0, i) + "." + queens.get(rowNum).substring(i + 1, n));
            }
        }
    }

    public boolean isValid(List<String> queens, int rowNum, int colNum) {
        for (int i = 0; i < rowNum; i++) {
            if(queens.get(i).substring(colNum, colNum + 1).equals("Q")) {
                return false;
            }
        }
        for (int i = rowNum - 1, j = colNum - 1; i >= 0 && j >= 0; --i, --j) {
            if(queens.get(i).substring(j, j + 1).equals("Q")) {
                return false;
            }
        }
        for (int i = rowNum - 1, j = colNum + 1; i >= 0 && j < queens.size(); --i, ++j) {
            if(queens.get(i).substring(j, j + 1).equals("Q")) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> resultList = new ArrayList<>();
        List<Integer> queenCol = new ArrayList<>();
        StringBuilder rowStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            queenCol.add(-1);
        }
        helper2(0, queenCol, resultList);
        return resultList;
    }

    public void helper2(int rowNum, List<Integer> queenCol, List<List<String>> resultList) {
        int n = queenCol.size();
        if(rowNum == n) {
            List<String> queen = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringBuilder rowStr = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if(j == queenCol.get(i)) {
                        rowStr.append("Q");
                    } else {
                        rowStr.append(".");
                    }
                }
                queen.add(rowStr.toString());
            }

            resultList.add(queen);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(isValid2(queenCol, rowNum, i)) {
                queenCol.set(rowNum, i);
                helper2(rowNum + 1, queenCol, resultList);
                queenCol.set(rowNum, -1);
            }
        }
    }

    public boolean isValid2(List<Integer> queenCol, int rowNum, int colNum) {
        for (int i = 0; i < rowNum; i++) {
            if(colNum == queenCol.get(i) || Math.abs(rowNum - i) == Math.abs(colNum - queenCol.get(i))) {
                return false;
            }
        }
        return true;
    }

}
