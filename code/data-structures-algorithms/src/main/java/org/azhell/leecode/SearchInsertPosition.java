package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 搜索插入位置
 * 要求O(log n) 的算法
 * 所以依旧是二分查找
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        Utils.print(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 5));
        Utils.print(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 2));
        Utils.print(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 7));
        Utils.print(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 0));
        Utils.print(new SearchInsertPosition().searchInsert(new int[]{1}, 1));
        Utils.print(new SearchInsertPosition().searchInsert(new int[]{1, 3}, 1));
        Utils.print(new SearchInsertPosition().searchInsert(new int[]{3, 5, 7, 9, 10}, 8));
        Utils.print(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5}, 3));
    }

    // 应该还是找一个区间而不是一个索引
    private int begin = -1;
    private int end = -1;

    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) {
            return 0;
        } else if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int mid = (nums.length - 1) / 2;
        binarySearch(nums, 0, mid, target);
        binarySearch(nums, mid + 1, nums.length - 1, target);
        // 区间初始位置数据与target一致，否则直接使用end索引
        if (begin != -1 && target == nums[begin]) {
            return begin;
        }
        return end;
    }

    public void binarySearch(int[] nums, int start, int last, int target) {
        // 找到一个尽可能靠近的区间
        if (nums[last] <= target && begin < last) {
            begin = last;
        }
        if (nums[start] >= target && (end > start || end == -1)) {
            end = start;
        }

        if (start < last && nums[start] < target && nums[last] > target) {
            int mid = (last + start) / 2;
            binarySearch(nums, start, mid, target);
            binarySearch(nums, mid + 1, last, target);
        }
    }
}
