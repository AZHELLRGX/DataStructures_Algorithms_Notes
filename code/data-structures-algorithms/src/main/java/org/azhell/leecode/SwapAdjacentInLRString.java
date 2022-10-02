package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 777. 在LR字符串中交换相邻字符
 * 双指针运用题
 */
public class SwapAdjacentInLRString {
    public static void main(String[] args) {
        SwapAdjacentInLRString s = new SwapAdjacentInLRString();
        Utils.print(s.canTransform("RXXLRXRXL", "XRLXXRRLX"));
        Utils.print(s.canTransform("X", "L"));
        Utils.print(s.canTransform("XL", "LX"));
        Utils.print(s.canTransform("XLR", "LXR"));
        Utils.print(s.canTransform("XLLR", "LXLX"));
        Utils.print(s.canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
    }

    /*
    在选择要用什么算法之前，需要梳理几个原则：
    1、start和end中R和L的数量一定是一样的
    2、start和end中R和L的相对位置一定是不变的
    3、start中第i个R一定在end的i位置或者i的右边，而start中第i个L一定在end的i位置或者i的左边

    所以本题使用双指针就变成了：
    1、指定指针i,j分别为start,end的下标，并且遍历start和end，遇到X跳过
    2、如果start[i] != end[j] 直接返回false
    3、如果start[i] == end[j]，如果当前字符是R，则必须满足i<=j，如果是L，则必须满足i>=j
     */
    public boolean canTransform(String start, String end) {
        int i = 0;
        int j = 0;
        int n = start.length();
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i += 1;
            }
            while (j < n && end.charAt(j) == 'X') {
                j += 1;
            }
            if ((i == n && j != n) || (i != n && j == n)) {
                return false;
            }
            if (i < n && j < n) {
                char a = start.charAt(i);
                char b = end.charAt(j);
                if (a != b || (a == 'R' && i > j) || (a == 'L' && i < j)) {
                    return false;
                }
                i += 1;
                j += 1;
            }
        }
        return i == j;
    }

    // 以下是错误思路，以为L和R只能移动一位，企图使用简单模拟来做，结果是有问题的
    public boolean canTransform1(String start, String end) {
        // 题目说明了len(start) = len(end)，所以不需要判断
        int n = start.length();
        int i = 0;
        while (i < n) {
            char a = start.charAt(i);
            char b = end.charAt(i);
            i += 1;
            if (a != b) {
                if (i == n) {
                    return false;
                }
                char c = start.charAt(i);
                char d = end.charAt(i);
                if ((a != 'X' || c != 'L' || b != 'L' || d != 'X')
                        && (a != 'R' || c != 'X' || b != 'X' || d != 'R')) {
                    return false;
                }
                i += 1;
            }
        }
        return true;
    }
}
