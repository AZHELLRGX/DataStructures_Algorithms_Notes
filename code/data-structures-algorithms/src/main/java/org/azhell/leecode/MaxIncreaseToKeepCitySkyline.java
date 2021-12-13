package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 807. 保持城市天际线
 * 暴力解法就可以了，没有多的算法
 */
public class MaxIncreaseToKeepCitySkyline {
    public static void main(String[] args) {
        final MaxIncreaseToKeepCitySkyline m = new MaxIncreaseToKeepCitySkyline();
        Utils.print(m.maxIncreaseKeepingSkyline(new int[][]{
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        }));
        Utils.print(m.maxIncreaseKeepingSkyline(new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        }));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        // 其实就是找每行每列最高的那个楼宇
        final int n = grid.length;
        int[] rowMaxHeight = new int[n];
        int[] colMaxHeight = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMaxHeight[i] = Math.max(rowMaxHeight[i], grid[i][j]);
                colMaxHeight[j] = Math.max(colMaxHeight[j], grid[i][j]);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                final int min = Math.min(rowMaxHeight[i], colMaxHeight[j]);
                if (grid[i][j] < min) {
                    result += min - grid[i][j];
                }
            }
        }
        return result;
    }
}
