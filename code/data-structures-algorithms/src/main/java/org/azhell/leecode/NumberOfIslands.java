package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 200. 岛屿数量
 * 有一个感染函数的巧妙说法
 * 只要找到一个'1'，就将岛屿数量+1，然后将与这个'1'相连的'1'都置为'2'
 * 下次遍历到这个'2'就不需要处理了
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands n = new NumberOfIslands();
        Utils.print(n.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));
        Utils.print(n.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }

    int m;
    int n;
    char[][] grid;

    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans += 1;
                    // 进入感染函数
                    numIslands(i, j);
                }
            }
        }
        return ans;
    }

    private void numIslands(int i, int j) {
        if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '1') {
            grid[i][j] = '2';
            numIslands(i - 1, j);
            numIslands(i + 1, j);
            numIslands(i, j + 1);
            numIslands(i, j - 1);
        }
    }
}
