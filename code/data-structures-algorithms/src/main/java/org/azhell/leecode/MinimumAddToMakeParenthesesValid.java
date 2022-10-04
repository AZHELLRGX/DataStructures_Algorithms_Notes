package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 921. 使括号有效的最少添加
 * 栈
 */
public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        MinimumAddToMakeParenthesesValid m = new MinimumAddToMakeParenthesesValid();
        Utils.print(m.minAddToMakeValid("())"));
        Utils.print(m.minAddToMakeValid("((("));
    }

    public int minAddToMakeValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!deque.isEmpty() && ')' == c && deque.peek() == '(')
                deque.poll();
            else deque.push(c);
        }
        return deque.size();
    }
}
