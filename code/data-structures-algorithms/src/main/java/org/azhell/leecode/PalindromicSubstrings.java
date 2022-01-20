package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 647. 回文子串
 * 依次遍历每一个字符，然后往两侧扩展
 * 需要考虑一种特殊情况就是下一个字符与当前字符相同的情况
 */
public class PalindromicSubstrings {
    public static void main(String[] args) {
        PalindromicSubstrings p = new PalindromicSubstrings();
        Utils.print(p.countSubstrings("aaa"));
        Utils.print(p.countSubstrings("caccc"));
        Utils.print(p.countSubstrings("aba"));
        Utils.print(p.countSubstrings("bbccaacacdbdbcbcbbbcbadcbdddbabaddbcadb"));
    }

    public int countSubstrings(String s) {
        int len = s.length();
        if (len == 1) {
            return 1;
        }
        int subNum = len;
        int i = 0;
        while (i < len) {
            char curChar = s.charAt(i);
            // 右侧的字符是否与当前字符相同
            int right = i + 1;
            while (right < len) {
                if (s.charAt(right) != curChar)
                    break;
                right++;
            }
            int repeatLen = right - i;
            if (repeatLen > 1) {
                // 不同的组合情况
                for (int j = 1; j < repeatLen; j++) {
                    subNum += j;
                }
                // 还需要看看重复子串两侧是否对称
                subNum += centerExpansion(s, i - 1, right);
                // 直接跳过重复字符
                i = right;
            } else {
                subNum += centerExpansion(s, i - 1, i + 1);
                i++;
            }
        }
        return subNum;
    }

    // 中心扩展，对比左右两侧的字符
    private int centerExpansion(String s, int left, int right) {
        int subNum = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            subNum += 1;
            left--;
            right++;
        }
        return subNum;
    }
}
