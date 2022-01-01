package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 2022. 将一维数组转变成二维数组
 * 2022元旦，新年快乐
 */
public class Convert1DArrayInto2DArray {
    public static void main(String[] args) {
        Convert1DArrayInto2DArray c = new Convert1DArrayInto2DArray();
        Utils.print(c.construct2DArray(new int[]{1, 2, 3, 4}, 2, 2));
        Utils.print(c.construct2DArray(new int[]{1, 2, 3}, 1, 3));
        Utils.print(c.construct2DArray(new int[]{1, 2}, 1, 1));
        Utils.print(c.construct2DArray(new int[]{3}, 1, 2));
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        } else {
            int[][] mn = new int[m][n];
            for (int i = 0; i < original.length; i++) {
                mn[i / n][i % n] = original[i];
            }
            return mn;
        }
    }
}
