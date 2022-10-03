package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1784. 检查二进制字符串字段
 * 今天这道题的题目真长啊
 * 思路是双指针，这道题的意思就是不能有多个1组成的串
 * 所以只需要从前往后搜索到第一个0（第一个字符肯定是1）
 * 从后往前搜索到第一个1，对比两个位置是否相邻即可
 */
public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    public static void main(String[] args) {
        CheckIfBinaryStringHasAtMostOneSegmentOfOnes c = new CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
        Utils.print(c.checkOnesSegment("1001"));
        Utils.print(c.checkOnesSegment("110"));
    }

    public boolean checkOnesSegment(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < s.length() && s.charAt(i) != '0') {
            i++;
        }
        while (j > 0 && s.charAt(j) != '1') {
            j--;
        }
        return i == j + 1;
    }
}
