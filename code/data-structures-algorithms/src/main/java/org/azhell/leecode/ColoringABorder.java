package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1034. 边界着色
 * BFS 或者 DFS
 */
public class ColoringABorder {
    public static void main(String[] args) {
        ColoringABorder coloringABorder = new ColoringABorder();
        Utils.print(coloringABorder.colorBorder(new int[][]{
                {1, 1},
                {1, 2}
        }, 0, 0, 3));
        Utils.print(coloringABorder.colorBorder(new int[][]{
                {1, 2, 2},
                {2, 3, 2}
        }, 0, 1, 3));
        Utils.print(coloringABorder.colorBorder(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        }, 1, 1, 2));
        // [[1,2,1,2,1,2],[2,2,2,2,1,2],[1,2,2,2,1,2]]
        // [[1,1,1,1,1,2],[1,2,1,1,1,2],[1,1,1,1,1,2]]
        Utils.print(coloringABorder.colorBorder(new int[][]{
                {1, 2, 1, 2, 1, 2},
                {2, 2, 2, 2, 1, 2},
                {1, 2, 2, 2, 1, 2}
        }, 1, 3, 1));
    }

    // 记录边界  1表示已经被识别为连通分量的网格 2表示边界  0就是其他网格
    int[][] border;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        border = new int[grid.length][grid[0].length];
        // 1、先找出边界
        // 从row、col位置开始搜索
        colorBorder(grid, row, col);
        // 2、再给边界上色
        for (int i = 0; i < border.length; i++) {
            for (int j = 0; j < border[i].length; j++) {
                if (border[i][j] == 2) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    // 开始搜索
    private void colorBorder(int[][] grid, int row, int col) {
        int value = grid[row][col];
        for (int i = Math.max(row - 1, 0); i <= row + 1 && i < grid.length; i++) {
            colorBorderHelper(grid, i, col, value);
        }
        for (int j = Math.max(col - 1, 0); j <= col + 1 && j < grid[0].length; j++) {
            colorBorderHelper(grid, row, j, value);
        }
    }

    // 提取共同函数
    private void colorBorderHelper(int[][] grid, int row, int col, int value) {
        if (border[row][col] == 0 && grid[row][col] == value) {
            // 判断是否已经到了边界
            if (isBorder(grid, row, col)) {
                border[row][col] = 2;
            } else {
                border[row][col] = 1;
            }
            colorBorder(grid, row, col);
        }
    }

    // 是否是边界
    private boolean isBorder(int[][] grid, int row, int col) {
        int value = grid[row][col];
        if (row == 0 || col == 0 || row == grid.length - 1 || col == grid[0].length - 1)
            return true;
        else {
            for (int i = row - 1; i <= row + 1; i++) {
                if (grid[i][col] != value) {
                    return true;
                }
            }
            for (int j = col - 1; j <= col + 1; j++) {
                if (grid[row][j] != value) {
                    return true;
                }
            }
        }
        return false;
    }
}
