package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 * 回溯法经典题目
 * 各种类型数据转换和初始化估计消耗了比较多的时间
 */
public class NQueens {
    public static void main(String[] args) {
        Utils.print(new NQueens().solveNQueens(4));
        Utils.print(new NQueens().solveNQueens(1));
    }


    List<List<String>> result = new ArrayList<>();
    boolean[] rowHasQ;
    boolean[] colHasQ;
    boolean[] leftSlashHasQ;
    boolean[] rightSlashHasQ;
    char[][] chars;

    public List<List<String>> solveNQueens(int n) {
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
        chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
    }

    public void solveNQueens(int qCount, int index, int n) {
        if (qCount == n) {
            result.add(format(chars));
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
                    // 摆放皇后
                    chars[rowIndex][colIndex] = 'Q';
                    // 状态位修改
                    rowHasQ[rowIndex] = true;
                    colHasQ[colIndex] = true;
                    leftSlashHasQ[rowIndex - colIndex + n - 1] = true;
                    rightSlashHasQ[rowIndex + colIndex] = true;
                    // 继续往后
                    index = i;
                    solveNQueens(++qCount, ++index, n);
                    // 回溯
                    qCount--;
                    chars[rowIndex][colIndex] = '.';
                    rowHasQ[rowIndex] = false;
                    colHasQ[colIndex] = false;
                    leftSlashHasQ[rowIndex - colIndex + n - 1] = false;
                    rightSlashHasQ[rowIndex + colIndex] = false;
                }
            }
        }
    }

    public List<String> format(char[][] chars) {
        List<String> r = new ArrayList<>(chars.length);
        for (char[] aChar : chars) {
            StringBuilder sb = new StringBuilder();
            for (char c : aChar) {
                sb.append(c);
            }
            r.add(sb.toString());
        }
        return r;
    }

}
