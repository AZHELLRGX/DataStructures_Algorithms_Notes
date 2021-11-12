package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 59. 螺旋矩阵 II
 * 还是模拟方法，而且正方形矩形比前面的矩阵好处理很多
 */
public class SpiralMatrix2 {
    public static void main(String[] args) {
        Utils.print(new SpiralMatrix2().generateMatrix(3));
        Utils.print(new SpiralMatrix2().generateMatrix(4));
        Utils.print(new SpiralMatrix2().generateMatrix(1));
    }

    int[][] matrix;
    int maxNum;

    public int[][] generateMatrix(int n) {
        matrix = new int[n][n];
        maxNum = n * n;
        generateHandle(1, n, 0);
        return matrix;
    }

    public void generateHandle(int num, int n, int level) {
        if (level > n - 1) {
            return;
        }
        // 一共三个转向位置，(level,n) (m,n) (m,level)
        for (int i = level; i < n; i++) {
            matrix[level][i] = num++;
        }
        for (int i = level + 1; i < n; i++) {
            matrix[i][n - 1] = num++;
        }
        for (int i = n - 2; i >= level; i--) {
            matrix[n - 1][i] = num++;
        }
        for (int i = n - 2; i > level; i--) {
            matrix[i][level] = num++;
        }

        // 然后进入内层，传入一个level，需要在(level,level)开始遍历，(1+level,level)结束遍历
        generateHandle(num, n - 1, level + 1);
    }
}
