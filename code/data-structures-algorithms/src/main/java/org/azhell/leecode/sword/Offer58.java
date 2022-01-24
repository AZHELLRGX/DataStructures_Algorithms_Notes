package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * 剑指 Offer 58 - I. 翻转单词顺序
 */
public class Offer58 {
    public static void main(String[] args) {
        Offer58 o = new Offer58();
        Utils.print(o.reverseLeftWords("abcdefg", 2));
        Utils.print(o.reverseLeftWords("lrloseumgh", 6));

        Utils.print(o.reverseWords("the sky is blue"));
        Utils.print(o.reverseWords("  hello world!  "));
        Utils.print(o.reverseWords("a good   example"));
        Utils.print(o.reverseWords(""));
        Utils.print(o.reverseWords(" "));
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

    public String reverseWords(String s) {
        if (s.replaceAll("\\s", "").isEmpty()) {
            return "";
        }
        final String[] sArray = s.split(" ");
        int i = 0;
        int j = sArray.length - 1;
        while (i < j) {
            String temp = sArray[i];
            sArray[i] = sArray[j];
            sArray[j] = temp;
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        for (String a : sArray) {
            if (!a.isEmpty())
                sb.append(a).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
