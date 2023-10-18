package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 2652. 倍数求和
 * 这道题用枚举做就是一道简单题
 * 但是如果用等差数列 + 容斥原理解题则更加优秀
 */
public class Q2652 {
    public static void main(String[] args) {
        Utils.print(new Q2652().sumOfMultiples(10));
    }

    public int f(int n, int m) {
        // 首先，我们要找到区间 [1, n] 中能够被 m 整除的整数。这些整数可以表示为：m, 2m, 3m, 4m, ..., (n/m)m。这是一个等差数列，公差为 m。
        // 接下来，我们需要计算这个等差数列的和。等差数列和的公式是：S = (n/2)(2a + (n-1)d)，其中 S 代表和，n 代表项数，a 代表首项，d 代表公差。
        return (m + n / m * m) * (n / m) / 2;
    }

    public int sumOfMultiples(int n) {
        return f(n, 3) + f(n, 5) + f(n, 7) - f(n, 3 * 5) - f(n, 3 * 7) - f(n, 5 * 7) + f(n, 3 * 5 * 7);
    }
}
