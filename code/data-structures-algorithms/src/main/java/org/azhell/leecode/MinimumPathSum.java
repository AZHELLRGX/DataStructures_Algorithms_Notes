package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 64. 最小路径和
 * 依旧还是动态规划，不过每个向下的步骤记录的是前面
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int[][] obstacleGrid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        Utils.print(minimumPathSum.minPathSum(obstacleGrid));
        obstacleGrid = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        Utils.print(minimumPathSum.minPathSum(obstacleGrid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 根据公式维护一个dp数组
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else if (i == 0) {
                    dp[0][j] = dp[0][j - 1] + grid[0][j];
                } else if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + grid[i][0];
                } else {
                    // 前面路径的最小值路径 + 当前值
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[m - 1][n - 1];
    }
}
