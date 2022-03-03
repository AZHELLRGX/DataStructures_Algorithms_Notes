package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 258. 各位相加
 * 这道题的挑战在于O(1)的时间复杂度
 * 假如一个三位数“abc”，
 * 其值大小为s1 = 100 * a + 10 * b + 1 * c，
 * 经过一次各位相加后，变为s2 = a + b + c，减小的差值为(s1 -s2) = 99 * a + 9 * b
 * 所以大于9的时候，如果能被9整除，则返回9，否则范围除9后的余数
 */
public class AddDigits {
    public static void main(String[] args) {
        AddDigits a = new AddDigits();
        Utils.print(a.addDigits(10));
    }

    public int addDigits(int num) {
        if (num > 9) {
            int tmp = num % 9;
            if (tmp == 0) {
                return 9;
            } else {
                return tmp;
            }
        }
        return num;
    }
}
