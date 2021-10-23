package org.azhell.leecode;

import org.azhell.tool.Utils;


/**
 * 实现 strStr()
 * 其实也就是找出字符串B在字符串A中出现的最早位置
 * 使用KMP算法
 * 1、先构造字符串B的部分匹配值列表
 * 2、计算移动位数，公式为移动位数 = 已匹配的字符数 - 对应的部分匹配值
 * 超时问题
 */
public class Implement_strStr {
    public static void main(String[] args) {
        String haystack = "BBC ABCDAB ABCDABCDABDE";
        String needle = "ABCDABD";
        Utils.print(new Implement_strStr().strStr(haystack, needle));
        haystack = "hello";
        needle = "ll";
        Utils.print(new Implement_strStr().strStr(haystack, needle));
        haystack = "aabaaabaaac";
        needle = "aabaaac";
        Utils.print(new Implement_strStr().strStr(haystack, needle));
        haystack = "babbbbbabb";
        needle = "bbab";
        Utils.print(new Implement_strStr().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        // 如果haystack为空，needle不为空
        if (haystack.length() < needle.length()) {
            return -1;
        }
        // 构建needle的部分匹配值列表
        int[] array = getPartialMatchValueList(needle);
        // 开始进行字符串匹配
        int i = 0;
        while (i < haystack.length()) {
            // 开始逐位匹配
            int j = 0;
            int k = i;
            while (k < haystack.length() && j < needle.length()) {
                if (haystack.charAt(k) == needle.charAt(j)) {
                    k++;
                    j++;
                } else {
                    break;
                }
            }

            // 如果已经匹配完成
            if (j == needle.length()) {
                return i;
            } else {
                // 调用部分匹配值列表，移动i
                if (j == 0)
                    i++;
                else {
                    int moveNum = j - array[j - 1];
                    i += moveNum;
                }

            }
        }
        return -1;
    }

    private int[] getPartialMatchValueList(String needle) {
        int[] array = new int[needle.length()];
        array[0] = 0;
        if (needle.length() == 1)
            return array;
        // 开始构造部分匹配值列表
        for (int i = 1; i < needle.length(); i++) {
            String prefix = needle.substring(0, i + 1);
            array[i] = commonElement(prefix);
        }
        return array;
    }

    private int commonElement(String subStr) {
        for (int i = 1; i < subStr.length(); i++) {
            String s = subStr.substring(0, subStr.length() - i);
            if (s.equals(subStr.substring(i))) {
                return s.length();
            }
        }
        return 0;
    }
}
