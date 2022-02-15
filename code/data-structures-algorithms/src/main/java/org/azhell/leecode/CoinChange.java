package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        Utils.print(c.coinChange(new int[]{1, 2, 5}, 11));
        Utils.print(c.coinChange(new int[]{2}, 3));
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    // 前面可以转移过来的最小硬币数+当前硬币个数1
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
