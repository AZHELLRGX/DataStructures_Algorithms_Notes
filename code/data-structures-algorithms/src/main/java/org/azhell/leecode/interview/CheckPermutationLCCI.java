package org.azhell.leecode.interview;

import org.azhell.tool.Utils;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * 此题虽然非常简单，但是还是需要找到巧解
 */
public class CheckPermutationLCCI {
    public static void main(String[] args) {
        CheckPermutationLCCI c = new CheckPermutationLCCI();
        Utils.print(c.checkPermutation("abc", "bca"));
    }

    public boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        // 题目没有确定字符的类型，直接按照ascII字符数量申请128大小的数组
        int[] ascii = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            ascii[s1.charAt(i)]++;
            ascii[s2.charAt(i)]--;
        }
        for (int i : ascii) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
