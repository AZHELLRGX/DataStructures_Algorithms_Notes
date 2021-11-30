package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 400. 第 N 位数字
 * 1位数是9个 所有数字是9个 从1开始
 * 2位数是90个 所有数字是180个 从10开始
 * 3位数是900个 所有数字是2700个  从100开始
 */
public class NthDigit {
    public static void main(String[] args) {
        NthDigit nthDigit = new NthDigit();
        Utils.print(nthDigit.findNthDigit(3));
        Utils.print(nthDigit.findNthDigit(11));
        Utils.print(nthDigit.findNthDigit(10));
        Utils.print(nthDigit.findNthDigit(1000000000));
    }

    public int findNthDigit(int n) {
        int d = 1;
        int count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d += 1;
            count *= 10;
        }
        // 最终在区间的数字索引
        int index = n - 1;
        // 区间起始数字
        int start = (int) Math.pow(10, (d - 1));
        // 找到对应的数
        int num = start + index / d;
        // 数中的第digitIndex位数字就是我们需要的数字
        int digitIndex = index % d;
        return String.valueOf(num).charAt(digitIndex) - '0';
    }
}
