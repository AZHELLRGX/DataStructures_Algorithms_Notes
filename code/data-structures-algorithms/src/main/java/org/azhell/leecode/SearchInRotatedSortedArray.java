package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 搜索旋转排序数组
 * 二分查找法
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Utils.print(new SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        Utils.print(new SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 3}, 3));
        Utils.print(new SearchInRotatedSortedArray().search(new int[]{1, 2}, 3));
        Utils.print(new SearchInRotatedSortedArray().search(new int[]{6, 7, 8, 9, 10, 1, 2, 3, 4, 5}, 3));
        Utils.print(new SearchInRotatedSortedArray().search(new int[]{1}, 0));
        Utils.print(new SearchInRotatedSortedArray().search(new int[]{5, 1, 2, 3, 4}, 1));
    }

    private int index = -1;

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        int mid = (nums.length - 1) / 2;
        binarySearch(nums, 0, mid, target);
        binarySearch(nums, mid + 1, nums.length - 1, target);
        return index;
    }

    public void binarySearch(int[] nums, int start, int last, int target) {
        if (index != -1) {
            return;
        }
        if (nums[start] == target) {
            index = start;
            return;
        } else if (nums[last] == target) {
            index = last;
            return;
        }

        if ((nums[start] < nums[last] && nums[start] < target && nums[last] > target) ||
                (nums[start] > nums[last])) {
            int mid = (last + start) / 2;
            binarySearch(nums, start, mid, target);
            binarySearch(nums, mid + 1, last, target);
        }
    }
}
