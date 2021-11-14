package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 69. Sqrt(x)
 * 二分查找，可以使用long
 */
public class SqrtX {
    public static void main(String[] args) {
        Utils.print(new SqrtX().mySqrt(1));
        Utils.print(new SqrtX().mySqrt(8));
        Utils.print(new SqrtX().mySqrt(4));
        Utils.print(new SqrtX().mySqrt(9));
        Utils.print(new SqrtX().mySqrt(15));
        Utils.print(new SqrtX().mySqrt(Integer.MAX_VALUE));
    }

    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int top = x;
        int mid = x / 2;
        int bellow = 0;
        while (mid != bellow) {
            if (((long) mid * mid) > x) {
                top = mid;
            } else {
                bellow = mid;
            }
            mid = (top + bellow) / 2;
        }
        return mid;
    }

}
