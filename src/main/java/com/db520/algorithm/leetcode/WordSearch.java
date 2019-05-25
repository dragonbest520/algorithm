package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 79. Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * @author zhuyl
 * @version 2019-05-25
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        String word2 = "ABCCED";
        String word3 = "ABCB";
        System.out.println(new WordSearch().exist(board, word3));
    }

    public boolean exist(char[][] board, String word) {
        if(word == null || word == "") {
            return true;
        }

        if(board.length == 0) {
            return false;
        }
        if(board[0].length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(word.charAt(0) == board[i][j]) {
                    if(helper(i, j,0, word, board)) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public boolean helper(int i, int j, int index, String word, char[][] board) {
        if(index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';
        boolean result = helper(i + 1, j, index + 1, word, board) || helper(i, j + 1, index + 1, word, board) || helper(i, j - 1, index + 1, word, board) || helper(i - 1, j, index + 1, word, board);
        board[i][j] = temp;
        return result;

    }
}
