package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * 可以发现，动态规划的题目中总是会出现”最“等字眼
 * <p>
 * 对于本题而言，每个格子均由左边或者上面的格子移动而来
 * 所以需要一个记录每次移动后最大值的dp数组
 */
public class Offer47 {
    public static void main(String[] args) {
        Offer47 o = new Offer47();
        Utils.print(o.maxValue(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }

    public int maxValue(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
