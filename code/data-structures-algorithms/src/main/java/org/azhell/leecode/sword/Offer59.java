package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 59
 */
public class Offer59 {
    public static void main(String[] args) {
        Offer59 o = new Offer59();
        Utils.print(o.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));

        MaxQueue m = new MaxQueue();
        m.push_back(1);
        m.push_back(2);
        Utils.print(m.max_value());
        Utils.print(m.pop_front());
        Utils.print(m.max_value());
    }

    /**
     * 剑指 Offer 59 - I. 滑动窗口的最大值
     * 239. 滑动窗口最大值
     * <p>
     * 使用单调队列解题
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 防止数组为空
        if (n == 0) return new int[n];
        // 存储数据的索引
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            // 过去的元素只要小于最新的元素，那些元素就不可能再成为窗口的最大值了
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 判断队首元素【最大值】是否是需要移除的对象
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    /**
     * 剑指 Offer 59 - II. 队列的最大值
     * 还是可以使用单调双端队列
     */
    static class MaxQueue {
        // 维护最大值
        Deque<Integer> deque;
        // 存储元素
        Deque<Integer> queue;

        public MaxQueue() {
            this.deque = new ArrayDeque<>();
            this.queue = new ArrayDeque<>();
        }

        public int max_value() {
            return !deque.isEmpty() ? deque.peekFirst() : -1;
        }

        public void push_back(int value) {
            while (!deque.isEmpty() && value > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(value);
            queue.offerLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int ans = queue.pollFirst();
            if (!deque.isEmpty() && ans == deque.peekFirst()) {
                deque.pollFirst();
            }
            return ans;
        }
    }
}
