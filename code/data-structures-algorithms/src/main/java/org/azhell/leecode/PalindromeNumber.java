package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.Stack;

/**
 * 回文数
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        Utils.print(isPalindrome(10));
    }

    private static boolean isPalindrome(int x) {
        // 负数不是回文数
        if (x < 0) return false;
        // 0~9的数据直接返回
        if (x <= 9) return true;
        // 感觉可以使用栈，出栈顺序与源数据相等即可
        Stack<Integer> stack = new Stack<>();
        int multiple = 10;
        int bak = x;
        int index = 1;
        while (x >= multiple) {
            stack.push(x % multiple);
            x /= multiple;
            index++;
        }
        stack.push(x);
        int y = 0;
        multiple = 1;
        for (int i = 0; i < index; i++) {
            y += stack.pop() * multiple;
            multiple *= 10;
        }
        return bak == y;
    }
}
