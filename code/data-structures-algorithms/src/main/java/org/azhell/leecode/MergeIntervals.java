package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * 判断区间是否可以合并的唯一准则就是前一个区间的end小于等于另外一个区间的start
 * 先按照区间的start排序
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {9, 18},
                {1, 3},
                {2, 6},
                {8, 10},
        };
        Utils.print(new MergeIntervals().merge(intervals));
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        // 使用系统自带排序  元素少于47个使用插入排序，否则使用快排
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
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
