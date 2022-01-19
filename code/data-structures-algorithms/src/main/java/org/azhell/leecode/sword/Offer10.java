package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 */
public class Offer10 {
    public static void main(String[] args) {
        Offer10 o = new Offer10();
        Utils.print(o.fib(2));
        Utils.print(o.fib(5));
        Utils.print(o.fib(100));
        Utils.print(o.numWays(2));
        Utils.print(o.numWays(7));
        Utils.print(o.numWays(0));
    }

    /*
    F(0) = 0,   F(1) = 1
    F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
    题目直接将动态转移方程写出来了
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        final int m = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % m;
        }
        return dp[n] % m;
    }

    /*
    跳到n级台阶都可以从n-1和n-2级台阶跳上来
    f(n) = f(n-1) + f(n-2)
    f(0) = 1
    f(1) = 1
     */
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        final int m = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % m;
        }
        return dp[n] % m;
    }
}
