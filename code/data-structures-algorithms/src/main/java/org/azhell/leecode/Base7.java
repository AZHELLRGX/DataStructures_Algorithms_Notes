package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 504. 七进制数
 */
public class Base7 {
    public static void main(String[] args) {
        Base7 b = new Base7();
        Utils.print(b.convertToBase7(100));
        Utils.print(b.convertToBase7(-7));
    }

    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean flag = num < 0;
        num = Math.abs(num);
        while (num >= 7) {
            sb.append(num % 7);
            num /= 7;
        }
        sb.append(num);
        return (flag ? "-" : "") + sb.reverse();
    }
}
