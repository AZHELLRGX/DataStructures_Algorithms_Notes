package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 630. 课程表 III
 * 贪心算法 + 优先队列
 * 优先队列可以使用堆来实现，堆是一种完全二叉树
 * 最大优先队列可以用最大堆实现 最小优先队列使用最小堆
 * 大堆或者小堆都可以使用数组来实现
 * 当然如果不是直接考察数据结构的算法，可以借助Java对象PriorityQueue来实现
 * <p>
 * 算法：
 * https://leetcode-cn.com/problems/course-schedule-iii/solution/ke-cheng-biao-iii-by-leetcode-solution-yoyz/
 */
public class CourseSchedule3 {
    public static void main(String[] args) {
        CourseSchedule3 c = new CourseSchedule3();
        Utils.print(c.scheduleCourse(new int[][]{
                {100, 200},
                {200, 1300},
                {1000, 1250},
                {2000, 3200}
        }));
        Utils.print(c.scheduleCourse(new int[][]{
                {1, 2}
        }));
        Utils.print(c.scheduleCourse(new int[][]{
                {3, 2},
                {4, 3}
        }));
        Utils.print(c.scheduleCourse(new int[][]{
                {1, 2},
                {2, 3}
        }));
        Utils.print(c.scheduleCourse(new int[][]{{7, 17}, {3, 12}, {10, 20}, {9, 10}, {5, 20}, {10, 19}, {4, 18}}));
    }

    public int scheduleCourse(int[][] courses) {
        // 现将课程按照结束时间排序
        Arrays.sort(courses, Comparator.comparingInt(c -> c[1]));
        // 构建一个优先队列【大根堆】来维护耗时最长的课程
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((c1, c2) -> c2[0] - c1[0]);
        // 时间轴
        int day = 0;
        for (int[] cours : courses) {
            // 如果当前课程满足在结束时间完成前上完的条件
            if (day + cours[0] <= cours[1]) {
                priorityQueue.offer(cours);
                // 时间轴往后挪
                day += cours[0];
            }
            // 课程冲突，但是还可以继续判断是否有已经选择的课程持续时间比当前课程长，如果有则可以替换，保证修习相同数量的课程花费的时间最少
            // 这个时候不需要担心cours是否可以修完，因为当前课程的截止时间一定比队列中所有课程都要靠后
            else if (!priorityQueue.isEmpty() && priorityQueue.peek()[0] > cours[0]) {
                // 时间轴需要往前移
                day -= priorityQueue.poll()[0] - cours[0];
                // 将堆顶元素移出，将当前元素插入【自动下沉】
                priorityQueue.offer(cours);
            }
        }
        return priorityQueue.size();
    }
}
