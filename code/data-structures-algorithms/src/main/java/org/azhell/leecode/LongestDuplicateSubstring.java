package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * 1044. 最长重复子串
 * 算法：前缀和 + 哈希 + 二分法
 * 不会做，根据别人的思路先去学习了前缀和，然后去完成了187题目，再回来做这道题
 * 187题目重复值的长度是确定的，而本题是不确定的,，所以需要查找
 * 为了加快查找效率，直接使用二分法，当mid长度的重复值可以找到的时候，没必要再去找小于mid长度的重复值了
 */
public class LongestDuplicateSubstring {
    public static void main(String[] args) {
        LongestDuplicateSubstring l = new LongestDuplicateSubstring();
        Utils.print(l.longestDupSubstring("banana"));
        Utils.print(l.longestDupSubstring("abcd"));
    }

    long[] h;
    long[] p;

    public String longestDupSubstring(String s) {
        final int P = 1313131;
        int n = s.length();
        h = new long[n + 1];
        p = new long[n + 1]; // 次方数组
        p[0] = 1;
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] * P;
            h[i + 1] = h[i] * P + s.charAt(i);
        }
        String ans = "";
        int l = 0;
        int r = n;
        while (l <= r) {
            // 这个移位确实比较秀
            int mid = l + (r - l) / 2;
            String t = check(s, mid);
            // 如果结果数组有值，那么mid就必须变大，找总长度更大的重复值
            if (t.length() != 0) l = mid + 1;
            else r = mid - 1;
            ans = t.length() > ans.length() ? t : ans;
        }
        return ans;
    }

    // 前缀和算法其实可以固化一套模版下来了
    String check(String s, int len) {
        int n = s.length();
        Set<Long> set = new HashSet<>();
        for (int i = 1; i + len - 1 <= n; i++) {
            int j = i + len - 1;
            long cur = h[j] - h[i - 1] * p[len];
            if (set.contains(cur)) return s.substring(i - 1, j);
            set.add(cur);
        }
        return "";
    }
}
