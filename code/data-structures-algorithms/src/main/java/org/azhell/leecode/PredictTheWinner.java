package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 486. 预测赢家
 * 这道题与【877. 石子游戏】类似，877题是本题的一种特例
 */
public class PredictTheWinner {
    public static void main(String[] args) {
        PredictTheWinner p = new PredictTheWinner();
        Utils.print(p.predictTheWinner(new int[]{1, 5, 2}));
        Utils.print(p.predictTheWinner(new int[]{1, 5, 233, 7}));
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        if (n % 2 == 0) {
            // 数组长度是偶数，则一定是先手获胜
            return true;
        }
        // 数组长度是奇数，则需要动态规划
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
