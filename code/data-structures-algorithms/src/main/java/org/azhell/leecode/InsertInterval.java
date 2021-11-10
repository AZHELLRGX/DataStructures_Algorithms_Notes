package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {6, 9}
        };
        Utils.print(new InsertInterval().insert(intervals, new int[]{2, 5}));
        Utils.print(new InsertInterval().insert(new int[][]{{1, 5}}, new int[]{2, 3}));
        Utils.print(new InsertInterval().insert(new int[][]{}, new int[]{5, 7}));
        intervals = new int[][]{
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };
        Utils.print(new InsertInterval().insert(intervals, new int[]{4, 8}));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }


        List<int[]> result = new ArrayList<>();
        // 使用插入排序
        int[][] intervalsTemp = new int[intervals.length + 1][2];
        if (newInterval.length > 0) {
            int k = 0;
            while (k < intervals.length && intervals[k][0] < newInterval[0]) {
                intervalsTemp[k] = intervals[k];
                k++;
            }
            intervalsTemp[k] = newInterval;
            System.arraycopy(intervals, k, intervalsTemp, k + 1, intervals.length - k);
            intervals = intervalsTemp;
        }
        int[] tempArray = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (tempArray[1] >= intervals[i][0]) {
                // 保留两个区间较大的end值
                tempArray[1] = Math.max(tempArray[1], intervals[i][1]);
            } else {
                result.add(tempArray);
                tempArray = intervals[i];
            }
        }
        result.add(tempArray);
        return result.toArray(new int[0][]);
    }
}
