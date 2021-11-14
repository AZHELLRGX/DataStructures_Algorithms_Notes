package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 44. 通配符匹配
 * 动态规划
 */
public class WildcardMatching {
    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        Utils.print(wildcardMatching.isMatch("adceb", "a*c?b"));
        Utils.print(wildcardMatching.isMatch("adcbeb", "a*b?b"));
        Utils.print(wildcardMatching.isMatch("aa", "a"));
        Utils.print(wildcardMatching.isMatch("aa", "*"));
        Utils.print(wildcardMatching.isMatch("cb", "?a"));
        Utils.print(wildcardMatching.isMatch("acdcb", "a*c?b"));
        Utils.print(wildcardMatching.isMatch("", "*****"));
        Utils.print(wildcardMatching.isMatch("adceb", "*a*b"));
        Utils.print(wildcardMatching.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a******b"));
        Utils.print(wildcardMatching.isMatch("abcabczzzde", "*abc???de*"));
        Utils.print(wildcardMatching.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb"
                , "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        boolean[][] dp = new boolean[m + 1][n + 1];
        //S为空，P为空时两个字符串相等
        dp[0][0] = true;
        //当字符串S为空，模式串P不空，检查P中是否有*
        for (int i = 1; i <= m; i++) {
            if (pArr[i - 1] == '*') {
                // *所在行的第一个元素置为T
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                //如果P当前是 *，从递归的角度看
                //可以将S的当前字符去掉(dp[i][j-1])
                //也可以去掉P的当前字符(dp[i-1][j])
                if (pArr[i - 1] == '*') {
                    // 要么匹配0个要么匹配一到多个
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
                //否则，要看P和S的当前字符是否匹配，或者P当前字符为?
                //如果当前字符匹配，从递归的角度看
                //可以去掉S的当前字符，P的当前字符(dp[i-1][j-1])
                else {
                    boolean isFirstMatch = pArr[i - 1] == sArr[j - 1] || pArr[i - 1] == '?';
                    // 下一个元素是否可以继续往下走依赖的是上一个元素是否匹配
                    dp[i][j] = isFirstMatch && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

}
