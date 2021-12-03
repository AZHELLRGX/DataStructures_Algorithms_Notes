package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 81. 搜索旋转排序数组 II
 * 还是二分查找，但是需要注意重复元素的问题
 * 计算效率比较低，但是懒得优化了
 */
public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        SearchInRotatedSortedArray2 search = new SearchInRotatedSortedArray2();
        Utils.print(search.search(new int[]{1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1}, 13));
        Utils.print(search.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        Utils.print(search.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        Utils.print(search.search(new int[]{2}, 1));
    }

    public boolean search(int[] nums, int target) {
        // 先找到数据的拐点，然后将数据去重
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                k = i;
                break;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = k; i < nums.length; i++) {
            if (list.isEmpty() || !list.get(list.size() - 1).equals(nums[i])) {
                list.add(nums[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            if (list.isEmpty() || !list.get(list.size() - 1).equals(nums[i])) {
                list.add(nums[i]);
            }
        }
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target) {
                return true;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
