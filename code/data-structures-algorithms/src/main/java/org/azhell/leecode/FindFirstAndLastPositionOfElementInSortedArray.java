package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 依旧是二分查找法
 * 空间耗费有点高哈哈
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        Utils.print(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        Utils.print(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{1, 2, 3, 4, 5, 5, 7, 7, 8, 8, 10}, 7));
        Utils.print(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        Utils.print(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{}, 0));
        Utils.print(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{1, 3}, 1));
        Utils.print(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{1, 3, 4, 4}, 4));
        Utils.print(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{1, 3, 4, 4}, 1));
    }

    int begin = -1;
    int end = -1;

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{begin, end};
        } else if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{begin, end};
            }
        }

        int mid = (nums.length - 1) / 2;
        binarySearch(nums, 0, mid, target);
        binarySearch(nums, mid + 1, nums.length - 1, target);
        return new int[]{begin, end};
    }

    public void binarySearch(int[] nums, int start, int last, int target) {
        // 注意这是两个if语句，因为数据是可能重复的
        if (nums[start] == target && (start < begin || begin == -1)) {
            begin = start;
        }
        if (nums[last] == target && end < last) {
            end = last;
        }

        if (start < last && nums[start] <= target && nums[last] >= target) {
            int mid = (last + start) / 2;
            binarySearch(nums, start, mid, target);
            binarySearch(nums, mid + 1, last, target);
        }
    }
}
