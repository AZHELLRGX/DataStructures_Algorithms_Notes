package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 509. 斐波那契数
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        FibonacciNumber f = new FibonacciNumber();
        Utils.print(f.fib(9));
        Utils.print(f.fib(4));
    }

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
