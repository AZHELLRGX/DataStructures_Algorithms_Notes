package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 997. 找到小镇的法官
 */
public class FindTheTownJudge {

    public static void main(String[] args) {
        FindTheTownJudge f = new FindTheTownJudge();
        Utils.print(f.findJudge(2, new int[][]{{1, 2}}));
        Utils.print(f.findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        Utils.print(f.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
    }

    public int findJudge(int n, int[][] trust) {
        // 一个数组记录相信他的人数
        int[] trustNums = new int[n];
        // 一个数组记录是否相信其他人
        boolean[] trustAny = new boolean[n];
        for (int[] ints : trust) {
            trustAny[ints[0] - 1] = true;
            trustNums[ints[1] - 1] += 1;
        }
        for (int i = 0; i < n; i++) {
            if (trustNums[i] == n - 1 && !trustAny[i]) {
                return i + 1;
            }
        }
        return -1;
    }
}
