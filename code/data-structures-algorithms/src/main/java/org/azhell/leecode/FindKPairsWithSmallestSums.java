package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.*;

/**
 * 373. 查找和最小的K对数字
 * 多路归并排序 还是借助堆
 */
public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        FindKPairsWithSmallestSums f = new FindKPairsWithSmallestSums();
        Utils.print(f.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        Utils.print(f.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
        Utils.print(f.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));
        Utils.print(f.kSmallestPairs(new int[]{0, 0, 0, 0, 0, 2, 2, 2, 2}, new int[]{-3, 22, 35, 56, 76}, 22));
    }


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        List<List<Integer>> result = new ArrayList<>();
        // 多路归并排序存储的都是数据索引
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                Comparator.comparing(arr -> nums1[arr[0]] + nums2[arr[1]]));
        // 先压入一部分数据
        for (int i = 0; i < Math.min(n, k); i++) {
            priorityQueue.add(new int[]{i, 0});
        }
        while (result.size() < k && !priorityQueue.isEmpty()) {
            final int[] poll = priorityQueue.poll();
            result.add(Arrays.asList(nums1[poll[0]], nums2[poll[1]]));
            if (poll[1] + 1 < m)
                priorityQueue.add(new int[]{poll[0], poll[1] + 1});
        }
        return result;
    }
}
