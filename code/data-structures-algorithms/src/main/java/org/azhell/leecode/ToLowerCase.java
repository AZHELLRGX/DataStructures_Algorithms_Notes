package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 709. 转换成小写字母
 * 来leet-code遇到的最简单的一道题
 */
public class ToLowerCase {
    public static void main(String[] args) {
        ToLowerCase t = new ToLowerCase();
        Utils.print(t.toLowerCase("Hello"));
        Utils.print(t.toLowerCase("here"));
        Utils.print(t.toLowerCase("LOVELY"));
    }

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c | 32));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
