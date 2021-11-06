package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 旋转图像
 * 层次对角线旋转
 */
public class RotateImage {
    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateImage.rotate(matrix);
        Utils.print(matrix);
        matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotateImage.rotate(matrix);
        Utils.print(matrix);
        matrix = new int[][]{{1}};
        rotateImage.rotate(matrix);
        Utils.print(matrix);
        matrix = new int[][]{{1, 2}, {3, 4}};
        rotateImage.rotate(matrix);
        Utils.print(matrix);
    }

    public void rotate(int[][] matrix) {
        int[] auxiliaryArray = new int[matrix.length * matrix.length];
        // 按行读，按列填
        int k = 0;
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                auxiliaryArray[k++] = ints[j];
            }
        }
        k = 0;
        for (int j = matrix.length - 1; j >= 0; j--) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = auxiliaryArray[k++];
            }
        }
    }
}
