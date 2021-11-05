package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * 二分法递归解法，加速相乘
 */
public class PowXN {
    public static void main(String[] args) {
        Utils.print(new PowXN().myPow(2.00000D, 10));
        Utils.print(new PowXN().myPow(2.10000D, 3));
        Utils.print(new PowXN().myPow(2.00000D, -2));
        Utils.print(new PowXN().myPow(2.00000D, 0));
        Utils.print(new PowXN().myPow(2.00000D, -2147483648));
        Utils.print(new PowXN().myPow(1.00000D, -2147483648));
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1D;
        }
        double result;
        if (n == Integer.MIN_VALUE) {
            result = myPowHandle(x, Integer.MAX_VALUE);
            result *= x;
        } else {
            result = myPowHandle(x, Math.abs(n));
        }

        if (n < 0) {
            result = 1D / result;
        }
        return result;


    }

    public double myPowHandle(double x, int n) {
        if (n == 1) {
            return x;
        }
        double y = myPow(x, n / 2);
        double result = y * y;
        int remainder = n % 2;
        if (remainder == 1) {
            result *= x;
        }
        return result;
    }
}
