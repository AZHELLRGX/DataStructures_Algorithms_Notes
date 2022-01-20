package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 5. 最长回文子串
 * 做完647题，回来优化此题
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        Utils.print(l.longestPalindrome("babad"));
        Utils.print(l.longestPalindrome("cbbd"));
        Utils.print(l.longestPalindrome("a"));
        Utils.print(l.longestPalindrome("ac"));
        Utils.print(l.longestPalindrome("bbccaacacdbdbcbcbbbcbadcbdddbabaddbcadb"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        String longestPalindrome = s.substring(0, 1);
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
            String subS;
            if (right - i > 1) {
                // 还需要看看重复子串两侧是否对称
                subS = centerExpansion(s, i - 1, right);
                // 直接跳过重复字符
                i = right;
            } else {
                subS = centerExpansion(s, i - 1, i + 1);
                i++;
            }
            if (subS.length() > longestPalindrome.length()) {
                longestPalindrome = subS;
            }
        }
        return longestPalindrome;
    }

    // 中心扩展，对比左右两侧的字符
    private String centerExpansion(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
