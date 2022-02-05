package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 130. 被围绕的区域
 * 这道题的突破点就是那些在边上O，与它们直接或者间接相连的O才不是被围绕的区域
 * 其他所有区域都置为X
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        SurroundedRegions s = new SurroundedRegions();
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        s.solve(board);
        Utils.print("solved");
        board = new char[][]{{'X'}};
        s.solve(board);
        Utils.print("solved");
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && board[i][j] == 'O') {
                    queue.addLast(new int[]{i, j});
                    board[i][j] = 'A';
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] array = queue.pollFirst();
            for (int[] dir : dirs) {
                int x = array[0] + dir[0];
                int y = array[1] + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < m && board[x][y] == 'O') {
                    queue.add(new int[]{x, y});
                    board[x][y] = 'A';
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
