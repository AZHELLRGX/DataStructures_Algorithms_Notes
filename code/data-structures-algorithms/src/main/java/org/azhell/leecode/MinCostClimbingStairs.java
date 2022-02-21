package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 746. 使用最小花费爬楼梯
 * 任何一级台阶都由前一个或者两个爬上来，只需要二选一小的即可
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairs m = new MinCostClimbingStairs();
        Utils.print(m.minCostClimbingStairs(new int[]{10, 15, 20}));
        Utils.print(m.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        Utils.print(m.minCostClimbingStairs(new int[]{1, 2}));
        Utils.print(m.minCostClimbingStairs(new int[]{12, 2}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = (i < n ? cost[i] : 0) + Math.min(dp[i - 1], dp[i - 2]);
        }
        return dp[n];
    }
}
