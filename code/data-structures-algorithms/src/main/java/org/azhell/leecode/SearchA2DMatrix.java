package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 74. 搜索二维矩阵
 * 二分查找
 */
public class SearchA2DMatrix {
    public static void main(String[] args) {
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        Utils.print(searchA2DMatrix.searchMatrix(matrix, 13));
        Utils.print(searchA2DMatrix.searchMatrix(matrix, 3));
        Utils.print(searchA2DMatrix.searchMatrix(new int[][]{{1}}, 1));
        Utils.print(searchA2DMatrix.searchMatrix(new int[][]{{1, 3}}, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        if (target < matrix[0][0] || target > matrix[m][n]) {
            return false;
        }
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            // Prevent (left + right) overflow
            // 防止大数溢出
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] <= target && matrix[mid][n] >= target) {
                // 在这个数组，继续二分查找
                return searchMatrixHelper(matrix[mid], target);
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public boolean searchMatrixHelper(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // Prevent (left + right) overflow
            // 防止大数溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
