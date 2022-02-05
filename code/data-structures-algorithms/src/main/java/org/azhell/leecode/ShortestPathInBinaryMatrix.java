package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1091. 二进制矩阵中的最短路径
 * BFS广度优先搜索
 * BFS可以很好的与队列这种数据结构进行结合
 * 另外一个很重要的点就是要记录哪些节点已经被访问过
 */
public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        ShortestPathInBinaryMatrix s = new ShortestPathInBinaryMatrix();
        Utils.print(s.shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
        Utils.print(s.shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        Utils.print(s.shortestPathBinaryMatrix(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        Utils.print(s.shortestPathBinaryMatrix(new int[][]{{0}}));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        // 八个方向
        int[][] dirs = new int[][]{{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{0, 0, 1});
        grid[0][0] = 1; // 将已经走过的点标记为不可访问
        while (!queue.isEmpty()) {
            int[] array = queue.pollFirst();
            int i = array[0];
            int j = array[1];
            int step = array[2];
            if (i == n - 1 && j == n - 1) {
                return step;
            }
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];

                if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                    queue.add(new int[]{x, y, step + 1});
                    grid[x][y] = 1;
                }
            }
        }
        return -1;
    }
}
