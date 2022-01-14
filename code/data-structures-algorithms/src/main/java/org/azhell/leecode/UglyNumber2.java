package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 264. 丑数 II
 * 前20个丑数为：1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 24, 25, 27, 30, 32, 36。
 * 任何丑数乘2,3,5后依然是丑数
 * 所以使用多路归并思想解题
 */
public class UglyNumber2 {
    public static void main(String[] args) {
        UglyNumber2 u = new UglyNumber2();
        Utils.print(u.nthUglyNumber(10));
        Utils.print(u.nthUglyNumber(1));
        Utils.print(u.nthUglyNumber(20));
        Utils.print(u.nthUglyNumber(1407));
    }

    public int nthUglyNumber(int n) {
        int[] arr = new int[]{2, 3, 5};
        // 使用集合去重
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        // 初始化
        priorityQueue.add(1L);
        int i = 0;
        int ugly = 1;
        while (i < n && !priorityQueue.isEmpty()) {
            long poll = priorityQueue.poll();
            ugly = (int) poll;
            for (int a : arr) {
                long temp = a * poll;
                if (!set.contains(temp)) {
                    priorityQueue.add(temp);
                    set.add(temp);
                }
            }
            i++;
        }
        return ugly;
    }
}
