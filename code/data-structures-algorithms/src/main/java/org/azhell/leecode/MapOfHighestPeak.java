package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1765. 地图中的最高点
 * DFS
 * 从水域地方开始搜索
 */
public class MapOfHighestPeak {
    public static void main(String[] args) {
        MapOfHighestPeak m = new MapOfHighestPeak();
        Utils.print(m.highestPeak(new int[][]{{0, 1}, {0, 0}}));
        Utils.print(m.highestPeak(new int[][]{{0, 0, 1}, {1, 0, 0}, {0, 0, 0}}));
        Utils.print(m.highestPeak(new int[][]{{1}}));
    }

    int[][] result;
    int[][] isWater;
    int m;
    int n;

    public int[][] highestPeak(int[][] isWater) {
        this.m = isWater.length;
        this.n = isWater[0].length;
        this.result = new int[m][n];
        this.isWater = isWater;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    // 开始搜索  老版本废弃
                    // bfs(i, j, 0)
                    queue.addLast(new int[]{i, j});
                } else {
                    result[i][j] = -1;
                }
            }
        }
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] ints = queue.pollFirst();
            int i = ints[0];
            int j = ints[1];
            for (int[] dir : dirs) {
                int newI = i - dir[0];
                int newJ = j - dir[1];
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && result[newI][newJ] == -1) {
                    result[newI][newJ] = result[i][j] + 1;
                    queue.addLast(new int[]{newI, newJ});
                }
            }
        }
        return result;
    }

    // 老的版本是超时的，暴力方法简单但是性能很差
    private void bfs(int i, int j, int v) {
        // 周围的四个格子
        int newV = v + 1;
        if (fill(i - 1, j, newV)) {
            bfs(i - 1, j, newV);
        }
        if (fill(i + 1, j, newV)) {
            bfs(i + 1, j, newV);
        }
        if (fill(i, j - 1, newV)) {
            bfs(i, j - 1, newV);
        }
        if (fill(i, j + 1, newV)) {
            bfs(i, j + 1, newV);
        }
    }

    private boolean fill(int i, int j, int v) {
        // 只要没有超出边界、不为水域、且没有指定高度或者高度低于当前高度那么就可以填充
        if (i >= 0 && i < m && j >= 0 && j < n && isWater[i][j] != 1 && (result[i][j] == 0 || v < result[i][j])) {
            result[i][j] = v;
            return true;
        } else {
            return false;
        }
    }
}
