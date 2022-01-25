package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 之前这道题写的时候效率有点低，重写一下看看效率如何
 */
public class Offer12 {

    public static void main(String[] args) {
        Offer12 o = new Offer12();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Utils.print(o.exist(board, "ABCCED"));
        Utils.print(o.exist(board, "ABCCSE"));
        Utils.print(o.exist(board, "ABCB"));
    }

    // 设置一个哪些格子已经使用过的状态
    boolean[][] used;
    char[][] board;
    String word;
    int n;
    int m;

    public boolean exist(char[][] board, String word) {
        this.n = board.length;
        this.m = board[0].length;
        if (word.length() > n * m) {
            return false;
        }
        this.board = board;
        this.used = new boolean[n][m];
        this.word = word;
        // 任意找一个初始点，然后开始穷举
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (exist(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(int x, int y, int i) {
        if (i == word.length()) {
            return true;
        }
        if (x >= 0 && x < n && y >= 0 && y < m && !used[x][y] && board[x][y] == word.charAt(i)) {
            used[x][y] = true;
            if (exist(x + 1, y, i + 1)) {
                return true;
            }
            if (exist(x - 1, y, i + 1)) {
                return true;
            }
            if (exist(x, y - 1, i + 1)) {
                return true;
            }
            if (exist(x, y + 1, i + 1)) {
                return true;
            }
            // 回溯一定不要忘了
            used[x][y] = false;
        }
        return false;
    }
}
