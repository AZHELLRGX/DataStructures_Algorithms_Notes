package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739. 每日温度
 * 直接想到用单调栈解题
 * 单调栈一般用于解决 第一个大于 xxx 或者 第一个小于 xxx 这种题目。
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        Utils.print(d.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        Utils.print(d.dailyTemperatures(new int[]{30, 40, 50, 60}));
        Utils.print(d.dailyTemperatures(new int[]{30, 60, 90}));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        // 存温度的序列
        Deque<Integer> deque = new ArrayDeque<>();
        for (int j = 0; j < temperatures.length; j++) {
            while (!deque.isEmpty() && temperatures[deque.peek()] < temperatures[j]) {
                int pop = deque.pop();
                ans[pop] = j - pop;
            }
            deque.push(j);
        }
        ans[ans.length - 1] = 0;
        return ans;
    }
}
