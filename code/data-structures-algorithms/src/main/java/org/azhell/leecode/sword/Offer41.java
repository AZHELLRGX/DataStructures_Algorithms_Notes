package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * 295. 数据流的中位数
 * <p>
 * 用大顶堆+小顶堆方法，可以看作大顶堆是普通班，小顶堆是实验班。
 * 数量上时刻保持 小顶-大顶<=1（两堆相等或者小顶比大顶多一个）。
 * <p>
 * 新学生先入普通班（大顶堆），此时可能会失去平衡了，
 * 于是取大顶堆的第一个（班里最好的学生）加入实验班（小顶堆），
 * 判断若数量过多（不是等于或多一个），
 * 取第一个（实验班里最差的学生）到普通班（大顶堆）里。
 * 取中位数的时候，若两堆数量相等，则各取堆顶取平均，
 * 若小顶比大顶多一，则多的那一个就是中位数。
 */
public class Offer41 {
    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        Utils.print(m.findMedian());
        m.addNum(3);
        Utils.print(m.findMedian());
    }

    static class MedianFinder {
        // 大顶堆
        PriorityQueue<Integer> largeQueue;
        // 小顶堆
        PriorityQueue<Integer> smallQueue;
        int numCnt = 0;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            largeQueue = new PriorityQueue<>((a, b) -> b - a);
            smallQueue = new PriorityQueue<>();
        }

        public void addNum(int num) {
            numCnt += 1;
            largeQueue.add(num);
            smallQueue.add(largeQueue.poll());
            if (smallQueue.size() != largeQueue.size()
                    && smallQueue.size() - 1 != largeQueue.size()) {
                largeQueue.add(smallQueue.poll());
            }
        }

        public double findMedian() {
            return numCnt % 2 == 0 ? (smallQueue.peek() + largeQueue.peek()) / 2.0 : smallQueue.peek();
        }
    }
}
