package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 */
public class RomanToInteger {
    public static void main(String[] args) {
        Utils.print(new RomanToInteger().romanToInt("DCXXI"));
        Utils.print(new RomanToInteger().romanToInt1("LVIII"));
    }

    public int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] reps = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String[] words = s.split("");
        int num = 0;
        int i = 0;
        for (int j = 0; j < reps.length; j++) {
            if (i > words.length - 1) break;
            while (i < words.length && reps[j].equals(words[i])) {
                num += values[j];
                i += 1;
            }
            while (i < words.length - 1 && reps[j].equals(words[i] + words[i + 1])) {
                num += values[j];
                i += 2;
            }
        }
        return num;
    }

    /*
    首先建立一个HashMap来映射符号和值，然后对字符串从左到右来，
    如果当前字符代表的值不小于其右边，就加上该值；否则就减去该值。
    以此类推到最左边的数，最终得到的结果即是答案
     */
    public int romanToInt1(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("M", 1000);
            put("D", 500);
            put("C", 100);
            put("L", 50);
            put("X", 10);
            put("V", 5);
            put("I", 1);
        }};
        String[] words = s.split("");
        int num = 0;
        for (int i = 0; i < words.length; i++) {
            Integer l = map.get(words[i]);
            if (i < words.length - 1) {
                Integer r = map.get(words[i + 1]);
                if (l < r) {
                    num -= l;
                } else {
                    num += l;
                }
            } else {
                num += l;
            }
        }
        return num;
    }
}
