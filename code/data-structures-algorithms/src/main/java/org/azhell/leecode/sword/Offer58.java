package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class Offer58 {
    public static void main(String[] args) {
        Offer58 o = new Offer58();
        Utils.print(o.reverseLeftWords("abcdefg", 2));
        Utils.print(o.reverseLeftWords("lrloseumgh", 6));
    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
