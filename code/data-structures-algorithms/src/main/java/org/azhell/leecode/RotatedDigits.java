package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 788. 旋转数字
 * 这道题一开始没看懂题意，其实数字的旋转就是物理意义上的旋转
 * 分析后可以知道"好数"的规则：
 * 1、数字的每一位都必须是0，1，8，2，5，6，9中的任意一个数字
 * 2、为了保证旋转后不是自身，还必须要包含2，5，6，9中的任意一个数字
 */
public class RotatedDigits {
    public static void main(String[] args) {
        RotatedDigits r = new RotatedDigits();
        Utils.print(r.rotatedDigits(2));
        Utils.print(r.rotatedDigits(10));
    }


    public int rotatedDigits(int n) {
        int xCnt = 0;
        Set<Character> shouldBeSet = new HashSet<>(Arrays.asList('0', '1', '2', '5', '6', '8', '9'));
        Set<Character> shouldContainsSet = new HashSet<>(Arrays.asList('2', '5', '6', '9'));
        for (int i = 0; i <= n; i++) {
            String s = String.valueOf(i);
            boolean a = true;
            boolean b = false;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!shouldBeSet.contains(c)) {
                    a = false;
                    break;
                } else if (!b && shouldContainsSet.contains(c)) {
                    b = true;
                }
            }
            if (a && b) xCnt += 1;
        }
        return xCnt;
    }
}
