package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 583. 两个字符串的删除操作
 * 其实这道题就是对1143的扩充
 * 因为只能进行删除操作，所以当最后剩下的相同数据是最长公共子序列的时候，删除操作最少
 */
public class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        DeleteOperationForTwoStrings d = new DeleteOperationForTwoStrings();
        Utils.print(d.minDistance("sea", "eat"));
        Utils.print(d.minDistance("leetcode", "etco"));
    }

    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * getLongestCommonSubsequence(word1, word2);
    }

    LongestCommonSubsequence l = new LongestCommonSubsequence();

    private int getLongestCommonSubsequence(String text1, String text2) {
        return l.longestCommonSubsequence(text1, text2);
    }
}
