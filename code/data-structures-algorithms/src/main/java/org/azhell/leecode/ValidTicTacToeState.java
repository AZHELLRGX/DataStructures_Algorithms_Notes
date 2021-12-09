package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 794. 有效的井字游戏
 * 参考别人的判断条件总结
 * 1、X必须比O多1个或者相同，否则false；
 * 2、X和O不能同时都是赢家，否则false；
 * 3、X赢的时候必须比O多1个，否则false；
 * 4、O赢得时候个数与X相同，否则false；
 * <p>
 * 其他的都是true
 */
public class ValidTicTacToeState {
    public static void main(String[] args) {
        ValidTicTacToeState v = new ValidTicTacToeState();
        Utils.print(v.validTicTacToe(new String[]{"O  ", "   ", "   "}));
        Utils.print(v.validTicTacToe(new String[]{"XOX", " X ", "   "}));
        Utils.print(v.validTicTacToe(new String[]{"XXX", "   ", "OOO"}));
        Utils.print(v.validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
    }

    // 记录X数量 O数量
    int xCnt;
    int oCnt;
    // X是否赢  O是否赢
    boolean xWin;
    boolean oWin;

    public boolean validTicTacToe(String[] board) {
        xCnt = 0;
        oCnt = 0;
        xWin = false;
        oWin = false;
        // 记录3列和2对角线的值
        String[] cols = new String[]{"", "", ""};
        String[] diagonals = new String[]{"", ""};
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (board[j].charAt(k) == 'X') {
                    xCnt++;
                } else if (board[j].charAt(k) == 'O') {
                    oCnt++;
                }
                cols[k] += board[j].charAt(k);
                if (j - k == 0) {
                    diagonals[0] += board[j].charAt(k);
                }
                if (j + k == 2) {
                    diagonals[1] += board[j].charAt(k);
                }
            }
            // 判断3行是否有一致的数据
            judgeWin(board[j]);
        }
        // 判断3列以及两个对角线是否存在一样的值
        for (String col : cols) {
            judgeWin(col);
        }
        for (String diagonal : diagonals) {
            judgeWin(diagonal);
        }
        return judgeValid();
    }

    public boolean judgeValid() {
        if (xWin && oWin) {
            return false;
        } else {
            final int i = xCnt - oCnt;
            if (i != 0 && i != 1) {
                return false;
            }
            if (xWin && i != 1) {
                return false;
            }
            return !oWin || i == 0;
        }
    }

    public void judgeWin(String line) {
        if ("XXX".equals(line)) {
            xWin = true;
        } else if ("OOO".equals(line)) {
            oWin = true;
        }
    }
}
