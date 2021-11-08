package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 * todo 明天再做
 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {6, 9}
        };
        Utils.print(new InsertInterval().insert(intervals, new int[]{2, 5}));
        Utils.print(new InsertInterval().insert(new int[][]{}, new int[]{2, 5}));
        Utils.print(new InsertInterval().insert(new int[][]{{1, 5}}, new int[]{2, 5}));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0) {
            intervals = new int[][]{newInterval};
        } else {
            int[][] tempInternal = new int[intervals.length][2];
            int j = 0;
            for (int i = 0; i < intervals.length; i++) {
                if (intervals[i][0] >= newInterval[0]) {
                    tempInternal[i] = newInterval;
                    j = i;
                    break;
                } else {
                    tempInternal[i] = intervals[i];
                }
            }
            for (int i = j; i < intervals.length; i++) {
                tempInternal[i + 1] = intervals[i];
            }

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
