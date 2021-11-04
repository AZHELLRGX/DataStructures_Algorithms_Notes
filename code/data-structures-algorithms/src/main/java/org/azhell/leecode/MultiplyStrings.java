package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 字符串相乘
 * 步骤模拟
 * 需要考虑整型数据溢出的情况
 * 不允许使用大数类型处理，比如long类型
 * todo 等后面做完字符串加法再回来解决这个题，代码可以复用
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        Utils.print(new MultiplyStrings().multiply("123", "456"));
        Utils.print(new MultiplyStrings().multiply("2", "3"));
        Utils.print(new MultiplyStrings().multiply("2", "34"));
        Utils.print(new MultiplyStrings().multiply("0", "34"));
        Utils.print(new MultiplyStrings().multiply("123456789", "987654321"));
    }

    public String multiply(String num1, String num2) {
        long result = 0L;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int temp1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int temp2 = num2.charAt(j) - '0';
                result += temp1 * temp2 * Math.pow(10, (num1.length() - 1 - i)) * Math.pow(10, (num2.length() - 1 - j));
            }
        }
        return String.valueOf(result);
    }
}
