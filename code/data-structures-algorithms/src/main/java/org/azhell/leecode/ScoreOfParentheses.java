package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 856. 括号的分数
 */
public class ScoreOfParentheses {
    public static void main(String[] args) {
        ScoreOfParentheses s = new ScoreOfParentheses();
        Utils.print(s.scoreOfParentheses("(())"));
        Utils.print(s.scoreOfParentheses("(()(()))"));
        Utils.print(s.scoreOfParentheses("((()(()))((())))"));
    }

    public int scoreOfParentheses(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deque.push(0);
            } else {
                int cur = deque.poll();
                deque.push(deque.poll() + Math.max(cur * 2, 1));
            }
        }
        return deque.poll();
    }
}

