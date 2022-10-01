package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1694. 重新格式化电话号码
 * 22221001 今天来了一道简单题，看我重拳出击
 */
public class ReformatPhoneNumber {
    public static void main(String[] args) {
        ReformatPhoneNumber r = new ReformatPhoneNumber();
        Utils.print(r.reformatNumber("1-23-45 6"));
        Utils.print(r.reformatNumber("123 4-567"));
        Utils.print(r.reformatNumber("123 4-5678"));
        Utils.print(r.reformatNumber("--17-5 229 35-39475 "));
    }

    public String reformatNumber(String number) {
        number = number.replace("-", "").replace(" ", "");
        int length = number.length();
        if (length <= 3) {
            return number;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (length % 3 != 0 && length - i == 4) {
                sb.append(number.charAt(i))
                        .append(number.charAt(i + 1))
                        .append("-")
                        .append(number.charAt(i + 2))
                        .append(number.charAt(i + 3));
                break;
            } else if (i != length - 1 && (i + 1) % 3 == 0) {
                sb.append(number.charAt(i));
                sb.append("-");
            } else {
                sb.append(number.charAt(i));
            }
        }
        return sb.toString();
    }
}
