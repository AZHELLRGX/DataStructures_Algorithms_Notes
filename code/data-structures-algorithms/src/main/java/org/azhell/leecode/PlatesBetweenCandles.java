package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 2055. 蜡烛之间的盘子
 * 动态规划
 */
public class PlatesBetweenCandles {
    public static void main(String[] args) {
        PlatesBetweenCandles p = new PlatesBetweenCandles();
        //
        Utils.print(p.platesBetweenCandles("***|**|*****|**||**|*", new int[][]{
                {1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}
        }));
        Utils.print(p.platesBetweenCandles("**|**|***|", new int[][]{
                {2, 5}, {5, 9}
        }));
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        // 盘子左侧最近的蜡烛
        int[] lCandles = new int[len];
        // 盘子右侧最近的蜡烛
        int[] rCandles = new int[len];
        // 盘子左边的所有蜡烛
        int[] platesNum = new int[len];
        int leftCandlesIndex = -1;
        int rightCandlesIndex = len;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 左侧
            if (c == '*') {
                platesNum[i] += (i - 1 >= 0 ? platesNum[i - 1] : 0) + 1;
            } else if (c == '|') {
                leftCandlesIndex = i;
                platesNum[i] += (i - 1 >= 0 ? platesNum[i - 1] : 0);
            }
            lCandles[i] = leftCandlesIndex;
            // 右侧
            int right = len - i - 1;
            c = s.charAt(right);
            if (c == '|') {
                rightCandlesIndex = right;
            }
            rCandles[right] = rightCandlesIndex;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = rCandles[queries[i][0]];
            int end = lCandles[queries[i][1]];
            if (start != -1 && end != len && start < end) {
                ans[i] = platesNum[end] - platesNum[start];
            }
        }
        return ans;
    }
}
