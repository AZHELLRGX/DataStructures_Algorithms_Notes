package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 415. 字符串相加
 * 要明白的一个原则就是，低位最多只会进一位到高位
 */
public class AddStrings {
    public static void main(String[] args) {
        AddStrings a = new AddStrings();
        Utils.print(a.addStrings("11", "123"));
        Utils.print(a.addStrings("456", "77"));
        Utils.print(a.addStrings("0", "0"));
        Utils.print(a.addStrings("1", "9"));
    }

    public String addStrings(String num1, String num2) {
        int i = 1;
        boolean carry = false;
        StringBuilder sb = new StringBuilder();
        while (i <= num1.length() || i <= num2.length()) {
            int temp = 0;
            if (num1.length() >= i) {
                temp += num1.charAt(num1.length() - i) - '0';
            }
            if (num2.length() >= i) {
                temp += num2.charAt(num2.length() - i) - '0';
            }
            if (carry) {
                temp += 1;
            }
            carry = temp >= 10;
            sb.append(temp % 10);
            i++;
        }
        if (carry) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
