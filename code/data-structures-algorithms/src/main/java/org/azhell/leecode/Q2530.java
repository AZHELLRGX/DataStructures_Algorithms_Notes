package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2530. 执行 K 次操作后的最大分数
 * 大顶堆
 */
public class Q2530 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 3, 3, 3};
        Utils.print(new Q2530().maxKelements(nums, 3));
    }

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        for (int num : nums) {
            priorityQueue.add(num);
        }
        long sum = 0;
        for (int i = 0; i < k; i++) {
            Integer poll = priorityQueue.poll();
            if (poll != null) {
                sum += poll;
                priorityQueue.offer((int) Math.ceil(poll * 1.0 / 3));
            }
        }
        return sum;
    }
}
