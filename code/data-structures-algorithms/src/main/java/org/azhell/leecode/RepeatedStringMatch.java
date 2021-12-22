package org.azhell.leecode;

import org.azhell.algorithms.KMP;
import org.azhell.tool.Utils;

/**
 * 686. 重复叠加字符串匹配
 * 如果b长度比a小，则使用kmp算法判断b是否是a的子串
 * 如果a长度比b小，则也使用kmp算法找到第一个匹配位置，然后将依次往后叠加，另外还需判断b剩余的字符串是否是a的尾和头
 */
public class RepeatedStringMatch {
    public static void main(String[] args) {
        RepeatedStringMatch r = new RepeatedStringMatch();
        Utils.print(r.repeatedStringMatch("abcd", "cdabcdabcdab"));
        Utils.print(r.repeatedStringMatch("abcd", "abcdabcdab"));
        Utils.print(r.repeatedStringMatch("abc", "wxyz"));
        Utils.print(r.repeatedStringMatch("a", "a"));
        Utils.print(r.repeatedStringMatch("a", "aa"));
        Utils.print(r.repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ba"));
        Utils.print(r.repeatedStringMatch("abcd", "abcdb"));
        Utils.print(r.repeatedStringMatch("abcd", "bcdab"));
    }

    public int repeatedStringMatch(String a, String b) {
        StringBuilder newA = new StringBuilder(a);
        final int[] next = KMP.getNext(b);
        int i = 1;
        // 终止长度就是  2*A+B  目前不知道这个终止长度是如何论证出来的的
        while (newA.length() <= a.length() * 2 + b.length()) {
            if (newA.length() >= b.length() && KMP.kmpSearch(newA.toString(), b, next) != -1) {
                return i;
            }
            newA.append(a);
            i++;
        }
        return -1;
    }
}
