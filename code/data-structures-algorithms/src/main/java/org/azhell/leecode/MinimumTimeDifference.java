package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.Arrays;
import java.util.List;

/**
 * 539. 最小时间差
 * 做题做魔怔了，有排序都不敢用
 * 鸽巢原理 当时间数量大于1440的时候，一定存在两个完全一样的时间，可以直接返回0
 */
public class MinimumTimeDifference {
    public static void main(String[] args) {
        MinimumTimeDifference m = new MinimumTimeDifference();
        Utils.print(m.findMinDifference(Arrays.asList("23:59", "00:01")));
        Utils.print(m.findMinDifference(Arrays.asList("00:00", "23:59", "00:00")));
    }

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() >= 1440) {
            return 0;
        }
        // 下面的代码其实复杂了，可以直接使用 Collections.sort(timePoints) 代替
        timePoints.sort((t1, t2) -> {
            final String[] a1 = t1.split(":");
            final String[] a2 = t2.split(":");
            int h1 = Integer.parseInt(a1[0]);
            int h2 = Integer.parseInt(a2[0]);
            if (h1 > h2) {
                return 1;
            } else if (h1 < h2) {
                return -1;
            } else {
                int m1 = Integer.parseInt(a1[1]);
                int m2 = Integer.parseInt(a2[1]);
                return -Integer.compare(m2, m1);
            }
        });
        final String s = timePoints.get(0);
        final String[] t = s.split(":");
        final int hour = Integer.parseInt(t[0]) + 24;
        int minDiff = getTimeDiff(timePoints.get(timePoints.size() - 1), hour + ":" + t[1]);
        for (int i = 0; i < timePoints.size() - 1; i++) {
            final int timeDiff = getTimeDiff(timePoints.get(i), timePoints.get(i + 1));
            minDiff = Math.min(timeDiff, minDiff);
        }
        return minDiff;
    }

    private int getTimeDiff(String t1, String t2) {
        final String[] a1 = t1.split(":");
        final String[] a2 = t2.split(":");
        final int time1 = Integer.parseInt(a1[0]) * 60 + Integer.parseInt(a1[1]);
        final int time2 = Integer.parseInt(a2[0]) * 60 + Integer.parseInt(a2[1]);
        return time2 - time1;
    }

}
