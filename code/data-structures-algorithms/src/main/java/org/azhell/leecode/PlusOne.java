package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 加一
 * 比较简单，主要是要注意最高位进位的问题
 */
public class PlusOne {
    public static void main(String[] args) {
        Utils.print(new PlusOne().plusOne(new int[]{9, 9, 9}));
        Utils.print(new PlusOne().plusOne(new int[]{1, 2, 3}));
        Utils.print(new PlusOne().plusOne(new int[]{4, 3, 2, 1}));
        Utils.print(new PlusOne().plusOne(new int[]{0}));
    }

    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
        } else {
            digits[digits.length - 1] = 0;
            int carry = 1;
            for (int i = digits.length - 2; i >= 0; i--) {
                int temp = digits[i] + carry;
                if (temp == 10) {
                    digits[i] = 0;
                    carry = 1;
                } else {
                    digits[i] = digits[i] + 1;
                    carry = 0;
                    break;
                }
            }
            // 如果最高位也进1，则需要创建新的数组
            if (carry == 1) {
                digits = new int[digits.length + 1];
                digits[0] = 1;
            }
        }
        return digits;
    }
}
