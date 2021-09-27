package org.azhell.leecode;

import org.azhell.tool.Utils;


/**
 * 整数转罗马数字
 */
public class IntegerToRoman {

    public static void main(String[] args) {
        Utils.print(new IntegerToRoman().intToRoman(3999));
    }


    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] reps = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            while (num >= values[i]) {
                num -= values[i];
                res.append(reps[i]);
            }
        }
        return res.toString();
    }
}

