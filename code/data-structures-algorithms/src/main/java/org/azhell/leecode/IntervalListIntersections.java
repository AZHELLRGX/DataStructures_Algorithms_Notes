package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 986. 区间列表的交集
 * 双指针
 */
public class IntervalListIntersections {
    public static void main(String[] args) {
        IntervalListIntersections i = new IntervalListIntersections();
        Utils.print(i.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}));
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[][]{};
        }
        List<int[]> result = new ArrayList<>();
        int fPoint = 0;
        int sPoint = 0;
        int[] fArray;
        int[] sArray;
        while (fPoint < firstList.length && sPoint < secondList.length) {
            fArray = firstList[fPoint];
            sArray = secondList[sPoint];
            int leftRange = Math.max(fArray[0], sArray[0]);
            int rightRange = Math.min(fArray[1], sArray[1]);
            if (leftRange <= rightRange) {
                result.add(new int[]{leftRange, rightRange});
            }
            if (fArray[1] < sArray[1]) {
                fPoint += 1;
            } else {
                sPoint += 1;
            }
        }
        return result.toArray(new int[0][0]);
    }
}
