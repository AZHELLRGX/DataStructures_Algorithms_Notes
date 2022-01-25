package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 13. 机器人的运动范围
 */
public class Offer13 {
    public static void main(String[] args) {
        Offer13 o = new Offer13();
        Utils.print(o.movingCount(2, 3, 1));
        Utils.print(o.movingCount(3, 1, 0));
    }

    // 1表示可以到达，0标识还没走，-1表示不满足条件
    int[][] board;
    int m;
    int n;
    int k;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.board = new int[m][n];
        this.k = k;
        movingCount(0, 0);
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    private void movingCount(int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 0) {
            if (plus(x, y) <= k) {
                board[x][y] = 1;
                movingCount(x - 1, y);
                movingCount(x + 1, y);
                movingCount(x, y - 1);
                movingCount(x, y + 1);
            } else {
                board[x][y] = -1;
            }
        }
    }

    private int plus(int x, int y) {
        // 1 <= n,m <= 100; 所以x和y范围是[0,99]
        return x / 10 + x % 10 + y / 10 + y % 10;
    }
}
