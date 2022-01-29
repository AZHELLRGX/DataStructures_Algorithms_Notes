package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();
        Utils.print(f.findMin(new int[]{3, 4, 5, 1, 2}));
        Utils.print(f.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        Utils.print(f.findMin(new int[]{4, 5, 6, 7, 0, 1, 2, 3}));
        Utils.print(f.findMin(new int[]{11, 13, 15, 17}));
        Utils.print(f.findMin(new int[]{11}));
        Utils.print(f.findMin(new int[]{5, 1, 2, 3, 4}));
        Utils.print(f.findMin(new int[]{2, 3, 4, 5, 1}));
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
