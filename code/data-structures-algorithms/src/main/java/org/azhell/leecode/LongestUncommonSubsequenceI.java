package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 521. 最长特殊序列 Ⅰ
 * 脑筋急转弯？最长子序列就是两个字符里面最长的那个
 */
public class LongestUncommonSubsequenceI {
    public static void main(String[] args) {
        LongestUncommonSubsequenceI l = new LongestUncommonSubsequenceI();
        Utils.print(l.findLUSlength("aba", "cdc"));
        Utils.print(l.findLUSlength("aaa", "aaa"));
    }

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
