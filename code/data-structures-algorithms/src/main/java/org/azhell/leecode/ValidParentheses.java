package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 有效的括号
 * 栈的解法
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Utils.print(new ValidParentheses().isValid("()"));
        Utils.print(new ValidParentheses().isValid("()[]{}"));
        Utils.print(new ValidParentheses().isValid("(]"));
        Utils.print(new ValidParentheses().isValid("([)]"));
    }

    public boolean isValid(String s) {
        Deque<Character> characterStack = new ArrayDeque<>();
        // Stack字符串倒序入栈
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            // 两个小括号之间的ASCII相聚一，中括号和大括号则都是相距2
            if (!characterStack.isEmpty() &&
                    (characterStack.peek() - 1 == c ||
                            characterStack.peek() - 2 == c)) {
                characterStack.pop();
            } else characterStack.push(c);
        }
        return characterStack.isEmpty();
    }
}
