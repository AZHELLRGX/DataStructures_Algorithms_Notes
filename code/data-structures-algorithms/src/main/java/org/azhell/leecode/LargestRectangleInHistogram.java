package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 * 试用单调栈【递增】解题
 * 加入哨兵模式
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        Utils.print(l.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        Utils.print(l.largestRectangleArea(new int[]{2, 4}));
        Utils.print(l.largestRectangleArea(new int[]{2, 1, 2}));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) {
            return heights[0];
        }
        int maxArea = 0;
        Deque<Pillar> deque = new ArrayDeque<>();
        // 前置哨兵
        deque.push(new Pillar(0, -1));
        for (int i = 0; i < heights.length; i++) {
            maxArea = calArea(new Pillar(i + 1, heights[i]), deque, maxArea);
        }
        // 后置哨兵
        maxArea = calArea(new Pillar(heights.length + 1, -1), deque, maxArea);
        return maxArea;
    }

    private int calArea(Pillar pillar, Deque<Pillar> deque, int maxArea) {
        // 因为有哨兵，所以不需要判空
        while (pillar.height < deque.peek().height) {
            Pillar pop = deque.pop();
            maxArea = Math.max(maxArea, pop.height * (pillar.index - deque.peek().index - 1));
        }
        deque.push(pillar);
        return maxArea;
    }

    static class Pillar {
        int index;
        int height;

        Pillar(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

}
