package org.azhell.leecode;


import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 自己的思路：使用二维数组解题  但是效率都比较低
 * 不需要借助笨拙的二维数组，只需要按照数据分布规律放置在数组即可
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        // Utils.print(convert(s, numRows));
        Utils.print(convert1(s, numRows));
    }

    private static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        // 9宫格存储7（3+3+1）个元素，16宫格存储10（4+4+2）个元素，25（5+5+3）
        // 创建一个列数足够充裕的二维数组（列数存在浪费）
        char[][] zArray = new char[s.length()][numRows];
        int k = 0;
        for (int i = 0; i < zArray.length; i++) {
            if (k >= s.length()) break;
            for (int j = 0; j < numRows; j++) {
                if (k >= s.length()) break;
                // 每个X宫格内，中间的x-2列都是对称线上面的格子可以存储元素
                if (i == 0 || i % (numRows - 1) == 0 || (i + j) % (numRows - 1) == 0) {
                    // 这些列所有行都可以存储元素
                    zArray[i][j] = s.charAt(k++);
                    // 看看是否满足 x + y 横纵坐标的和为 numRows - 1
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < zArray[1].length; j++) {
            for (char[] chars : zArray) {
                if (chars[j] != '\u0000') {
                    sb.append(chars[j]);
                }
            }
        }
        return sb.toString();
    }

    private static String convert1(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
