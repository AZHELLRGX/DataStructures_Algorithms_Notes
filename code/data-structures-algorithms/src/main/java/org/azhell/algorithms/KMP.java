package org.azhell.algorithms;

import org.azhell.tool.Utils;

/**
 * 看看别人的KMP算法代码如何实现
 * KMP是处理字符串问题中很重要的一种算法
 * 必须加深理解，并能使用代码实现
 */
public class KMP {
    public static void main(String[] args) {
        String haystack = "BBC ABCDAB ABCDABCDABDE";
        String needle = "ABCDABD";
        Utils.print(KMP.kmpSearch(haystack, needle, getNext(needle)));
        haystack = "cdabcdabcdab";
        needle = "abcd";
        Utils.print(KMP.kmpSearch(haystack, needle, getNext(needle)));
    }

    /**
     * O(m+n)
     *
     * @param s 目标串
     * @param p 模式串
     * @return 如果匹配成功，返回下标，否则返回-1
     */
    public static int kmpSearch(String s, String p, int[] next) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return -1;
        }
        // matching: O(n)
        int i = 0;
        int j = 0;
        while (i < sLen && j < pLen) {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j];
            }
        }
        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * Table building: O(m)
     * 优化的next数组
     *
     * @param p 匹配串
     * @return 返回子串的next数组
     */
    public static int[] getNext(String p) {
        int len = p.length();
        int[] next = new int[len];
        next[0] = -1;
        int i = 0;
        int k = -1;
        while (i < len - 1) {
            // p[k]表示前缀，p[i]表示后缀
            if (k == -1 || p.charAt(i) == p.charAt(k)) {
                ++k;
                ++i;
                if (p.charAt(i) != p.charAt(k)) {
                    next[i] = k;
                } else {
                    // 因为不能出现p[i] = p[next[i]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    next[i] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
