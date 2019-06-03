package com.db520.algorithm.leetcode;

/**
 * 36. Valid Sudoku
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 *
 * @author zhuyl
 * @version 2019-05-31
 */
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = 
            {
              {'8','3','.','.','7','.','.','.','.'},
              {'6','.','.','1','9','5','.','.','.'},
              {'.','9','8','.','.','.','.','6','.'},
              {'8','.','.','.','6','.','.','.','3'},
              {'4','.','.','8','.','3','.','.','1'},
              {'7','.','.','.','2','.','.','.','6'},
              {'.','6','.','.','.','.','2','8','.'},
              {'.','.','.','4','1','9','.','.','5'},
              {'.','.','.','.','8','.','.','7','9'}
            };
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }


    public boolean isValidSudoku(char[][] board) {
        StringBuilder[] stringBuilders = new StringBuilder[27];
        for (int i = 0; i < 9; i++) {
            //9 row
            for (int j = 0; j < 9; j++) {
                if(board[j][i] != '.') {
                    if(stringBuilders[j] == null) {
                        stringBuilders[j] = new StringBuilder();
                    }
                    if(!isValid(stringBuilders[j], board[j][i])) {
                        return false;
                    } else {
                        stringBuilders[j].append(board[j][i]);
                    }
                }
            }
            //9 column
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(stringBuilders[j + 9] == null) {
                        stringBuilders[j + 9] = new StringBuilder();
                    }
                    if(!isValid(stringBuilders[j + 9], board[i][j])) {
                        return false;
                    } else {
                        stringBuilders[j + 9].append(board[i][j]);
                    }
                }
            }
            //9 boxes
            for (int j = 0; j < 9; j++) {
                if(board[i / 3 + 3 * (j / 3)][i % 3 + 3 * (j % 3)] != '.') {
                    if(stringBuilders[j + 18] == null) {
                        stringBuilders[j + 18] = new StringBuilder();
                    }
                    if(!isValid(stringBuilders[j + 18], board[i / 3 + 3 * (j / 3)][i % 3 + 3 * (j % 3)])) {
                        return false;
                    } else {
                        stringBuilders[j + 18].append(board[i / 3 + 3 * (j / 3)][i % 3 + 3 * (j % 3)]);
                    }
                }
            }
        }
        return true;
    }

    public boolean isValid(StringBuilder stringBuilder, char c) {
        if(stringBuilder.indexOf(String.valueOf(c)) == -1){
            return true;
        } else {
            return false;
        }
    }
}
