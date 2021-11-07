package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 动态边界法
 * 什么时候转向全由边界控制
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Utils.print(new SpiralMatrix().spiralOrder(matrix));
        matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        Utils.print(new SpiralMatrix().spiralOrder(matrix));
        matrix = new int[][]{
                {3},
                {2}
        };
        Utils.print(new SpiralMatrix().spiralOrder(matrix));
    }

    List<Integer> result;
    int eleCount;

    public List<Integer> spiralOrder(int[][] matrix) {
        eleCount = matrix.length * matrix[0].length;
        result = new ArrayList<>(eleCount);
        // 矩阵行列
        int m = matrix.length;
        int n = matrix[0].length;
        spiralOrderHandle(matrix, m, n, 0);
        return result;
    }

    public void spiralOrderHandle(int[][] matrix, int m, int n, int level) {
        if (result.size() >= eleCount) {
            return;
        }
        // 一共三个转向位置，(level,n) (m,n) (m,level)
        for (int i = level; i < n; i++) {
            result.add(matrix[level][i]);
        }
        if (result.size() >= eleCount) {
            return;
        }
        for (int i = level + 1; i < m; i++) {
            result.add(matrix[i][n - 1]);
        }
        if (result.size() >= eleCount) {
            return;
        }
        for (int i = n - 2; i >= level; i--) {
            result.add(matrix[m - 1][i]);
        }
        for (int i = m - 2; i > level; i--) {
            result.add(matrix[i][level]);
        }

        // 然后进入内层，传入一个level，需要在(level,level)开始遍历，(1+level,level)结束遍历
        spiralOrderHandle(matrix, m - 1, n - 1, level + 1);
    }
}
