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
//        Utils.print(nthDigit.findNthDigit(3));
//        Utils.print(nthDigit.findNthDigit(11));
//        Utils.print(nthDigit.findNthDigit(10));
        Utils.print(nthDigit.findNthDigit(1000000000));
    }

    public int findNthDigit(int n) {
        int count = 9;
        int numDigits = 1;
        while (n > count * numDigits) {
            n = n - count * numDigits;
            count *= 10;
            numDigits += 1;
        }
        int index = (n - 1) / numDigits;
        int remainder = n % numDigits;
        if (remainder > 0) {
            remainder = remainder - 1;
        } else {
            remainder = numDigits - 1;
        }
        return String.valueOf((int) Math.pow(10, (numDigits - 1)) + index).charAt(remainder) - '0';
    }
}
