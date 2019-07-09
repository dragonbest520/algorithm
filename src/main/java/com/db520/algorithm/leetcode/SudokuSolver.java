package com.db520.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 37. Sudoku Solver
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * @Description SudokuSolver
 * @Author zhuyl
 * @Date 2019/7/6 14:26
 **/
public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board =
                {
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}
                };
        new SudokuSolver().solveSudoku(board);
    }

    public void solveSudoku(char[][] board) {
        boolean result = solve(board);
        System.out.println(result);
    }

    public boolean solve(char[][] board) {
        int nextNode = nextNode(board);
        return solveSudoku(board, nextNode);
    }

    private boolean solveSudoku(char[][] board, int node) {
        List<Character> availNums = available(board, node);
        if(availNums.isEmpty()){
            return false;
        }
        int line = node / 10;
        int col = node % 10;
        for(Character nodeTmp : availNums){
            board[line][col] = nodeTmp;
            int nextNode = nextNode(board);
            if(nextNode == -1){
                return true;
            }else if(solveSudoku(board,nextNode)){
                return true;
            }
        }
        board[line][col] = '.';
        return false;
    }

    private int nextNode(char[][] board){
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '.'){
                    return (i*10 + j);
                }
            }
        }
        return -1;
    }

    private List<Character> available(char[][] board, int node) {
        char[] array = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        List<Character> list = new ArrayList<>();
        int line = node / 10;
        int col = node % 10;
        //row
        for (int j = 0; j < 9; j++) {
            if(board[j][col] != '.') {
                array[board[j][col] - '1'] = '0';
            }
        }
        //column
        for (int j = 0; j < 9; j++) {
            if(board[line][j] != '.') {
                array[board[line][j] - '1'] = '0';
            }
        }
        //box
        for (int i = (line / 3) * 3; i < (line / 3) * 3 + 3; i++) {
            for (int j = (col / 3) * 3; j < (col / 3) * 3 + 3; j++) {
                if(board[i][j] != '.') {
                    array[board[i][j] - '1'] = '0';
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            if(array[i] != '0') {
                list.add(array[i]);
            }
        }

        return list;
    }

    //Too slow
    private List<Character> available2(char[][] board, int node) {
        List<Character> list = new ArrayList<>();
        int line = node / 10;
        int col = node % 10;
        //row
        for (int j = 0; j < 9; j++) {
            if(board[j][col] != '.') {
                if(!list.contains(board[j][col])) {
                    list.add(board[j][col]);
                }
            }
        }
        //column
        for (int j = 0; j < 9; j++) {
            if(board[line][j] != '.') {
                if(!list.contains(board[line][j])) {
                    list.add(board[line][j]);
                }
            }
        }
        //box
        for (int i = (line / 3) * 3; i < (line / 3) * 3 + 3; i++) {
            for (int j = (col / 3) * 3; j < (col / 3) * 3 + 3; j++) {
                if (!list.contains(board[i][j])) {
                    list.add(board[i][j]);
                }
            }
        }

        List<Character> resultList = new ArrayList<>();
        resultList.add('1');
        resultList.add('2');
        resultList.add('3');
        resultList.add('4');
        resultList.add('5');
        resultList.add('6');
        resultList.add('7');
        resultList.add('8');
        resultList.add('9');
        resultList.removeAll(list);

        return resultList;
    }
}
