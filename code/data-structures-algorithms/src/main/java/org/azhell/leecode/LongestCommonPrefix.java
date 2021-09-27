package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 最长公共前缀
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Utils.print(new LongestCommonPrefix().longestCommonPrefix(new String[]
                {"flower","flow","flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        // 先找出最短字符串
        String minS = strs[0];
        int min = minS.length();
        for (String str : strs) {
            if (min > str.length()) {
                minS = str;
            }
        }
        int num = 0;
        while (minS.length() > 0 && num < strs.length) {
            num = 0;
            for (String str : strs) {
                if (!str.startsWith(minS)) {
                    minS = minS.substring(0, minS.length() - 1);
                    break;
                } else {
                    num++;
                }
            }
        }
        return minS;
    }
}
