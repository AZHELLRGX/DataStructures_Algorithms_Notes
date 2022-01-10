package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 43.字符串相乘
 * 步骤模拟
 * num1的第i位(高位从0开始)和num2的第j位相乘的结果在乘积中的位置是[i+j, i+j+1]
 * 所以使用数组来存储各位相乘以后的结果
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        Utils.print(new MultiplyStrings().multiply("45", "123"));
        Utils.print(new MultiplyStrings().multiply("123", "456"));
        Utils.print(new MultiplyStrings().multiply("2", "3"));
        Utils.print(new MultiplyStrings().multiply("2", "34"));
        Utils.print(new MultiplyStrings().multiply("0", "34"));
        Utils.print(new MultiplyStrings().multiply("123456789", "987654321"));
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] ansArray = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                // 与之前的数据相加，判断是否存在进位
                int res = n1 * n2 + ansArray[i + j + 1];
                ansArray[i + j] += res / 10;
                ansArray[i + j + 1] = res % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (ansArray[0] != 0) {
            sb.append(ansArray[0]);
        }
        for (int i = 1; i < ansArray.length; i++) {
            sb.append(ansArray[i]);
        }
        return sb.toString();
    }
}
