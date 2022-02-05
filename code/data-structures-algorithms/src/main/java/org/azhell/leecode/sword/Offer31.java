package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * 946. 验证栈序列
 * 模拟题
 * 根据弹出序列模拟压入方式
 */
public class Offer31 {
    public static void main(String[] args) {
        Offer31 o = new Offer31();
        Utils.print(o.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        Utils.print(o.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 1, 2}));
        Utils.print(o.validateStackSequences(new int[]{4, 0, 1, 2, 3}, new int[]{4, 2, 3, 0, 1}));
        Utils.print(o.validateStackSequences(new int[]{}, new int[]{}));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Deque<Integer> stack = new ArrayDeque<>();
        int popIndex = 0;
        int pushIndex = 0;
        while (popIndex < popped.length || !stack.isEmpty()) {
            while (pushIndex < pushed.length && (stack.peek() == null || popped[popIndex] != stack.peek())) {
                stack.push(pushed[pushIndex++]);
            }
            if ((stack.peek() == null || popped[popIndex] != stack.peek())) {
                return false;
            }
            stack.pop();
            popIndex++;
        }
        return true;
    }
}
