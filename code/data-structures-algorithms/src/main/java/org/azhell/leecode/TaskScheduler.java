package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.*;

/**
 * 621. 任务调度器
 * 优先队列
 * 这里面有个思路很重要，冷冻时间解除的任务才应该放回优先队列
 */
public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler t = new TaskScheduler();
        Utils.print(t.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if (n == 0) {
            return len;
        }
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.cnt - a.cnt);
        for (char task : tasks) {
            map.put(task, map.computeIfAbsent(task, key -> 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        Pair none = new Pair(' ', 0);
        Deque<Pair> deque = new ArrayDeque<>(n + 1);
        int ans = 0;
        while (len > 0) {
            ans += 1;
            if (!queue.isEmpty()) {
                len -= 1;
                // 有任务可以执行
                final Pair poll = queue.poll();
                // 更新个数
                if (poll.cnt != 1) {
                    poll.cnt -= 1;
                    deque.offerLast(poll);
                } else {
                    deque.offerLast(none);
                }
            } else {
                // 待机
                deque.offerLast(none);
            }
            if (deque.size() == n + 1) {
                final Pair pair = deque.pollFirst();
                if (pair != none) {
                    queue.offer(pair);
                }
            }
        }
        return ans;
    }

    static class Pair {
        char c;
        int cnt;

        Pair(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }
}
