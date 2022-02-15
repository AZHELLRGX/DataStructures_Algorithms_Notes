package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 343. 整数拆分
 * 先拆一个3出来，然后找到减去3以后的剩余部分的最大乘积
 * 边界条件
 * f(2) = 2
 * f(3) = 3
 * f(4) = 4
 */
public class IntegerBreak {
    public static void main(String[] args) {
        IntegerBreak i = new IntegerBreak();
        Utils.print(i.integerBreak(58));
        Utils.print(i.integerBreak(10));
        Utils.print(i.integerBreak(2));
        Utils.print(i.integerBreak(5));
        Utils.print(i.integerBreak(9));
    }

    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int[] dp = new int[n + 1];
        // 边界条件，并不是他们对应的结果，只是一个辅助计算量而已
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for (int i = 5; i <= n; i++) {
            dp[i] = 3 * dp[i - 3];
        }
        return dp[n];
    }
}
