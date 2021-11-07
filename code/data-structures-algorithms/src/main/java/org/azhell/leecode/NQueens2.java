package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 52. N皇后 II
 * 与上一题的不同之处在于此题只需要得到解的数量即可
 */
public class NQueens2 {
    public static void main(String[] args) {
        Utils.print(new NQueens2().totalNQueens(4));
        Utils.print(new NQueens2().totalNQueens(1));
    }


    int result = 0;
    boolean[] rowHasQ;
    boolean[] colHasQ;
    boolean[] leftSlashHasQ;
    boolean[] rightSlashHasQ;

    public int totalNQueens(int n) {
        init(n);
        solveNQueens(0, 0, n);
        return result;
    }

    public void init(int n) {
        // 还是三个boolean类型的数组，存放行、列、斜是否存在一个皇后
        rowHasQ = new boolean[n];
        colHasQ = new boolean[n];
        // 对于n*n的棋盘，共有2n+1条左斜线，我们可以把向左倾斜的斜线编号为（x-y+n-1）
        leftSlashHasQ = new boolean[2 * n + 1];
        // 对于n*n的棋盘，共有2n+1条右斜线，我们可以把向右倾斜的斜线标号为（x+y）
        rightSlashHasQ = new boolean[2 * n + 1];
    }

    public void solveNQueens(int qCount, int index, int n) {
        if (qCount == n) {
            result++;
        }
        // 还可以继续填充
        else {
            // 还可以继续填充，尝试在剩下的位置中找到可以摆放皇后的位置
            for (int i = index; i < n * n; i++) {
                int rowIndex = i / n;

                int colIndex = i % n;
                // 开始尝试在rowIndex、colIndex的位置上摆上皇后
                if (!rowHasQ[rowIndex] && !colHasQ[colIndex]
                        && !leftSlashHasQ[rowIndex - colIndex + n - 1] && !rightSlashHasQ[rowIndex + colIndex]) {
                    // 状态位修改
                    rowHasQ[rowIndex] = true;
                    colHasQ[colIndex] = true;
                    leftSlashHasQ[rowIndex - colIndex + n - 1] = true;
                    rightSlashHasQ[rowIndex + colIndex] = true;
                    // 继续往后，其实如果当前行已经摆放皇后，则可以直接跳入下一行【一个小优化】
                    solveNQueens(++qCount, (rowIndex + 1) * n, n);
                    // 回溯
                    qCount--;
                    rowHasQ[rowIndex] = false;
                    colHasQ[colIndex] = false;
                    leftSlashHasQ[rowIndex - colIndex + n - 1] = false;
                    rightSlashHasQ[rowIndex + colIndex] = false;
                }
            }
        }
    }
}


