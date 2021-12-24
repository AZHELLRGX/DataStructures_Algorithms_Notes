package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1705. 吃苹果的最大数目
 * 这个问题与630的解法差不多
 * 也是贪心 + 优先队列的算法
 * <p>
 * 每次找一个快过期的苹果吃掉的思路
 */
public class MaximumNumberOfEatenApples {

    public static void main(String[] args) {
        MaximumNumberOfEatenApples m = new MaximumNumberOfEatenApples();
        Utils.print(m.eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
        Utils.print(m.eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2}));
        Utils.print(m.eatenApples(new int[]{2, 1, 1, 4, 5}, new int[]{10, 10, 6, 4, 2}));
    }

    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        final int n = apples.length;
        int res = 0;
        int day = 0;
        while (day < n || !priorityQueue.isEmpty()) {
            if (day < n && apples[day] > 0)
                // 过期日期，苹果数
                priorityQueue.offer(new int[]{days[day] + day - 1, apples[day]});
            // 将已经过期的苹果扔掉
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] < day) priorityQueue.poll();
            // 从中取出一个快要过期的苹果吃掉
            if (!priorityQueue.isEmpty()) {
                final int[] poll = priorityQueue.poll();
                poll[1] -= 1;
                res += 1;
                if (poll[1] > 0) {
                    // 没吃完的苹果再放回去
                    priorityQueue.offer(poll);
                }
            }
            day++;
        }
        return res;
    }
}
