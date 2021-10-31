package org.azhell.leecode;

import org.azhell.tool.StaticData;
import org.azhell.tool.Utils;

/**
 * 解数独
 * 还是回溯算法，即穷举法
 */
public class SudokuSolver {
    public static void main(String[] args) {
        new SudokuSolver().solveSudoku(StaticData.board);
        Utils.print(StaticData.board);
    }

    // 三个布尔数组 表明 行, 列, 还有 3*3 的方格的数字是否被使用过
    boolean[][] rowUsed = new boolean[9][9];
    boolean[][] colUsed = new boolean[9][9];
    boolean[][][] boxUsed = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('.' != board[i][j]) {
                    int num = board[i][j] - '1';
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[i / 3][j / 3][num] = true;
                }
            }
        }
        solveSudokuHandle(board, 0);
    }

    // n一定要参与递归
    public boolean solveSudokuHandle(char[][] board, int n) {
        // 判断结束条件
        if (n == 81) {
            return true;
        }
        int i = n / 9;
        int j = n % 9;
        if ('.' != board[i][j]) {
            return solveSudokuHandle(board, n + 1);
        }
        for (int k = 0; k < 9; k++) {
            // 开始尝试填充
            if (!rowUsed[i][k] && !colUsed[j][k]
                    && !boxUsed[i / 3][j / 3][k]) {
                board[i][j] = (char) (k + '1');
                rowUsed[i][k] = true;
                colUsed[j][k] = true;
                boxUsed[i / 3][j / 3][k] = true;
                // 进入递归
                if (solveSudokuHandle(board, n + 1))
                    return true;
                else {
                    // 退回修改之前的状态
                    rowUsed[i][k] = false;
                    colUsed[j][k] = false;
                    boxUsed[i / 3][j / 3][k] = false;
                }
            }
        }
        // 退回修改之前的状态
        board[i][j] = '.';
        return false;
    }
}
