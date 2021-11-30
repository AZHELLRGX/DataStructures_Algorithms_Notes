package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.PriorityQueue;

/**
 * 786. 第 K 个最小的素数分数
 * 20211129 每日一题
 * 解法：学习优先队列的使用
 * 优先队列是用堆实现的一种数据结构，队列优先顺序可以自定义，此题的优先顺序就是大小值
 */
public class KthSmallestPrimeFraction {
    public static void main(String[] args) {
        final KthSmallestPrimeFraction k = new KthSmallestPrimeFraction();
        Utils.print(k.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3));
        Utils.print(k.kthSmallestPrimeFraction(new int[]{1, 7}, 1));
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // 因为直接比较分数涉及到浮点数操作，性能比较差
        // 所以可以使用 a * d < b * c 来代替 a/b < c/d
        // 队列中的数据记录的是i和j
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                (arr1, arr2) ->
                        arr[arr1[0]] * arr[arr2[1]] - arr[arr2[0]] * arr[arr1[1]]);
        // 初始化这个初始队列
        for (int i = 1; i < arr.length; i++) {
            priorityQueue.add(new int[]{0, i});
        }
        // 不断的使用最小值的下一个顺位来替代最小数据，替换到k的时候，此时poll出来的就是需要的结果
        int j = 0;
        while (j < k - 1) {
            int[] temp = priorityQueue.poll();
            if (temp != null && temp[0] + 1 < temp[1]) {
                priorityQueue.add(new int[]{temp[0] + 1, temp[1]});
            }
            j++;
        }
        final int[] poll = priorityQueue.poll();
        if (poll != null) {
            return new int[]{arr[poll[0]], arr[poll[1]]};
        }
        return new int[]{};
    }
}
