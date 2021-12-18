package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 419. 甲板上的战舰
 */
public class BattleshipsInABoard {
    public static void main(String[] args) {
        char[][] board = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };
        BattleshipsInABoard b = new BattleshipsInABoard();
        Utils.print(b.countBattleships(board));
    }

    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && board[i - 1][j] == 'X' || j > 0 && board[i][j - 1] == 'X')
                    continue;
                if (board[i][j] == 'X')
                    ans++;
            }
        }
        return ans;
    }
}
