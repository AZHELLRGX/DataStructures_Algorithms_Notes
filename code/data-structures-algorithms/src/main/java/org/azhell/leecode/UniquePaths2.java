package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 63. 不同路径 II
 * 在上一题的基础上加上了障碍物的概念
 */
public class UniquePaths2 {
    public static void main(String[] args) {
        UniquePaths2 uniquePaths2 = new UniquePaths2();
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        Utils.print(uniquePaths2.uniquePathsWithObstacles(obstacleGrid));
        obstacleGrid = new int[][]{
                {0, 1},
                {0, 0}
        };
        Utils.print(uniquePaths2.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 根据公式维护一个dp数组
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果存在障碍物，那么这个地方就是0
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                } else if (i == 0) {
                    dp[0][j] = dp[0][j - 1];
                } else if (j == 0) {
                    dp[i][0] = dp[i - 1][0];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

            }
        }
        return dp[m - 1][n - 1];
    }
}
