package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 62. 不同路径
 * 动态规划解题
 * 边界条件：dp[0][0] = 0 第一行第一列的值都是1
 * 动态转移方程 dp[i][j] =  dp[i - 1][j] + dp[i][j - 1]
 */
public class UniquePaths {
    public static void main(String[] args) {
        Utils.print(new UniquePaths().uniquePaths(7, 3));
        Utils.print(new UniquePaths().uniquePaths(3, 3));
    }

    public int uniquePaths(int m, int n) {
        // 根据公式维护一个dp数组
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
