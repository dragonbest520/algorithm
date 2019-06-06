package com.db520.algorithm.leetcode;

import java.util.*;

/**
 * 130. Surrounded Regions
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * @author zhuyl
 * @version 2019-06-06
 */
public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};
        new SurroundedRegions().solve(board);
    }


    class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Character> q = new LinkedList<>();
        // 第一行和最后一行
        for (int i = 0; i < n; i++) {
            if (!visited[0][i] && board[0][i] == 'O')
                bfs(board, 0, i, m, n, visited);
            if (!visited[m - 1][i] && board[m - 1][i] == 'O')
                bfs(board, m - 1, i, m, n, visited);

        }
        // 第一列和最后一列
        for (int i = 0; i < m; i++) {
            if (!visited[i][0] && board[i][0] == 'O')
                bfs(board, i, 0, m, n, visited);
            if (!visited[i][n - 1] && board[i][n - 1] == 'O')
                bfs(board, i, n - 1, m, n, visited);

        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        for (int i = 0; i < m; i++)
            System.out.println(Arrays.toString(board[i]));
    }

    Queue<Node> q = new LinkedList<>();

    // 加入队列的时候设置visited该结点为true
    private void bfs(char[][] board, int row, int col,
                     int m, int n, boolean[][] visited) {
        q.offer(new Node(row, col));
        visited[row][col] = true;
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            row = tmp.row;
            col = tmp.col;
            if (row - 1 >= 0 && !visited[row - 1][col]
                    && board[row - 1][col] == 'O') {
                q.offer(new Node(row - 1, col));
                visited[row - 1][col] = true;
            }
            if (row + 1 < m && !visited[row + 1][col]
                    && board[row + 1][col] == 'O') {
                q.offer(new Node(row + 1, col));
                visited[row + 1][col] = true;
            }
            if (col - 1 >= 0 && !visited[row][col - 1]
                    && board[row][col - 1] == 'O') {
                q.offer(new Node(row, col - 1));
                visited[row][col - 1] = true;
            }
            if (col + 1 < n && !visited[row][col + 1]
                    && board[row][col + 1] == 'O') {
                q.offer(new Node(row, col + 1));
                visited[row][col + 1] = true;
            }
        }
    }

    public void solve2(char[][] grid) {
        if (grid == null)
            return;
        int rows = grid.length;
        if (rows <= 0)
            return;
        int cols = grid[0].length;
        if (cols <= 0)
            return;
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 'O')
                dfsSearch(grid, i, 0);
            if (grid[i][cols - 1] == 'O')
                dfsSearch(grid, i, cols - 1);
        }
        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 'O')
                dfsSearch(grid, 0, i);
            if (grid[rows - 1][i] == 'O')
                dfsSearch(grid, rows - 1, i);
        }

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == '*')
                    grid[i][j] = 'O';
                else if (grid[i][j] == 'O')
                    grid[i][j] = 'X';
        for (int i = 0; i < rows; i++)
            System.out.println(Arrays.toString(grid[i]));
    }

    // 每遇到'O'后, 开始向四个方向 递归搜索. 搜到后变为'*',
    // 因为相邻的属于一个island. 然后开始继续找下一个'O'.
    private void dfsSearch(char[][] grid, int i, int j) {
        if (grid[i][j] == 'O') {
            // 修改为一个不相干的字符，但不能是X
            grid[i][j] = '*';// 和visited数组一样功能
            // 不需要处理四周边缘了，调用循环已经处理过，不然超时
            if (i < grid.length - 2)
                dfsSearch(grid, i + 1, j);
            if (i > 1)
                dfsSearch(grid, i - 1, j);
            if (j < grid[0].length - 2)
                dfsSearch(grid, i, j + 1);
            if (j > 1)
                dfsSearch(grid, i, j - 1);
        }
    }


}
