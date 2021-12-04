package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. 最长有效括号
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses l = new LongestValidParentheses();
        Utils.print(l.longestValidParentheses(")()((())"));
        Utils.print(l.longestValidParentheses("(()"));
        Utils.print(l.longestValidParentheses(""));
    }

    private static class IndexCharacter {
        int i;
        char c;

        IndexCharacter(int i, char c) {
            this.i = i;
            this.c = c;
        }
    }

    public int longestValidParentheses(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        // ")()((())"
        Deque<IndexCharacter> deque = new ArrayDeque<>();
        int[] flagArray = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            // 每当压入一个数据就判断栈顶的数据是否与之匹配
            final char c = s.charAt(i);
            if (deque.isEmpty()) {
                deque.push(new IndexCharacter(i, c));
            } else {
                // 形成 ”()“
                if (c - deque.peek().c == 1) {
                    // 字符对应的两个位置置为1
                    flagArray[i] = 1;
                    flagArray[deque.poll().i] = 1;
                } else {
                    deque.push(new IndexCharacter(i, c));
                }
            }
        }
        // 找出最长的连续1的个数
        int maxLength = 0;
        int curLength = 0;
        for (int i : flagArray) {
            if (i == 1) {
                curLength += 1;
            } else {
                curLength = 0;
            }
            maxLength = Math.max(curLength, maxLength);
        }
        return maxLength;
    }
}
