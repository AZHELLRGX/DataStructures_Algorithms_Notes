package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 67. 二进制求和
 */
public class AddBinary {
    public static void main(String[] args) {
        Utils.print(new AddBinary().addBinary("1011", "11101"));
        Utils.print(new AddBinary().addBinary("1011", "1101"));
        Utils.print(new AddBinary().addBinary("1010", "1011"));
        Utils.print(new AddBinary().addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        // 数据需要对齐，短的字符串前面补0
        if (a.length() > b.length()) {
            b = add0(b, a.length() - b.length());
        } else if (a.length() < b.length()) {
            a = add0(a, b.length() - a.length());
        }
        StringBuilder result = new StringBuilder();
        // 遍历，当前加的结果与进位值再次相加
        int newOne = 0;
        int base = '0' + '0';
        for (int i = a.length() - 1; i >= 0; i--) {
            int temp = a.charAt(i) + b.charAt(i) + newOne - base;
            switch (temp) {
                case 0:
                    result.append("0");
                    newOne = 0;
                    break;
                case 1:
                    result.append("1");
                    newOne = 0;
                    break;
                case 2:
                    result.append("0");
                    newOne = 1;
                    break;
                case 3:
                    result.append("1");
                    newOne = 1;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + temp);
            }
        }
        if (newOne != 0) {
            result.append("1");
        }
        return result.reverse().toString();
    }

    public String add0(String a, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("0");
        }
        sb.append(a);
        return sb.toString();
    }
}
