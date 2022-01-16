package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 240. 搜索二维矩阵 II
 * 从右上角看是一个二叉搜索树，只需要左侧和下侧遍历即可
 */
public class Offer04 {
    public static void main(String[] args) {
        Offer04 o = new Offer04();
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        Utils.print(o.findNumberIn2DArray(matrix, 5));
        Utils.print(o.findNumberIn2DArray(matrix, 20));
        Utils.print(o.findNumberIn2DArray(matrix, 16));
        Utils.print(o.findNumberIn2DArray(new int[][]{}, 0));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
