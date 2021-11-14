package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 70. 爬楼梯
 * 经典动态规划问题
 * f(n) = f(n-1) + f(n-2)
 * f(1) = 1;
 * f(2) = 2;
 * 直接使用递归方案会超时
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        Utils.print(new ClimbingStairs().climbStairs(10));
        Utils.print(new ClimbingStairs().climbStairs(3));
        Utils.print(new ClimbingStairs().climbStairs(45));
    }


    public int climbStairs(int n) {
        // 借助动态规划
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
