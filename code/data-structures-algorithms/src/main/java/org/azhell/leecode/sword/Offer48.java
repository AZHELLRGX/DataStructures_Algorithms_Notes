package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 这道题之前做过，复习一遍
 * 直接使用一个数组解决，数组存储每个元素对应的最新出现的位置
 */
public class Offer48 {
    public static void main(String[] args) {
        Offer48 o = new Offer48();
        Utils.print(o.lengthOfLongestSubstring("abcabcbb"));
        Utils.print(o.lengthOfLongestSubstring("bbbbb"));
        Utils.print(o.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        // s由英文字母、数字、符号和空格组成
        int[] dp = new int[128];
        for (int i = 0; i < 128; i++) {
            dp[i] = -1;
        }
        int longestSubstringLen = 0;
        int start = 0; // 这个start的记录很重要
        for (int i = 0; i < s.length(); i++) {
            final char cur = s.charAt(i);
            start = Math.max(start, dp[cur] + 1);
            longestSubstringLen = Math.max(longestSubstringLen, i - start + 1);
            dp[cur] = i;
        }
        return longestSubstringLen;
    }
}
