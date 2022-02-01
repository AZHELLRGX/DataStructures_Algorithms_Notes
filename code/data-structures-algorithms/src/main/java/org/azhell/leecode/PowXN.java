package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 50. Pow(x, n)
 * 剑指 Offer 16. 数值的整数次方
 * 即计算 x 的 n 次幂函数（即，xn）。
 * 二分递归解法，达到加速相乘的目的
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
        double y = myPowHandle(x, n / 2);
        double result = y * y;
        if ((n & 1) == 1) {
            result *= x;
        }
        return result;
    }
}
